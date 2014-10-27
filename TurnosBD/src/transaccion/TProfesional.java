/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;

import bd.Agenda;
import bd.Profesional;
import java.util.List;

/**
 *
 * @author Diego
 */
public class TProfesional extends TransaccionBase<Profesional>{
    public List<Profesional> getList(){
        String query = "Select * from profesional";
        return this.getList(query);                
    }
    
    public Profesional getById(Integer id){
        String query = String.format("select * from profesional where profesional.prof_id = %d" , id);
        return super.getById(query);
    }   

    public boolean actualizar(Profesional prof) {
        return this.actualizar(prof,"prof_id");
    }
    
    public boolean baja(Profesional prof){
        if (prof == null) return false;
        TAgenda tagenda = new TAgenda();
        List<Agenda> lstAgendas = tagenda.getByProfesional(prof.getProf_id());
        
        if (lstAgendas!=null){ //Eliminamos todas las agendas asociadas al profesional
            for(Agenda agenda:lstAgendas){
                tagenda.baja(agenda);
            }
        }
        return super.baja(prof);
    }
}
