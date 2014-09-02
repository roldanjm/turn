/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;

import bd.Paciente;
import java.util.List;

/**
 *
 * @author Diego
 */

public class TPaciente extends TransaccionBase<Paciente>{
    public List<Paciente>getList(){
        String query = "select * from paciente";
        return super.getList(query);
    }
    public Paciente getById(Integer id){
        String query = String.format("select * from paciente where paciente.pac_id = '%d'" , id);
        return super.getById(query);
    }
    
}
