/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Diego
 */
public class Turno {
Integer turno_id = 0;
Integer agenda_id = 0;
String turno_hinicio = "";
String turno_hfin = "";
String turno_tipoturno = "";
String turno_estado = "";


public Integer getTurno_id(){return this.turno_id;}
public Integer getAgenda_id(){return this.agenda_id;}
public String getTurno_hinicio(){return this.turno_hinicio;}
public String getTurno_hfin(){return this.turno_hfin;}
public String getTurno_tipoturno(){return this.turno_tipoturno;}
public String getTurno_estado(){return this.turno_estado;}

public Turno setTurno_id(Integer valor){this.turno_id = valor;return this;}
public Turno setAgenda_id(Integer valor){this.agenda_id = valor;return this;}
public Turno setTurno_hinicio(String valor){this.turno_hinicio = valor;return this;}
public Turno setTurno_hfin(String valor){this.turno_hfin = valor;return this;}
public Turno setTurno_tipoturno(String valor){this.turno_tipoturno = valor;return this;}
public Turno setTurno_estado(String valor){this.turno_estado = valor;return this;}
}
