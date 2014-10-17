/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;

import bd.Bd_provincia;

import java.util.List;

/**
 *
 * @author Diego
 */
public class TProvincia extends TransaccionBase<Bd_provincia> {
    public List<Bd_provincia> getList(){
        String query = "Select * from bd_provincia";
        return this.getList(query);                
    }
    
    public Bd_provincia getById(Integer id){
        String query = String.format("select * from bd_provincia where bd_provincia.prov_id = %d" , id);
        return super.getById(query);
    }   

    public boolean actualizar(Bd_provincia prof) {
        return this.actualizar(prof,"prov_id");
    }
}
