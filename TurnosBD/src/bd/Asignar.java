/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Diego
 */
public class Asignar {
Integer asignar_id = 0;
Integer turno_id = 0;
Integer pac_id = 0;
String asignar_fecha = "";
Integer usu_id = 0;


public Integer getAsignar_id(){return this.asignar_id;}
public Integer getTurno_id(){return this.turno_id;}
public Integer getPac_id(){return this.pac_id;}
public String getAsignar_fecha(){return this.asignar_fecha;}
public Integer getUsu_id(){return this.usu_id;}

public Asignar setAsignar_id(Integer valor){this.asignar_id = valor; return this;}
public Asignar setTurno_id(Integer valor){this.turno_id = valor; return this;}
public Asignar setPac_id(Integer valor){this.pac_id = valor; return this;}
public Asignar setAsignar_fecha(String valor){this.asignar_fecha = valor; return this;}
public Asignar setUsu_id(Integer valor){this.usu_id = valor; return this;}

}
