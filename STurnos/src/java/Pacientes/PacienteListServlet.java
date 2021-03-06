package Pacientes;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import bd.Paciente;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transaccion.TPaciente;
import utilitarios.CustomHttpServlet;
import utilitarios.JsonRespuesta;
import utilitarios.PathCfg;

/**
 *
 * @author Diego
 */
@WebServlet(name = "PacienteListServlet", urlPatterns = {PathCfg.PACIENTES_LIST})
public class PacienteListServlet extends CustomHttpServlet {

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
            JsonRespuesta jr = new JsonRespuesta();
            
            List<Paciente> lista = new TPaciente().getListFiltro(procesarFiltro(request));
            
            if (lista != null) {
                    jr.setTotalRecordCount(lista.size());                  
                } else {
                    jr.setTotalRecordCount(0);
                }
            
            jr.setResult("OK");
            jr.setRecords(lista);

            Gson gson = new Gson();
            String jsonResult = gson.toJson(jr);            
            out.print(jsonResult);
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
