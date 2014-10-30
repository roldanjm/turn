/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Agenda;

import bd.Agenda;
import bd.Turno;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import transaccion.TAgenda;
import transaccion.TTurno;
import utilitarios.PathCfg;
import utils.TFecha;

/**
 *
 * @author Diego
 */
@WebServlet(name="AgendaEditServlet",urlPatterns={PathCfg.AGENDA_CREA})
public class AgendaCreaServlet extends HttpServlet {

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
        request.getRequestDispatcher("agenda_crea.jsp").forward(request, response);
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
        try {
            boolean todoOk = false;
            String desde = request.getParameter("agenda_dia_inicio");
            String hasta = request.getParameter("agenda_dia_fin");
            Integer prof_id = Integer.parseInt(request.getParameter("prof_id"));
            int agenda_intervalo = Integer.parseInt(request.getParameter("agenda_intervalo"));
            String agenda_consultorio = request.getParameter("agenda_consultorio");
            String hinicio = request.getParameter("agenda_hinicio");
            String hfin = request.getParameter("agenda_hfin");
            ArrayList filtroDias = new ArrayList();
            String[] lstDiasSem = request.getParameterValues("agenda_dia_sem");
            for(String dia_sem:lstDiasSem){
                try{
                    filtroDias.add(Integer.parseInt(dia_sem));
                }catch (NumberFormatException ex){}
            }
            
            SimpleDateFormat sdf = new SimpleDateFormat(TFecha.formatoVista);
            
            List<Date> listaDias = TFecha.getListaDias(sdf.parse(desde), sdf.parse(hasta),filtroDias);
            Integer id = 0;
            for(Date dia: listaDias){                                  
                   Agenda agenda  = new Agenda();
                   agenda.setAgenda_consultorio(agenda_consultorio);
                   agenda.setAgenda_alta(TFecha.ahora(TFecha.formatoBD));
                   agenda.setAgenda_dia(TFecha.formatearFecha(dia, TFecha.formatoBD));
                   agenda.setAgenda_intervalo(agenda_intervalo);
                   agenda.setAgenda_hinicio(hinicio);
                   agenda.setAgenda_hfin(hfin);
                   agenda.setProf_id(prof_id);
                    
                   id = new TAgenda().alta(agenda);
                   todoOk = id !=0;
                   if (todoOk) {
                       agenda.setAgenda_id(id);
                        List<Turno> listaTurnos = new TAgenda().getListaTurnos(agenda);
                        TTurno tTurno = new TTurno();                        
                        for(Turno turno:listaTurnos){
                             tTurno.alta(turno);                         
                        }
                   }                
            }
            if(todoOk){
                response.sendRedirect(PathCfg.AGENDA_PATH);
                return;
            }else{ 
                response.sendRedirect(PathCfg.AGENDA_EDIT+ "?agenda_id=" + id);
            }
            return;
        } catch (ParseException ex) {
            Logger.getLogger(AgendaCreaServlet.class.getName()).log(Level.SEVERE, null, ex);
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
