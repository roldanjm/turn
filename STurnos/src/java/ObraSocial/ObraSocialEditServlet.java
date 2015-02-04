/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ObraSocial;

import bd.Obra_social;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transaccion.TObraSocial;
import utilitarios.JsonRespuesta;
import utilitarios.PathCfg;

/**
 *
 * @author Diego
 */
@WebServlet(name="ObraSocialEditServlet",urlPatterns={PathCfg.OBRASOCIAL_EDIT})
public class ObraSocialEditServlet extends HttpServlet {

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
            out.println("<title>Servlet ObraSocialEditServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ObraSocialEditServlet at " + request.getContextPath() + "</h1>");
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
        JsonRespuesta jr = new JsonRespuesta();        
        TObraSocial tos = new TObraSocial();
        
        boolean alta = request.getParameter("os_id") == null;        

            Obra_social os = tos.recuperarInstancia(request.getParameterMap());
            if (alta) {
                tos.alta(os);
            } else {
                tos.actualizar(os);
            }
            
            jr.setResult("OK");
            jr.setRecord(os);
        
        String toJson = new Gson().toJson(jr);
        System.out.println(toJson);
        PrintWriter out = response.getWriter();
        try{
            out.println(toJson);
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
