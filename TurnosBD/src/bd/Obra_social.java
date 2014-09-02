/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Diego
 */
public class Obra_social {
  Integer os_id = 0;
  String os_nombre = "";
  String os_cuit = "";
  String os_direccion = "";
  String os_telefono = "";

    public Integer getOs_id       (){ return this.os_id;}
    public String getOs_nombre    (){ return this.os_nombre;}
    public String getOs_cuit      (){ return this.os_cuit;}
    public String getOs_direccion (){ return this.os_direccion;}
    public String getOs_telefono  (){ return this.os_telefono;}

    public Obra_social setOs_id        (Integer valor){this.os_id = valor;return this;}
    public Obra_social setOs_nombre    (String valor){this.os_nombre = valor;return this;}
    public Obra_social setOs_cuit      (String valor){this.os_cuit = valor;return this;}
    public Obra_social setOs_direccion (String valor){this.os_direccion = valor;return this;}
    public Obra_social setOs_telefono  (String valor){this.os_telefono = valor;return this;}
}
