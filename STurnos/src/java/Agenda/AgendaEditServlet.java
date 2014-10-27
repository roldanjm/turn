/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import bd.Agenda;
import bd.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transaccion.TAgenda;
import transaccion.TTurno;
import utilitarios.PathCfg;
import utils.TFecha;

/**
 *
 * @author Diego
 */
@WebServlet(name="AgendaEditServlet",urlPatterns={PathCfg.AGENDA_EDIT})
public class AgendaEditServlet extends HttpServlet {

    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int agenda_id = 0;
        Agenda agenda = null;
        try{
            agenda_id = Integer.parseInt(request.getParameter("agenda_id"));
            agenda = new TAgenda().getById(agenda_id);
            System.out.println(agenda);
           
        }catch(NumberFormatException ex){
            
        } 
        if (agenda == null){ 
                agenda = new Agenda();
        }
        request.setAttribute("agenda", agenda);
        request.getRequestDispatcher("agenda_edit.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean todoOk = false;
        Agenda agenda = new TAgenda().recuperarInstancia(request.getParameterMap());
        agenda.setAgenda_alta(TFecha.ahora());
        Integer id = 0;
        int agenda_intervalo = 15;
        if(agenda!=null){            
            try{
                id = Integer.parseInt(request.getParameter("agenda_id"));
                agenda_intervalo = Integer.parseInt(request.getParameter("agenda_intervalo"));
            }catch(NumberFormatException ex){
                id = 0;
            }
            if ( id > 0){
                todoOk = new TAgenda().actualizar(agenda, "agenda_id");
            } else {    
               id = new TAgenda().alta(agenda);    
               todoOk = id !=0;
               if (todoOk) {
                   agenda.setAgenda_id(id);
                    List<Turno> listaTurnos = new TAgenda().getListaTurnos(agenda, agenda_intervalo);
                    TTurno tTurno = new TTurno();
                    
                    for(Turno turno:listaTurnos){
                         tTurno.alta(turno);                         
                    }
               }
            }
        }
        if(todoOk){
            response.sendRedirect(PathCfg.AGENDA_PATH);
            return;
        }else{ 
            response.sendRedirect(PathCfg.AGENDA_EDIT+ "?agenda_id=" + id);
        }
        return;                      
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
