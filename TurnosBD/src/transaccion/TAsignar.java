/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;

import bd.Asignar;
import java.util.List;

/**
 *
 * @author Diego
 */
public class TAsignar extends TransaccionBase<Asignar>{
    public List<Asignar> getList(){
        String query = "select * from asignar";
        return super.getList(query);
    }
    public int alta(Asignar asignar){
        return super.alta(asignar);        
    }    
    public boolean actualizar(Asignar asignar){
        return super.actualizar(asignar, "asignar_id");        
    }
    public boolean baja(Asignar asignar){
        return super.baja(asignar);
    }

    public Asignar getById(int asignar_id) {
        String query = "select * from asignar";
       return super.getById(query);
    }

    

    public Asignar getByTurnoId(Integer turno_id) {
        String query = String.format("select * from asignar where asignar.turno_id = %d",turno_id);
        return super.getById(query);
    }
}
