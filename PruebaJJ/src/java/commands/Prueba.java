package commands;

import java.util.HashMap;
import java.util.Map;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Axioma
 */
public class Prueba {

    private Constructor constructor = new Constructor();
    int id;
    public String nombre;
    public String apellido;
    public Float dni;

    private enum Campos {

        id, nombre, apellido, dni
    }

    public String key() {
        return "id";
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Float getDni() {
        return dni;
    }

    public void setDni(Float dni) {
        this.dni = dni;
    }

    public String build(String campo, String opciones[]) {
        Campos campos = Campos.valueOf(campo); // surround with try/catch
        String respuesta = "";
        switch (campos) {
            case id:
                break;
            case nombre:
                respuesta = constructor.build_input(campo, opciones);
                break;
            case dni:
                respuesta = constructor.build_input(campo, opciones);
                break;
            case apellido:
                Map<String, String> map = new HashMap<String, String>();
                map.put("1", "Casillas");
                map.put("15", "Ramos");
                map.put("3", "Pique");
                map.put("5", "Puyol");
                map.put("11", "Capdevila");
                map.put("14", "Xabi Alonso");
                map.put("16", "Busquets");
                map.put("8", "Xavi Hernandez");
                map.put("18", "Pedrito");
                map.put("6", "Iniesta");
                map.put("7", "Villa");
                respuesta = constructor.build_input(campo, opciones);
                break;
        }
        return respuesta;
    }
}
