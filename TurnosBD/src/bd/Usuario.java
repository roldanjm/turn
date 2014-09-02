/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Diego
 */
public class Usuario {
Integer usu_id = 0;
String  usu_username = "";
String  usu_pass = "";
String  usu_fcreacion = "";
String  usu_hash = "";
Integer rol_id = 0;


public Integer getUsu_id (){
    return this.usu_id;
}
public String getUsu_username(){
    return this.usu_username;
}
public String  getUsu_pass(){
    return this.usu_pass;
}
public String  getUsu_fcreacion(){
    return this.usu_fcreacion;
}
public String  getUsu_hash(){
    return this.usu_hash;
}
public Integer getRol_id (){
    return this.rol_id;
}

public Usuario setUsu_id(Integer valor){this.usu_id = valor;return this;}
public Usuario setUsu_username(String valor) {this.usu_username = valor;return this;}
public Usuario setUsu_pass(String valor){ this.usu_pass = valor; return this;}
public Usuario setUsu_fcreacion(String valor){ this.usu_fcreacion = valor;return this;}
public Usuario setUsu_hash(String valor){this.usu_hash = valor;return this;}
public Usuario setRol_id(Integer valor){this.rol_id = valor;return this;}

}
