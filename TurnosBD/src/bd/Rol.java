/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Diego
 */
public class Rol {
    Integer rol_id = 0;
    String rol_descripcion = "";
    public Integer getRol_id(){ return this.rol_id;}
    public String getRol_descripcion(){return this.rol_descripcion; }
    //public void setRol_id(Integer valor){this.rol_id = valor;}
    //public void setRol_descripcion(String valor){ this.rol_descripcion = valor;}
    public Rol setRol_id(Integer valor){
        this.rol_id = valor;
        return this;
    }
    public Rol setRol_descripcion(String valor){ 
        this.rol_descripcion = valor; 
        return this;
    }
}
