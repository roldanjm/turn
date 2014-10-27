/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;


import bd.TipoTurno;
import java.util.List;

/**
 *
 * @author Diego
 */
public class TTipoTurno extends TransaccionBase<TipoTurno> {

    public List<TipoTurno> getList() {
        String query = "select * from tipo_turno";
        return super.getList(query);
    }
    
    
}
