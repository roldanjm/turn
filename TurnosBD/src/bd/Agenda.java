/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Diego
 */
public class Agenda {
    Integer agenda_id = 0;
    Integer prof_id = 0;
    String agenda_dia = "";
    String agenda_consultorio = "";
    String agenda_hinicio = "";
    String agenda_hfin = "";
    Integer agenda_intervalo = 0;
    String agenda_alta = "";

public String sqlfrom(){return "ep_venue";}
public Integer getAgenda_id (){return this.agenda_id ;}
public Integer getProf_id (){return this.prof_id;}
public String getAgenda_dia (){return this.agenda_dia;}
public String getAgenda_consultorio (){return this.agenda_consultorio;}
public String getAgenda_hinicio (){return this.agenda_hinicio;}
public String getAgenda_hfin (){return this.agenda_hfin;}
public String getAgenda_alta (){return this.agenda_alta;}
public Integer getAgenda_intervalo(){return this.agenda_intervalo;}

public Agenda setAgenda_id(Integer valor){this.agenda_id = valor; return this;}
public Agenda setProf_id(Integer valor){this.prof_id = valor; return this;}
public Agenda setAgenda_dia(String valor){this.agenda_dia = valor; return this;}
public Agenda setAgenda_consultorio(String valor){this.agenda_consultorio = valor; return this;}
public Agenda setAgenda_hinicio(String valor){this.agenda_hinicio = valor; return this;}
public Agenda setAgenda_hfin(String valor){this.agenda_hfin = valor; return this;}
public Agenda setAgenda_alta(String valor){this.agenda_alta = valor; return this;}
public Agenda setAgenda_intervalo(Integer valor){this.agenda_intervalo = valor; return this;}
}
