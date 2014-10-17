/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;

import bd.Bd_localidad;
import java.util.List;

/**
 *
 * @author Diego
 */
public class TLocalidad extends TransaccionBase<Bd_localidad> {
    public List<Bd_localidad> getList(){
        String query = "Select * from bd_localidad";
        return this.getList(query);                
    }
    public List<Bd_localidad> getList(int prov_id){
        String query = String.format("Select * from bd_localidad where prov_id = %d", prov_id);
        return this.getList(query);                
    }    
    public Bd_localidad getById(Integer id){
        String query = String.format("select * from bd_localidad where bd_localidad.loc_id = %d" , id);
        return super.getById(query);
    }   

    public boolean actualizar(Bd_localidad prof) {
        return this.actualizar(prof,"loc_id");
    }
}
