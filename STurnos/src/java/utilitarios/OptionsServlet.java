/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import bd.Bd_localidad;
import bd.Especialidad;
import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transaccion.TEspecialidad;
import transaccion.TLocalidad;

/**
 *
 * @author Diego
 */
@WebServlet(name="OptionsServlet",urlPatterns={PathCfg.OPTIONS}) 
public class OptionsServlet extends HttpServlet {

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
        JsonRespuesta jr = new JsonRespuesta();
        String type =  request.getParameter("type");
        if (type.equalsIgnoreCase("Especialidades")){
            List<Especialidad> list = new TEspecialidad().getList();
            List<Opcion> listaOpciones = new ArrayList();
            if (list!=null){
              jr.setResult("OK");
              
              for (Especialidad esp:list){
                  listaOpciones.add(new Opcion(esp.getEspec_id(),esp.getEspec_detalle()));                  
              }
              jr.setOptions(listaOpciones);
            } 
        }
        else if (type.equalsIgnoreCase("Localidades")){
            try{
                int prov_id = Integer.parseInt(request.getParameter("prov_id"));
            
                List<Bd_localidad> list = new TLocalidad().getList(prov_id);
                List<Opcion> listaOpciones = new ArrayList();
                if (list!=null){
                  jr.setResult("OK");

                  for (Bd_localidad loc:list){
                      listaOpciones.add(new Opcion(loc.getLoc_id(),loc.getLoc_descripcion()));
                  }
                  jr.setOptions(listaOpciones);
                }
            } catch(NumberFormatException nfe){
                
            } 
                        
        } else {
        
        }
                
                
        try {
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
    
    private class Opcion{
        private Opcion(int id,String disp){
            this.Value = "" + id;
            this.DisplayText = disp;
        }
        String DisplayText;
        String Value;
    }
}

