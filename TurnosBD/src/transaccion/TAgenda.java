/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;

import bd.Agenda;
import java.util.List;

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
        System.out.println(query);
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
}
