/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Diego
 */
public class Especialidad {
    Integer espec_id = 0;
    String  espec_detalle = "";

    public Integer getEspec_id() {return this.espec_id;}
    public String getEspec_detalle() {return this.espec_detalle;}

    public Especialidad setEspec_id(Integer valor){this.espec_id = valor;return this;}
    public Especialidad setEspec_detalle(String valor){this.espec_detalle = valor;return this;}
    
}
