/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import bd.Agenda;
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
import transaccion.TAgenda;
import utilitarios.JsonRespuesta;
import utilitarios.PathCfg;
import utils.TFecha;

/**
 *
 * @author Diego
 */
@WebServlet(name="AgendaListServlet",urlPatterns={PathCfg.AGENDA_LIST})
public class AgendaListServlet extends HttpServlet {

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
            int  prof_id = 0;
            String agenda_dia = "";
            try{
                prof_id = Integer.parseInt(request.getParameter("prof_id"));
                agenda_dia = TFecha.formatearFecha(request.getParameter("agenda_dia"),TFecha.formatoVista,TFecha.formatoVista);
            } catch(NumberFormatException ex){ }
            
            List<Agenda> lista = new TAgenda().getList(procesarParametros(request));//getListByProf(prof_id);
            if (lista != null) {
                jr.setTotalRecordCount(lista.size());                  
            } else {
                jr.setTotalRecordCount(0);
            }            
            jr.setResult("OK");
            jr.setRecords(lista);
            
            String jsonResult = new Gson().toJson(jr);
            System.out.println(jsonResult);
            out.print(jsonResult);
        } finally {            
            out.close();
        } 
 }
 private HashMap<String,String> procesarParametros(HttpServletRequest request){
     HashMap<String,String> filtro = new HashMap<String,String>();
//     String key = "";
//     for(Enumeration<String> names = request.getParameterNames();names.hasMoreElements();key = names.nextElement()){
//        filtro.put(key, request.getParameter(key));
//        System.out.println(key + " -> " + request.getParameter(key) );
//    }
    if(request.getParameter("prof_id")!=null){    
        filtro.put("prof_id", request.getParameter("prof_id"));
    }
    if(request.getParameter("agenda_dia")!=null){     
        filtro.put("agenda_dia",TFecha.formatearFecha(request.getParameter("agenda_dia"),TFecha.formatoVista,TFecha.formatoBD));
    }
     return filtro;
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
       processRequest(request,response);
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
       processRequest(request,response);
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
