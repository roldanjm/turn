/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;

import bd.Especialidad;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Diego
 */
public class TEspecialidad extends TransaccionBase<Especialidad>{

    public Map<String,String> checkEdit(Map<String, String[]> parameterMap) {
        Map<String,String> result = new HashMap<String,String>();
        for( String key :parameterMap.keySet()){
            System.out.println(key + ": " + parameterMap.get(key)[0]);
        }
        boolean todoOk = true;
        if (parameterMap.get("espec_detalle") == null || parameterMap.get("espec_detalle")[0].equals("") ){            
            result.put("espec_detalle", "Debe ingresar la descripci&oacute;n de la especialidad");
            todoOk = false;
        }
        
        if (todoOk) result.put("result","Ok");
        
        return result;
        
    }
    public  List<Especialidad> getList(){
        String query = String.format("select * from especialidad");
        return super.getList(query);
    }
    public Especialidad getById(Integer id){
        String query = String.format("select * from especialidad where especialidad.espec_id = %d" , id);
        return super.getById(query);
    }   

    public boolean actualizar(Especialidad esp) {
        return this.actualizar(esp,"espec_id");
    }
}
