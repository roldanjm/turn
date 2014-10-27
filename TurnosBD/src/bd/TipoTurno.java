/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

/**
 *
 * @author Diego
 */



public class TipoTurno {
   private Integer tturno_id = 0;
   private  String  tturno_descripcion = "";
   public Integer getTturno_id(){ return this.tturno_id;}
   public String getTturno_descripcion(){return this.tturno_descripcion;}
   public TipoTurno setTturno_id(Integer valor){this.tturno_id = valor; return this;}        
   public TipoTurno setTturno_descripcion(String valor ){this.tturno_descripcion = valor; return this;}
}
