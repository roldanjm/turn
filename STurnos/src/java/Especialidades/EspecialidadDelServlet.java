/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Especialidades;

import bd.Especialidad;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transaccion.TEspecialidad;
import utilitarios.JsonRespuesta;
import utilitarios.PathCfg;

/**
 *
 * @author Diego
 */
@WebServlet(name="EspecialidadDelServlet",urlPatterns={PathCfg.ESPECIALIDADES_DEL})
public class EspecialidadDelServlet extends HttpServlet {

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
            String espec_id = request.getParameter("espec_id");
            int id = Integer.parseInt(espec_id);
            TEspecialidad te = new TEspecialidad();
            JsonRespuesta jr = new JsonRespuesta();
            boolean todoOk = true;
            if(id!=0){
                Especialidad esp = te.getById(id);
                if (esp!=null) {
                    todoOk = te.baja(esp);
                } else todoOk = false;                            
            } else todoOk = false;
            
            if (todoOk){
                jr.setResult("OK");
            }
            else {
                jr.setResult("ERROR");
                jr.setMessage("No se pudo eliminar la especialidad");                
            }
            out.println(new Gson().toJson(jr));
        } finally {            
            out.close();
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
