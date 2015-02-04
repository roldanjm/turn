/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Turnos;

import bd.Agenda;
import java.io.IOException;
import java.io.PrintWriter;
import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transaccion.TAgenda;
import utilitarios.PathCfg;

/**
 *
 * @author Diego
 */
@WebServlet(name="TurnosServlet",urlPatterns={PathCfg.TURNOS_PATH})
public class TurnosServlet extends HttpServlet {

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
       
        try{
            int agenda_id = Integer.parseInt(request.getParameter("agenda_id"));
            Agenda agenda = new TAgenda().getById(agenda_id);
            if (agenda!=null){
                request.setAttribute("agenda",agenda);
            }else{
                // Redirect a una pagina de error
                
            }
        } catch(NumberFormatException nf){

        }
        try{
            Integer agenda_id = Integer.parseInt(request.getParameter("agenda_id"));
            Agenda agenda = new TAgenda().getById(agenda_id);
            if (agenda != null){ 
                request.setAttribute("agenda",agenda);
                request.getRequestDispatcher("turnos.jsp").forward(request,response);
            }
        }catch(NumberFormatException ex){
            
        }
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
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
        processRequest(request, response);
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
        processRequest(request, response);
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
