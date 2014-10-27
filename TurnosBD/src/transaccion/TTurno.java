/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;

import bd.Turno;
import java.util.List;

/**
 *
 * @author Diego
 */
public class TTurno extends TransaccionBase<Turno>{
    public List<Turno> getList(){
        String query = "select * from turno";
        return super.getList(query);
    }
    public List<Turno> getListAgenda(Integer agenda_id){
        String query = String.format("select * from turno where agenda_id = %d",agenda_id);
        return super.getList(query);
    }
    public Turno getById(Integer id){
        String query = String.format("select * from turno where turno.turno_id = %d",id);
        return super.getById(query);
    }
    public boolean actualizar(Turno turno){
        return super.actualizar(turno, "turno_id");
    }
    
  
    
}
