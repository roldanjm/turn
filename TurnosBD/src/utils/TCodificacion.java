/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Axioma
 */
public class TCodificacion {
    
    static String urlcv="/home/neuquencom/webapps/tomcat/webapps/PortalSSWeb";

    public static String getUrlcv() {        
        return urlcv;
    }

    public static void setUrlcv(String urlcv) {
        TCodificacion.urlcv = urlcv;
    }
    
    

    public static Object recuperarCodigo(String campo, Object valor) {

        Object respuesta = null;
        if (campo.equalsIgnoreCase("post_formacion")) {
            int idformacion = (Integer) valor;
            switch (idformacion) {
                case 0:
                    respuesta = "ninguno";
                    break;
                case 1:
                    respuesta = "Primario";
                    break;
                case 2:
                    respuesta = "Secundario";
                    break;
                case 3:
                    respuesta = "Terciario";
                    break;
                case 4:
                    respuesta = "Universitario";
                    break;
                case 5:
                    respuesta = "Post-Grado";
                    break;

            }
        }

        if (campo.equalsIgnoreCase("post_formacion_estado")) {
            int idestado = (Integer) valor;
            switch (idestado) {
                case 0:
                    respuesta = "Abandonado";
                    break;
                case 1:
                    respuesta = "Incompleto";
                    break;
                case 2:
                    respuesta = "Cursando";
                    break;
                case 3:
                    respuesta = "Finalizado";
                    break;

            }
        }


        if (campo.equalsIgnoreCase("informe_tipo")) {
            int idestado = (Integer) valor;
            switch (idestado) {
                case 1:
                    respuesta = "Entrevista";
                    break;
                case 2:
                    respuesta = "Evaluación Psicologica";
                    break;
                case 3:
                    respuesta = "Evaluación Técnica";
                    break;
                case 4:
                    respuesta = "Examén Médico";
                    break;
                case 5:
                    respuesta = "Informe Socio-Ambiental";
                    break;
                case 6:
                    respuesta = "Referencias Laborales";
                    break;

            }
        }

        if (campo.equalsIgnoreCase("oferta_tipo")) {
            int idtipooferta = (Integer) valor;
            switch (idtipooferta) {
                case 1:
                    respuesta = "Activa";
                    break;
                case 2:
                    respuesta = "Finalizada";
                    break;
                case 3:
                    respuesta = "Suspendida";
                    break;

            }
        }

        if (campo.equalsIgnoreCase("solicitud_estado")) {
            int solicitud_estado = (Integer) valor;
            switch (solicitud_estado) {
                case 1:
                    respuesta = "Descartado";
                    break;
                case 2:
                    respuesta = "Postulado";
                    break;
                case 3:
                    respuesta = "Seleccionado";
                    break;
                case 4:
                    respuesta = "Finalista";
                    break;
                case 5:
                    respuesta = "Elegido";
                    break;
                case 0:
                    respuesta = "Postulado Manualmente";
                    break;
            }
        }
        
        if (campo.equalsIgnoreCase("solicitud_estado_publico")) {
            int solicitud_estado = (Integer) valor;
            switch (solicitud_estado) {
                case 1:
                    respuesta = "No has sido seleccionado";
                    break;
                case 2:
                    respuesta = "Solicitud Recibida";
                    break;
                case 3:
                    respuesta = "En proceso de selección";
                    break;
                case 4:
                    respuesta = "En proceso de selección";
                    break;
                case 5:
                    respuesta = "Elegido";
                    break;
                case 0:
                    respuesta = "Postulado Manualmente";
                    break;
            }
        }


        return respuesta;

    }
}
