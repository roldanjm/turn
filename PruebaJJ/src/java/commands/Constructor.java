package commands;

import java.util.Iterator;
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Axioma
 */
public class Constructor {

    String xdefecto = "";

    public String build_opciones(String opciones[]) {
        String respuesta = "";
        if (opciones != null && opciones.length > 0) {
            int cont = 0;
            while (cont < opciones.length) {
                respuesta += opciones[cont] + " ";
                cont++;
            }
        }
        return respuesta;

    }

    public String build_input(String name, String opciones[]) {
        return "<input type='text' name='" + name + "' id='" + name + "' " + build_opciones(opciones) + xdefecto + "></input>";
    }

    public String build_textarea(String name, String opciones[]) {
        return "<textarea name='" + name + "' id='" + name + "' " + build_opciones(opciones) + xdefecto + "></textarea>";
    }

    public String build_select(String name, String opciones[], Map<String, String> options) {

        String elemento = "<select name='" + name + "' id='" + name + "' " + build_opciones(opciones) + xdefecto + ">";
        // Imprimimos el Map con un Iterador
        Iterator it = options.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            elemento += "<option value='" + key + "'>" + options.get(key) + "</option>";
        }
        elemento += "</textarea>";
        return elemento;
    }

      public String build_checkbox(String name, String opciones[], Map<String, String> options) {

        String elemento = "";
        // Imprimimos el Map con un Iterador
        Iterator it = options.keySet().iterator();
        while (it.hasNext()) {
            String key = (String) it.next();
            elemento += "<input type='radio' name='"+name+"' value='"+key+"'" + build_opciones(opciones) + xdefecto + ">" + options.get(key) + "<br>";
        }
        return elemento;
    }
}
