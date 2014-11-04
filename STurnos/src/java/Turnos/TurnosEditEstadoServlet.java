/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Turnos;

import bd.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transaccion.TTurno;
import utilitarios.PathCfg;

/**
 *
 * @author Diego
 */
@WebServlet(name="TurnosEditEstadoServlet",urlPatterns={PathCfg.TURNOS_EDIT_ESTADO})
public class TurnosEditEstadoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet TurnosEditEstadoServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet TurnosEditEstadoServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        } finally {            
            out.close();
        }
    }

    
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
                 //response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            
            Integer turno_id = Integer.parseInt(request.getParameter("turno_id"));
            Integer turno_estado = Integer.parseInt(request.getParameter("turno_estado"));       
            TTurno tTurno = new TTurno();
            Turno turno = tTurno.getById(turno_id);
            if (turno!=null){
                // Hacer cosas dependiendo el estado del turno.
                
                switch(turno_estado){
                    case 0:break;
                    case 1:break;
                    case 2:break;
                }
                turno.setTurno_estado(turno_estado);
                if (tTurno.actualizar(turno)){
                    out.write("OK");
                };                
            }
        } catch(NumberFormatException ex){
            
        } finally {            
            out.close();
        }         
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
