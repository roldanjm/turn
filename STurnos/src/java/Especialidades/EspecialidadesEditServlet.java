/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Especialidades;

import bd.Especialidad;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
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
@WebServlet(name="EspecialidadesEditServlet",urlPatterns={PathCfg.ESPECIALIDADES_EDIT})
public class EspecialidadesEditServlet extends HttpServlet {

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
        JsonRespuesta jr = new JsonRespuesta();        
        TEspecialidad te = new TEspecialidad();
        Map<String, String> resultMap = te.checkEdit(request.getParameterMap());
        boolean alta = request.getParameter("espec_id") == null;        
        String  result = resultMap.get("result");
        if (result != null && result.equals("Ok")){
            Especialidad esp = te.recuperarInstancia(request.getParameterMap());
            if (alta) {
                te.alta(esp);
            } else {
                te.actualizar(esp);
            }
            
            jr.setResult("OK");
            jr.setRecord(esp);
        } else{
            jr.setResult("ERROR");
            String mensaje = "";
            for (String k : resultMap.keySet()){
                mensaje += resultMap.get(k);
            }
            jr.setMessage(mensaje);
        }        
        String toJson = new Gson().toJson(jr);
        System.out.println(toJson);
        PrintWriter out = response.getWriter();
        try{
            out.println(toJson);
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
