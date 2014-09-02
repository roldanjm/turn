/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;

import bd.Especialidad;
import java.util.List;

/**
 *
 * @author Diego
 */
public class TEspecialidad extends TransaccionBase<Especialidad>{
    public  List<Especialidad> getList(){
        String query = String.format("select * from especialidad");
        return super.getList(query);
    }
    public Especialidad getById(Integer id){
        String query = String.format("select * from especialidad where especialidad.esp_id = %d" , id);
        return super.getById(query);
    }
}
