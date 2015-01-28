/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;

import bd.Paciente;
import conexion.Conexion;
import conexion.TransaccionRS;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Diego
 */
public class TransaccionBase<E> {

    protected Conexion conexion;
    Class<E> clase;

    public TransaccionBase() {
        this.clase = clase;
        this.clase = (Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        conexion = new Conexion();
    }

    public int alta(Object obj) {
        int id = 0;
        id = new TransaccionRS().altaObjetoAutonumerico(obj);
        return id;
    }

    public boolean baja(Object obj) {
        boolean todoOk = false;
        todoOk = new TransaccionRS().eliminarObjeto(obj);
        return todoOk;
    }

    public boolean actualizar(Object obj, String campo_id) {        
        return new TransaccionRS().actualizarObjeto(obj, campo_id);
    }

    public List<E> getList(String query) {
        List<E> lista = null;
        conexion.conectarse();
        ResultSet rs = conexion.ejecutarSQLSelect(query);
        System.out.println(this.clase.getCanonicalName());
        lista = new TransaccionRS().recuperarLista(this.clase.getCanonicalName(), rs);
        conexion.desconectarse();
        return lista;
    }

    public List<E> getListFilter(Object object, String extendSQL) {
        String sql = new TransaccionRS().recuperarListaDefault(object, extendSQL);
        System.out.println(sql);
        if (sql != null && !sql.equalsIgnoreCase("")) {
            return this.getList(sql);
        }
        return null;
    }

    public E getById(String query) {
        E obj = null;
        conexion.conectarse();
        ResultSet rs = conexion.ejecutarSQLSelect(query);
        TransaccionRS t = new TransaccionRS();
        List listaUsuario = t.recuperarLista(this.clase.getCanonicalName(), rs);
        conexion.desconectarse();

        if (listaUsuario != null && listaUsuario.size() > 0) {
            obj = (E) listaUsuario.get(0);
        }
        return obj;
    }

    public E recuperarInstancia(Map<String, String[]> map) {
        TransaccionRS t = new TransaccionRS();
        Object object = t.altaObjeto(this.clase.getCanonicalName(), map);
        return (E) object;
    }
    public List<E> getListFiltro(Map<String,String> filtro){
        
        String where =  " where True ";
        try {
            
            Class claseGenerada = Class.forName(this.clase.getCanonicalName().trim());
            Object objeto = claseGenerada.newInstance();
            for (String key : filtro.keySet()) {   
                System.out.print(key + ":");
                Object value = filtro.get(key);
                System.out.println(value );                
                try{
                    Field campo = claseGenerada.getDeclaredField(key);                
                    Class<?> type = campo.getType();                
                
                if (type.isAssignableFrom(String.class)){
//                    where += String.format(" and %s = '%s'",key,value) ;
                    where += String.format(" and %s like '%%%s%%'",key,value) ;
                }else if (type.isAssignableFrom(Integer.class)){
                    if (value != null)
                        where += String.format(" and %s = %s",key,value) ;
                };
                } catch (NoSuchFieldException ex) {   
                    //Si no existe el campo ignoramos la excepción
                    // Logger.getLogger(TPaciente.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (SecurityException ex) {
                    Logger.getLogger(TPaciente.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
                
        }catch (InstantiationException ex) {
            Logger.getLogger(TPaciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(TPaciente.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(TPaciente.class.getName()).log(Level.SEVERE, null, ex);
        }
        String tabla = this.clase.getCanonicalName().replace("bd.", "");
        String query = "select * from " + tabla  + where;
        System.out.println(query);
        return this.getList(query);
    }
}
