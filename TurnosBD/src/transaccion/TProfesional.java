/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;

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
}
