/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;

import bd.Agenda;
import bd.Asignar;
import bd.Turno;
import java.util.ArrayList;
import java.util.List;
import utils.TFecha;

/**
 *
 * @author Diego
 */
public class TAgenda extends TransaccionBase<Agenda>{
    public List<Agenda>getList(){
        String query = "select * from agenda";
        return super.getList(query);
    }   
    public Agenda getById(Integer id){
        String query = String.format("select * from agenda where agenda.agenda_id = %d" , id);
        return super.getById(query);
    }
        public List<Agenda> getListByProf(Integer prof_id){
        String where = "";
        if (prof_id != 0){
            where += String.format("where agenda.prof_id = %d",prof_id);
        }
        String query = String.format("select * from agenda %s",where);
        return this.getList(query);                
    }
    
    public boolean actualizar(Agenda agenda){
        return super.actualizar(agenda, "agenda_id");
    }
      public List<Turno> getListaTurnos(Agenda agenda, long intervalo){      
        List<Turno> lstTurnos = new ArrayList<Turno>();
        long hinicio = TFecha.convertirMS(agenda.getAgenda_hinicio());
        long hfin    = TFecha.convertirMS(agenda.getAgenda_hfin());
        long time = hinicio;

        System.out.println("Inicio: " + TFecha.formatearHora(hinicio));
        System.out.println("Fin: " + TFecha.formatearHora(hfin));

        while(time < hfin){
            System.out.println(TFecha.formatearHora(time));
            Turno turno  = new Turno();
            turno.setAgenda_id(agenda.getAgenda_id());
            turno.setTurno_hinicio(TFecha.formatearHora(time));
            time += intervalo * 1000 * 60;                
            turno.setTurno_hfin(TFecha.formatearHora(time));
            lstTurnos.add(turno);
        }
        return lstTurnos;
    }
      public boolean baja(Agenda agenda){
          if (agenda == null) return false;
          TAsignar tasignar = new TAsignar();
          TTurno tturno = new TTurno();
          List<Turno> lstTurnos = tturno.getListAgenda(agenda.getAgenda_id());
          if (lstTurnos !=null){ //Eliminamos la lista de turnos de la agenda
              for(Turno turno:lstTurnos){
                  if (turno.getTurno_estado()== 1){ // Solo buscamos si el turno esta asignado
                      Asignar asignar = tasignar.getByTurnoId(turno.getTurno_id());
                      if (asignar != null)
                         tasignar.baja(asignar);
                  }
                        tturno.baja(turno);
              }
          }
        return super.baja(agenda);
      }

    public List<Agenda> getByProfesional(Integer prof_id) {
        String query = String.format("select * from agenda where agenda.prof_id = %d",prof_id);
        return super.getList(query);
    }
}
