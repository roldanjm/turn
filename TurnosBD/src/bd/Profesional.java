/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Diego
 */
public class Profesional {
    Integer prof_id = 0;
String prof_matricula = "";
String prof_nombre = "";
String prof_apellido = "";
String prof_domicilio = "";
String prof_telefono = "";
String prof_celular = "";
Integer espe_id = 0;
Integer usu_id = 0;


public Integer getProf_id(){return this.prof_id;}
public String getProf_matricula(){return this.prof_matricula;}
public String getProf_nombre(){return this.prof_nombre;}
public String getProf_apellido(){return this.prof_apellido;}
public String getProf_domicilio(){return this.prof_domicilio;}
public String getProf_telefono(){return this.prof_telefono;}
public String getProf_celular(){return this.prof_celular;}
public Integer getEspe_id(){return this.espe_id;}
public Integer getUsu_id(){return this.usu_id;}

public Profesional setProf_id(Integer valor){this.prof_id = valor; return this;}
public Profesional setProf_matricula(String valor){this.prof_matricula = valor; return this;}
public Profesional setProf_nombre(String valor){this.prof_nombre = valor; return this;}
public Profesional setProf_apellido(String valor){this.prof_apellido = valor; return this;}
public Profesional setProf_domicilio(String valor){this.prof_domicilio = valor; return this;}
public Profesional setProf_telefono(String valor){this.prof_telefono = valor; return this;}
public Profesional setProf_celular(String valor){this.prof_celular = valor; return this;}
public Profesional setEspe_id(Integer valor){this.espe_id = valor; return this;}
public Profesional setUsu_id(Integer valor){this.usu_id = valor; return this;}
}
