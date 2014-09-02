/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Diego
 */
public class Paciente {
Integer pac_id = 0;
String pac_fechaalta = "";
String pac_fnacimiento = "";
String pac_nombre = "";
String pac_apellido = "";
Integer tipodoc_id = 0;
String pac_nrodoc = "";
String pac_direccion = "";
Integer prov_id = 0;
Integer loc_id = 0;
Integer os_id;
String pac_telefono = "";
String pac_celular = "";
String pac_sexo = "";
String pac_observaciones = "";
String pac_mail = "";

public Integer getPac_id (){return this.pac_id;}
public String getPac_fechaalta(){return this.pac_fechaalta;}
public String getPac_fnacimiento(){return this.pac_fnacimiento;}
public String getPac_nombre(){return this.pac_nombre;}
public String getPac_apellido(){return this.pac_apellido;}
public Integer getTipodoc_id (){return this.tipodoc_id;}
public String getPac_nrodoc(){return this.pac_nrodoc;}
public String getPac_direccion(){return this.pac_direccion;}
public Integer getProv_id (){return this.prov_id;}
public Integer getLoc_id (){return this.loc_id;}
public Integer getOs_id (){return this.os_id;}
public String getPac_telefono(){return this.pac_telefono;}
public String getPac_celular(){return this.pac_celular;}
public String getPac_sexo(){return this.pac_sexo;}
public String getPac_observaciones(){return this.pac_observaciones;}
public String getPac_mail(){return this.pac_mail;}


/**********************SETTERS ******************/

    public Paciente setPac_id(Integer valor){
      this.pac_id = valor;
      return this;
    }
    public Paciente setPac_fechaalta(String valor){
      this.pac_fechaalta = valor;
      return this;
    }
    public Paciente setPac_fnacimiento(String valor){
      this.pac_fnacimiento = valor;
      return this;
    }
    public Paciente setPac_nombre(String valor){
      this.pac_nombre = valor;
      return this;
    }
    public Paciente setPac_apellido(String valor){
      this.pac_apellido = valor;
      return this;
    }
    public Paciente setTipodoc_id(Integer valor){
      this.tipodoc_id = valor;
      return this;      
    }
    public Paciente setPac_nrodoc(String valor){
      this.pac_nrodoc = valor;
      return this;
    }
    public Paciente setPac_direccion(String valor){
      this.pac_direccion = valor;
      return this;
    }
    public Paciente setProv_id(Integer valor){
      this.prov_id = valor;
      return this;
    }
    public Paciente setLoc_id(Integer valor){
      this.loc_id = valor;
      return this;
    }
    public Paciente setOs_id(Integer valor){
      this.os_id = valor;
      return this;
    }
    public Paciente setPac_telefono(String valor){
      this.pac_telefono = valor;
      return this;
    }
    public Paciente setPac_celular(String valor){
      this.pac_celular = valor;
      return this;
    }
    public Paciente setPac_sexo(String valor){
      this.pac_sexo = valor;
      return this;
    }
    public Paciente setPac_observaciones(String valor){
      this.pac_observaciones = valor;
      return this;
    }
    public Paciente setPac_mail(String valor){
      this.pac_mail = valor;
      return this;
    }
}
