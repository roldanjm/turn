/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package commands;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Axioma
 */
public class Transaccion {

    public Method recuperarMetodo(Class clase, String metodo) {
        Method[] metodos = clase.getMethods();
        int i = 0;
        while (i < metodos.length) {
            if (metodos[i].getName().equalsIgnoreCase(metodo)) {
                return metodos[i];
            }
            i++;
        }
        return null;
    }

    public boolean altaObjeto(Map<String, String[]> map) {
        try {
            String className = map.get("clase")[0];
            Class claseGenerada = Class.forName("commands." + className.trim());
            Object objeto = claseGenerada.newInstance();
            Iterator it = map.keySet().iterator();
            while (it.hasNext()) {
                String key = (String) it.next();
                if (!key.equalsIgnoreCase("clase")) {
                    Object value = map.get(key)[0];
                    System.out.println("value: " + value);
                    String name = key.substring(0, 1).toUpperCase() + key.substring(1, key.length());
                    Method miMetodo = recuperarMetodo(claseGenerada, "set" + name);
                    if (miMetodo != null) {
                        String nameParameter = miMetodo.getParameterTypes()[0].getName();
                        Object[] parametro = new Object[1];
                        parametro[0] = recuperarValor(value, nameParameter);

                        System.out.println(nameParameter);
                        miMetodo.invoke(objeto, parametro);
                    } else {
                        return false;
                    }
                }
            }
            TransaccionRS tr = new TransaccionRS();
            boolean band = tr.altaObjeto(objeto);
            return band;
        } catch (IllegalArgumentException ex) {
            Logger.getLogger(Transaccion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (InvocationTargetException ex) {
            Logger.getLogger(Transaccion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (SecurityException ex) {
            Logger.getLogger(Transaccion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (InstantiationException ex) {
            Logger.getLogger(Transaccion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Transaccion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Transaccion.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }

    }

    public Object recuperarValor(Object value, String tipoParametro) {


        if (tipoParametro.equalsIgnoreCase("java.lang.Integer")) {
            return Integer.parseInt((String) value);
        }
        if (tipoParametro.equalsIgnoreCase("java.lang.String")) {
            return (String) value;
        }
        if (tipoParametro.equalsIgnoreCase("java.lang.Float")) {
            return Float.parseFloat((String) value);
        }

        return null;
    }
}
