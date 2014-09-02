/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Diego
 */
public class Rol_permiso {
    Integer rol_id = 0;
    Integer perm_id = 0;


    public Integer getRol_id(){ return this.rol_id;}
    public Integer getPerm_id(){ return this.perm_id;}

    public Rol_permiso setRol_id(Integer valor){this.rol_id = valor; return this;}
    public Rol_permiso setPerm_id(Integer valor){this.perm_id = valor; return this;}
}
