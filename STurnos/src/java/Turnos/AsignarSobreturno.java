/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Turnos;

import bd.Agenda;
import bd.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transaccion.TAgenda;
import transaccion.TTurno;
import utilitarios.PathCfg;

/**
 *
 * @author Diego
 */
@WebServlet(name="AsignarSobreturno",urlPatterns={PathCfg.ASIGNAR_SOBRETURNO})
public class AsignarSobreturno extends HttpServlet {


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
        try{
            int agenda_id = Integer.parseInt(request.getParameter("agenda_id"));
            
            String turno_id = request.getParameter("turno_id");
            Turno turno = null;
            if(turno_id!=null){
                turno = new TTurno().getById(Integer.parseInt(turno_id));                
            }
            if (turno==null) turno = new Turno();  
            request.setAttribute("turno", turno);
            
            Agenda agenda = new TAgenda().getById(agenda_id);
            if ( agenda!=null)
                request.setAttribute("agenda", agenda);
            request.getRequestDispatcher("asignar_sobreturno.jsp").forward(request,response);
        } catch(NumberFormatException ex){
            
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
      // processRequest(request, response);
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
