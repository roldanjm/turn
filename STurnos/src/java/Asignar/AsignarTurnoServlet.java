package Asignar;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import bd.Agenda;
import bd.Asignar;
import bd.Paciente;
import bd.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transaccion.TAgenda;
import transaccion.TAsignar;
import transaccion.TPaciente;
import transaccion.TTurno;
import utilitarios.CustomHttpServlet;
import utilitarios.PathCfg;
import utils.TFecha;

/**
 *
 * @author Diego
 */
@WebServlet(name="AsignarTurnoServlet",urlPatterns={PathCfg.ASIGNAR_TURNO})
public class AsignarTurnoServlet extends HttpServlet {

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
        Asignar asignar = null;
        try{
//            int asignar_id = Integer.parseInt(request.getParameter("asignar_id"));
            int turno_id = Integer.parseInt(request.getParameter("turno_id"));
//            asignar = new TAsignar().getById(asignar_id);            
            Turno turno = new TTurno().getById(turno_id);
            if (turno!=null){
                request.setAttribute("turno", turno);
            }
        }catch(NumberFormatException ex){

        }        
//        if (asignar == null) asignar = new Asignar();
        request.getRequestDispatcher("asignar_turno.jsp").forward(request, response);
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
           
        try{
            Asignar asignar = new Asignar();
            int turno_id = Integer.parseInt(request.getParameter("turno_id"));
            int pac_id = Integer.parseInt(request.getParameter("pac_id"));
            TTurno tturno = new TTurno();
            Turno turno = tturno.getById(turno_id);
            Paciente paciente = new TPaciente().getById(pac_id);
            if (turno!=null & paciente!=null) {
                asignar.setTurno_id(turno_id);
                asignar.setPac_id(pac_id);
                asignar.setAsignar_fecha(TFecha.ahora());
                int asignar_id = new TAsignar().alta(asignar);
                if(asignar_id != 0){
                    turno.setTurno_estado(1);
                    tturno.actualizar(turno);
                    // Actualizamos la cantidad de turnos disponibles
                    Agenda agenda = new TAgenda().getById(turno.getAgenda_id());
                    agenda.setAgenda_turn_asig(agenda.getAgenda_turn_asig() + 1);
                    new TAgenda().actualizar(agenda);
                    response.sendRedirect(PathCfg.TURNOS_PATH+"?agenda_id=" + turno.getAgenda_id());                
                }
            }
        }catch(NumberFormatException ex){
            
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
