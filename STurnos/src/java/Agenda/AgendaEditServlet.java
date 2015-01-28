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
@WebServlet(name="AgendaEditSrv",urlPatterns={PathCfg.AGENDA_EDIT})
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
        
        int agenda_id;
        Agenda agenda = null;
        boolean actualizar = true;
        try{
            agenda_id = Integer.parseInt(request.getParameter("agenda_id"));
            agenda = new TAgenda().getById(agenda_id);
            actualizar = agenda_id != 0? puedeActualizar(agenda_id):false;
        }catch(NumberFormatException ex){ } 
        if (agenda == null){             
            response.sendRedirect(PathCfg.AGENDA_PATH);
            return;
        }else {
            request.setAttribute("agenda", agenda);
            request.setAttribute("actualizar",actualizar);
            request.getRequestDispatcher("agenda_edit.jsp").forward(request, response);
        }
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
        agenda.setAgenda_dia(TFecha.formatearFecha(request.getParameter("agenda_dia"), TFecha.formatoVista, TFecha.formatoBD));
        TAgenda ta = new TAgenda();
        Integer id = 0;
        int agenda_intervalo = 15;
        
        try{
            id = Integer.parseInt(request.getParameter("agenda_id"));
            agenda_intervalo = Integer.parseInt(request.getParameter("agenda_intervalo"));
        }catch(NumberFormatException ex){ }

        if ( id > 0){           
            if(puedeActualizar(id)){       
                List<Turno> lstTurnos = new TTurno().getListAgenda(id); // Recupero la lista de turnos de la agenda
                for(Turno turno:lstTurnos){
                    // Borramos los turnos
                    new TTurno().baja(turno);
                }
                agenda.setAgenda_turn_cant(lstTurnos.size());
                agenda.setAgenda_turn_asig(lstTurnos.size());
                
                todoOk = ta.actualizar(agenda, "agenda_id");
                //Creamos los nuevos turnos
                List<Turno> listaTurnos = ta.getListaTurnos(agenda);
                TTurno tTurno = new TTurno();

                for(Turno turno:listaTurnos){
                     tTurno.alta(turno);                         
                }

            }else{} 
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
    
    public boolean puedeActualizar(Integer agenda_id){
        List<Turno> lstTurnos = new TTurno().getListAgenda(agenda_id); // Recupero la lista de turnos de la agenda
        boolean puedeActualizar  = true;

        if (lstTurnos==null){ 
            puedeActualizar = true;
        } else {
            for(Turno turno:lstTurnos){ //Chequeo que no haya ningún turno asignado
                if(turno.getTurno_estado()!=0) {
                    puedeActualizar = false;
                    break;                    
                }
            }
        }   
        return puedeActualizar;
    }
}
