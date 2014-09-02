/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;

import bd.Usuario;
import conexion.Conexion;
import conexion.TransaccionRS;
import java.sql.ResultSet;
import java.util.List;

/**
 *
 * @author Diego
 */
public class TUsuario extends TransaccionBase<Usuario>{
   
    public List<Usuario> getList(){
        String query = "select * from usuario";
        return super.getList(query);
    }
    public Usuario getById(Integer id){
        String query = "select * from usuario where usuario.usu_id = " + id;        
        return super.getById(query);
    }
    
    public Usuario getByUsername(String username){
        String query = String.format("select * from usuario where usuario.usu_username = '%s'" ,username);
        List<Usuario> list = super.getList(query);
        if (list.size()>0){
            return list.get(0);            
        } else return null;
        
    }
    
}
