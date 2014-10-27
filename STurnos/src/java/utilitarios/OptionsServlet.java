/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utilitarios;

import bd.Bd_localidad;
import bd.Especialidad;
import bd.Profesional;
import bd.TipoTurno;
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
import transaccion.TProfesional;
import transaccion.TTipoTurno;

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
        List<Opcion> lstOpciones = new ArrayList();
        String type =  request.getParameter("type");        
        if (type.equalsIgnoreCase("Especialidades")){
            lstOpciones = getListEspecialidades();
        }
        else if (type.equalsIgnoreCase("Localidades")){
            try{
                int prov_id = Integer.parseInt(request.getParameter("prov_id"));
                lstOpciones = getListLocalidades(prov_id);                 
            } catch(NumberFormatException nfe){ } 
                        
        } if (type.equalsIgnoreCase("Profesionales")){
            lstOpciones = getListProgesionales();
        } if (type.equalsIgnoreCase("TipoTurno")){
            lstOpciones = getListTipoTurno();
        } if (type.equalsIgnoreCase("EstadoTurno")){
            lstOpciones = getListEstadoTurno();
        }else {
       
        }
                
        try {
            
          if(lstOpciones!=null) {
            jr.setResult("OK");
            jr.setOptions(lstOpciones);
          } else {
              jr.setResult("OK");
          }
           out.println(new Gson().toJson(jr));
        } finally {            
            out.close();
        }
    }

    private List<Opcion> getListEspecialidades(){
        List<Opcion> lstOpciones = null;
        List<Especialidad> list = new TEspecialidad().getList();
            
        if (list!=null){
          lstOpciones = new ArrayList();              
          for (Especialidad esp:list){
              lstOpciones.add(new Opcion(esp.getEspec_id(),esp.getEspec_detalle()));                  
          }              
        } 
        return lstOpciones;
    }
    private List<Opcion> getListLocalidades(Integer prov_id){
        List<Opcion> lstOpciones = null;
        List<Bd_localidad> list = new TLocalidad().getList(prov_id);
        
        if (list!=null){
          lstOpciones = new ArrayList();
          for (Bd_localidad loc:list){
              lstOpciones.add(new Opcion(loc.getLoc_id(),loc.getLoc_descripcion()));
          }                  
        }        
        return lstOpciones;
    }
    private List<Opcion> getListProgesionales(){
        List<Opcion> lstOpciones = null;
        List<Profesional> list = new TProfesional().getList();                
            if (list!=null){
                lstOpciones = new ArrayList();
                for (Profesional prof:list){
                    lstOpciones.add(new Opcion(prof.getProf_id(),prof.getProf_apellido() + ", " + prof.getProf_nombre()));
                }                  
            }            
        return lstOpciones;
    }
    private List<Opcion> getListTipoTurno() {
        List<Opcion> lstOpciones = null;
        List<TipoTurno> list = new TTipoTurno().getList();        
        if (list!=null){
            lstOpciones = new ArrayList();
            for (TipoTurno turno:list){
                lstOpciones.add(new Opcion(turno.getTturno_id(),turno.getTturno_descripcion()));
            }                  
        }            
        return lstOpciones;
    }
    private List<Opcion> getListEstadoTurno(){
        List<Opcion> lstOpciones = new ArrayList();
        lstOpciones.add(new Opcion(0,"Creado"));
        lstOpciones.add(new Opcion(1,"Asignado"));
        lstOpciones.add(new Opcion(2,"En espera"));
        lstOpciones.add(new Opcion(3,"Finalizado"));
        lstOpciones.add(new Opcion(4,"No disponible"));        
        
        return lstOpciones;
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

