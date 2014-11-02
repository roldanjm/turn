/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;

import bd.Paciente;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

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
//    public List<Paciente> getListFiltro(Map<String,String> filtro){
//        String clase =  "bd.Paciente";
//        String where =  " where True ";
//        try {
//            Class claseGenerada = Class.forName(clase.trim());
//            Object objeto = claseGenerada.newInstance();
//            for (String key : filtro.keySet()) {                
//                Object value = filtro.get(key);
//                
//                System.out.println(key + ": " + value);                    
//                Field campo = claseGenerada.getDeclaredField(key);
//                Class<?> type = campo.getType();                
//                if (type.isAssignableFrom(String.class)){
//                    where += String.format(" and %s = '%s'",key,value) ;
//                }else if (type.isAssignableFrom(Integer.class)){
//                    if (value != null)
//                    where += String.format(" and %s = %s",key,value) ;
//                };
//
//            }
//                
//            } catch (NoSuchFieldException ex) {
//            Logger.getLogger(TPaciente.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SecurityException ex) {
//            Logger.getLogger(TPaciente.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            Logger.getLogger(TPaciente.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            Logger.getLogger(TPaciente.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(TPaciente.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        
//        String query = "select * from paciente " + where;
//        System.out.println(query);
//        return super.getList(query);
//    }
    
}
