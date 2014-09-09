/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;

import conexion.Conexion;
import conexion.TransaccionRS;
import db.Ep_venue;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Axioma
 */
public class TEp_venue extends TransaccionBase<Ep_venue> {

    TransaccionRS tr = new TransaccionRS();
    Conexion conexion = new Conexion();

    public List recuperarLista(Ep_venue venue) {

        return this.getListFilter(venue, "");

    }
}
