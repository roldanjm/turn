/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package db;

/**
 *
 * @author Axioma
 */
public class Ep_venue {

    Integer ven_id;
    String ven_nombre;
    String ven_domicilio;
    String ven_nrotel;
    String ven_mail;
    String ven_responsable;
    String ven_logo;
    String ven_foto;
    String ven_descripcion;
    String ven_latitud;
    String ven_longitud;
    Integer tven_id;

    public String sqlfrom(){
        return "ep_venue";
    }

    public Integer getTven_id() {
        return tven_id;
    }

    public void setTven_id(Integer tven_id) {
        this.tven_id = tven_id;
    }

    public String getVen_descripcion() {
        return ven_descripcion;
    }

    public void setVen_descripcion(String ven_descripcion) {
        this.ven_descripcion = ven_descripcion;
    }

    public String getVen_domicilio() {
        return ven_domicilio;
    }

    public void setVen_domicilio(String ven_domicilio) {
        this.ven_domicilio = ven_domicilio;
    }

    public String getVen_foto() {
        return ven_foto;
    }

    public void setVen_foto(String ven_foto) {
        this.ven_foto = ven_foto;
    }

    public Integer getVen_id() {
        return ven_id;
    }

    public void setVen_id(Integer ven_id) {
        this.ven_id = ven_id;
    }

    public String getVen_latitud() {
        return ven_latitud;
    }

    public void setVen_latitud(String ven_latitud) {
        this.ven_latitud = ven_latitud;
    }

    public String getVen_logo() {
        return ven_logo;
    }

    public void setVen_logo(String ven_logo) {
        this.ven_logo = ven_logo;
    }

    public String getVen_longitud() {
        return ven_longitud;
    }

    public void setVen_longitud(String ven_longitud) {
        this.ven_longitud = ven_longitud;
    }

    public String getVen_mail() {
        return ven_mail;
    }

    public void setVen_mail(String ven_mail) {
        this.ven_mail = ven_mail;
    }

    public String getVen_nombre() {
        return ven_nombre;
    }

    public void setVen_nombre(String ven_nombre) {
        this.ven_nombre = ven_nombre;
    }

    public String getVen_nrotel() {
        return ven_nrotel;
    }

    public void setVen_nrotel(String ven_nrotel) {
        this.ven_nrotel = ven_nrotel;
    }

    public String getVen_responsable() {
        return ven_responsable;
    }

    public void setVen_responsable(String ven_responsable) {
        this.ven_responsable = ven_responsable;
    }

    

}
