/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;

import bd.Obra_social;
import java.util.List;

/**
 *
 * @author Diego
 */
public class TObraSocial extends TransaccionBase<Obra_social>{
    public List<Obra_social> getList(){
        String query = "select * from obra_social";
        return super.getList(query);
    }
    public Obra_social getById(Integer id){
        String query = String.format("select * from obra_social where os_id = %d",id);
        return super.getById(query);
    }
    
}
