/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Pacientes;

import bd.Paciente;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transaccion.TPaciente;
import utilitarios.PathCfg;
import utils.TFecha;

/**
 *
 * @author Diego
 */
@WebServlet(name="PacienteEditServlet",urlPatterns={PathCfg.PACIENTES_EDIT})
public class PacienteEditServlet extends HttpServlet {

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
           int pac_id = Integer.parseInt(request.getParameter("pac_id"));
           Paciente paciente = new TPaciente().getById(pac_id);
           if (paciente != null){
               request.setAttribute("paciente", paciente);
           }
       } catch (NumberFormatException ex){
       
       }                
       request.getRequestDispatcher("pacientes_edit.jsp").forward(request, response);
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
        Paciente paciente = new TPaciente().recuperarInstancia(request.getParameterMap());
        if(paciente!=null){
            Integer pac_id = 0;        
            try{
                pac_id = Integer.parseInt(request.getParameter("pac_id"));
            }catch(NumberFormatException ex){
                pac_id = 0;
            }
            if ( pac_id > 0){
                todoOk = new TPaciente().actualizar(paciente, "pac_id");
            } else {
                paciente.setPac_fechaalta(TFecha.ahora("yyyy-MM-dd"));
               todoOk = new TPaciente().alta(paciente) != 0;
            }
        }
        if(todoOk){
            response.sendRedirect(PathCfg.PACIENTES_PATH);
            return;
        }else{
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
