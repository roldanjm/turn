/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Diego
 */
public class Atencion {
    Integer atencion_id = 0;
Integer turno_id = 0;
String atencion_fecha = "";
String atencion_hora = "";
String atencion_motivo = "";
String atencion_evolucion = "";
String atencion_diagnostico = "";

public Integer getAtencion_id(){return this.atencion_id;}
public Integer getTurno_id(){return this.turno_id;}
public String getAtencion_fecha(){return this.atencion_fecha;}
public String getAtencion_hora(){return this.atencion_hora;}
public String getAtencion_motivo(){return this.atencion_motivo;}
public String getAtencion_evolucion(){return this.atencion_evolucion;}
public String getAtencion_diagnostico(){return this.atencion_diagnostico;}


public Atencion getAtencion_id(Integer valor){this.atencion_id = valor; return this;}
public Atencion getTurno_id(Integer valor){this.turno_id = valor; return this;}
public Atencion getAtencion_fecha(String valor){this.atencion_fecha = valor; return this;}
public Atencion getAtencion_hora(String valor){this.atencion_hora = valor; return this;}
public Atencion getAtencion_motivo(String valor){this.atencion_motivo = valor; return this;}
public Atencion getAtencion_evolucion(String valor){this.atencion_evolucion = valor; return this;}
public Atencion getAtencion_diagnostico(String valor){this.atencion_diagnostico = valor; return this;}

}
