/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Profesional;

import bd.Profesional;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transaccion.TPaciente;
import transaccion.TProfesional;
import utilitarios.PathCfg;

/**
 *
 * @author Diego
 */
@WebServlet(name="ProfesionalesEditServlet",urlPatterns={PathCfg.PROFESIONALES_EDIT})
public class ProfesionalesEditServlet extends HttpServlet {

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
            Integer prof_id = Integer.parseInt(request.getParameter("prof_id"));
            Profesional profesional = new TProfesional().getById(prof_id);
            request.setAttribute("profesional", profesional);
        } catch(NumberFormatException ex){
        }
        request.getRequestDispatcher("profesionales_edit.jsp").forward(request, response);
        return;
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
        Profesional profesional = new TProfesional().recuperarInstancia(request.getParameterMap());
        Integer prof_id = 0;
        if(profesional!=null){            
            try{
                prof_id = Integer.parseInt(request.getParameter("prof_id"));
            }catch(NumberFormatException ex){
                prof_id = 0;
            }
            if ( prof_id > 0){
                todoOk = new TProfesional().actualizar(profesional, "prof_id");
            } else {                
               todoOk = new TProfesional().alta(profesional) != 0;
            }
        }
        if(todoOk){
            response.sendRedirect(PathCfg.PROFESIONALES_PATH);
            return;
        }else{ 
            response.sendRedirect(PathCfg.PROFESIONALES_EDIT+ "?prof_id=" + prof_id);
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
