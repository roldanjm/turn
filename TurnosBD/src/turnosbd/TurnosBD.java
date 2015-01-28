/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package turnosbd;

import bd.Agenda;
import bd.Asignar;
import bd.Empleado;
import bd.Especialidad;
import bd.Obra_social;
import bd.Paciente;
import bd.Profesional;
import bd.Rol;
import bd.Turno;
import bd.Usuario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import transaccion.TAgenda;
import transaccion.TAsignar;
import transaccion.TEmpleado;
import transaccion.TEspecialidad;
import transaccion.TObraSocial;
import transaccion.TPaciente;
import transaccion.TProfesional;
import transaccion.TRol;
import transaccion.TTurno;
import transaccion.TUsuario;
import utils.TFecha;

/**
 *
 * @author Diego
 */
public class TurnosBD {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           
       
        ArrayList<Integer> dias = new ArrayList();        
        dias.add(Calendar.MONDAY);
        dias.add(Calendar.WEDNESDAY);
        dias.add(Calendar.FRIDAY);
        HashMap filtro = new HashMap();
//        filtro.put("tipodoc_id", "1");
//        filtro.put("pac_nrodoc","30917257");
//        filtro.put("prof_matricula", "123456");
        filtro.put("os_nombre","OS");
        List<Obra_social> listFiltro = new TObraSocial().getListFiltro(filtro);
        for (Iterator<Obra_social> it = listFiltro.iterator(); it.hasNext();) {
            Obra_social os = it.next();
            System.out.println(os.getOs_nombre());            
        }
        //        List<Paciente> listFiltro = new TPaciente().getListFiltro(filtro);
        //        List<Profesional> listFiltro1 = new TProfesional().getListFiltro(filtro);
        //        for(Profesional profesional:listFiltro1){
        //            profesional.getProf_apellido();
        //        }
        //        for(Paciente paciente:listFiltro){
        //            System.out.println(paciente.getPac_apellido());
        //        }
        //List<Date> listaDias = TFecha.getListaDias("2014-10-26", "2014-10-31", dias);
        //        for(Date dia: listaDias){
        //            System.out.println(TFecha.formatearFecha(dia,TFecha.formatoVista));
        //        }
        //                Profesional prof = new TProfesional().getById(3);
        //                List<Agenda> byProfesional = new TAgenda().getByProfesional(9);
        //                for(Agenda agenda:byProfesional){
        //                    System.out.println(TFecha.formatearFecha(agenda.getAgenda_dia(),TFecha.formatoBD,"EEEE"));
        //                }
        //        boolean baja = new TProfesional().baja(prof);
        //        System.out.println(baja);
        //        Agenda agenda = new Agenda();
        //        agenda.setProf_id(2);
        //        agenda.setAgenda_hinicio("08:00:00");
        //        agenda.setAgenda_hfin("12:00:00");
        //        Agenda agenda = new TAgenda().getById(1);
        //        List<Turno> listaTurnos = new TAgenda().getListaTurnos(agenda, 45);
        //        for(Turno turno:listaTurnos){
        //            new TTurno().alta(turno);
        //            System.out.println(turno.getTurno_hinicio() + " - " + turno.getTurno_hfin() );
        //        }
        //        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        //        try {
        //            long hinicio = sdf.parse(agenda.getAgenda_hinicio()).getTime();
        //            long hfin   = sdf.parse(agenda.getAgenda_hfin()).getTime();
        //            long minutos = 13;
        //            long time = hinicio;
        //
        //            System.out.println("Inicio: " + TFecha.formatearHora(hinicio));
        //            System.out.println("Fin: " + TFecha.formatearHora(hfin));
        //
        //            while(time < hfin){
        //                System.out.println(TFecha.formatearHora(time));
        //                time += minutos * 1000 * 60;
        //            }
        //
        //        List<Agenda> list = new TAgenda().getListByProf(0);
        //        for (Iterator<Agenda> it = list.iterator(); it.hasNext();) {
        //            Agenda agenda = it.next();
        //            System.out.println(agenda.getProf_id());
        //        }
        // TODO code application logic here
        /* ALTA DE ROLES */
        /* new TRol().alta(new Rol().setRol_descripcion("Rol 1"));
        new TRol().alta(new Rol().setRol_descripcion("Rol 2"));
        new TRol().alta(new Rol().setRol_descripcion("Rol 3"));
        new TRol().alta(new Rol().setRol_descripcion("Rol 4"));
         */
        /* ALTA DE USUARIOS */
        //        Usuario user = new Usuario()
        //                        .setUsu_username("diegote")
        //                        .setUsu_fcreacion(TFecha.ahora())
        //                        .setUsu_hash("987654321")
        //                        .setUsu_pass("987654321")
        //                        .setRol_id(1);
        //        new TUsuario().alta(user);
        /* LISTA DE USUARIOS*/
        /* List<Usuario> lista = new TUsuario().getList();
        Iterator<Usuario> it = lista.iterator();
        while(it.hasNext()){
        Usuario user = (Usuario) it.next();
        System.out.println(user.getUsu_username());
        }*/
        /* getUsuarioByUsername**/
        //        Usuario user = new TUsuario().getById(2);
        //        System.out.println(user.getUsu_username());
        /* ALTA PACIENTE */
        /*Paciente p = new Paciente();
        p.setPac_nombre("Diego")
        .setPac_apellido("Giuliani")
        .setPac_fechaalta(TFecha.ahora())
        .setPac_fnacimiento("1984-05-31")
        .setPac_mail("giuliani.diego@gmail.com")
        .setPac_nrodoc("30917257");
        new TPaciente().alta(p);
         */
        /* LISTA PACIENTE */
        /* List<Paciente> lista = new TPaciente().getList();
        Iterator<Paciente> it = lista.iterator();
        while(it.hasNext()){
        Paciente pac = (Paciente) it.next();
        System.out.println(pac.getPac_nombre() + " " + pac.getPac_apellido());
        }
         * */
        /* ALTA BAJA y LISTA de Obra_social */
        //         List<Obra_social> list = new TObraSocial().getList();
        //        Iterator<Obra_social> it = list.iterator();
        //        Obra_social osaux;
        //        while(it.hasNext()){
        //             osaux = (Obra_social) it.next();
        //            new TObraSocial().baja(osaux);
        //        }
        //
        //        Obra_social os = new Obra_social();
        //        os.setOs_nombre("OSDE")
        //          .setOs_direccion("Avenida Argentina 1234")
        //          .setOs_telefono("98765423")
        //          .setOs_cuit("30709074845");
        //        new TObraSocial().alta(os);
        //
        //        List<Obra_social> listOs = new TObraSocial().getList();
        //        for (Obra_social osaux:listOs){
        //            System.out.println(osaux.getOs_nombre() + " - " + osaux.getOs_cuit());
        //        }
        //     for (Especialidad espe : new TEspecialidad().getList()) {
        //            new TEspecialidad().baja(espe);
        //     }
        //     new TEspecialidad().alta(new Especialidad().setEspec_detalle("Especialidad 1"));
        //     new TEspecialidad().alta(new Especialidad().setEspec_detalle("Especialidad 2"));
        //     new TEspecialidad().alta(new Especialidad().setEspec_detalle("Especialidad 3"));
        //     new TEspecialidad().alta(new Especialidad().setEspec_detalle("Especialidad 4"));
        //            List<Especialidad> listEspecialidad = new TEspecialidad().getList();
        //            for (Especialidad espe : listEspecialidad) {
        //                    System.out.println(espe.getEspec_detalle());
        //            }
        //Usuario user = new TUsuario().getByUsername("dgiulian");
        //        Usuario user = new Usuario()
        //                                .setUsu_username("petealf")
        //                                .setUsu_fcreacion(TFecha.ahora())
        //                                .setUsu_hash("987654321")
        //                                .setUsu_pass("987654321")
        //                                .setRol_id(1);
        //        new TUsuario().alta(user);
        /** ALTA DE EMPLEADO */
        //        Usuario user = new TUsuario().getByUsername("petealf");
        //        Empleado emp =  new Empleado()
        //                .setEmp_nombre("Pedro")
        //                .setEmp_apellido("Alfonso")
        //                .setEmp_direccion("La concha de Paula Chavez")
        //                .setEmp_nrodoc("00666333")
        //                .setUsu_id(user.getUsu_id());
        //        new TEmpleado().alta(emp);
        //        } catch (ParseException ex) {
        //            Logger.getLogger(TurnosBD.class.getName()).log(Level.SEVERE, null, ex);
        //        }
        //        
        
        
    }

    
}
