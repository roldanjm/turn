/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package transaccion;

import conexion.Conexion;
import conexion.TransaccionRS;
import java.lang.reflect.ParameterizedType;
import java.sql.ResultSet;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Diego
 */
public class TransaccionBase<E> {

    protected Conexion conexion;
    Class<E> clase;

    public TransaccionBase() {
        //this.clase = clase;
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
        boolean todoOk = false;
        new TransaccionRS().actualizarObjeto(obj, campo_id);
        return todoOk;
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
}
