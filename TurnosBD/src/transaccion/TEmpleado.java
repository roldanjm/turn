/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;

import bd.Empleado;
import java.util.List;

/**
 *
 * @author Diego
 */
public class TEmpleado extends TransaccionBase<Empleado>{
    public List<Empleado> getList(){
        String query = "select * from empleado";
        return super.getList(query);
    }
    public Empleado getById(Integer id){
        String query = String.format("select * from empleado where empleado.emp_id = %d",id);
        return super.getById(query);
    }
}
