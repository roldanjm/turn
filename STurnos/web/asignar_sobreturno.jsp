<%@page import="transaccion.TEspecialidad"%>
<%@page import="bd.Especialidad"%>
<%@page import="bd.Profesional"%>
<%@page import="transaccion.TProfesional"%>
<%@page import="bd.Agenda"%>
<%@page import="transaccion.TAgenda"%>
<%@page import="bd.Turno"%>
<%@page import="utilitarios.PathCfg"%>
<%@page import="bd.Asignar"%>
<%@page import="transaccion.TPaciente"%>
<%@page import="java.util.List"%>
<%@page import="bd.Paciente"%>
<%
    List<Paciente> lstPacientes = new TPaciente().getList();
    Asignar asignar = (Asignar) request.getAttribute("asignar");
    Turno turno = (Turno) request.getAttribute("turno");
    
    if(asignar == null) asignar = new Asignar();
    Agenda agenda = (Agenda) request.getAttribute("agenda");
    
    Profesional prof = new TProfesional().getById(agenda.getProf_id());
    Especialidad espe = new TEspecialidad().getById(prof.getEspe_id());
%>
<html>  
    <head>
        <jsp:include page="tpl_header.jsp"/>
        <script type='text/javascript' src='js/plugins/jtable/jquery.jtable.min.js'></script>    
    </head>
</html>

<body>
    <jsp:include page="tpl_logo.jsp"/>
    <jsp:include page="tpl_menu.jsp"/>
    <div class="content">
        <jsp:include page="tpl_menusuperior.jsp"/>
        
        <div class="workplace">
            <div class="page-header">
                    <h1>Turno <small>/ Asignar sobreturno</small></h1>
            </div>    
            <div class="row-fluid">
                <div class="span8">
                    <div class="head clearfix">
                        <div class="isw-calendar"></div>
                        <h1>Datos del turno</h1>
                        <ul class="buttons">                                        
                                <li class="toggle"><a href="#"></a></li>
                        </ul> 
                    </div>
                    <div class="block scrollBox">
                        <div class="scroll" style="">
                            <div class="row-form clearfix">
                                    <div class="span5">
                                        <label for="agenda_prof">Profesional</label>
                                        <input type="text" id="agenda_prof" disabled value="<%= prof.getProf_apellido() + ", " + prof.getProf_nombre() %>" />
                                    </div>
                                    <div class="span5">
                                        <label for="espe_id">Especialidad</label>
                                        <input type="text" id="espe_id" disabled value="<%= espe.getEspec_detalle() %>" />
                                    </div>
                            </div>
                            <div class="row-form clearfix">
                                <div class="span3">
                                    <label for="turno_hinicio">Hora inicio: </label>
                                    <input type="text" id="turno_hinicio"  value="<%=turno.getTurno_hinicio()%>">
                                </div>
                                <div class="span3">
                                        <label for="turno_hfin">Hora fin: </label>
                                        <input type="text" id="turno_hfin"  value="<%=turno.getTurno_hfin()%>"/>
                                </div>
                            </div>
                                
                        </div>
                    </div>
                </div>                        
            </div>
            <div class="row-fluid">
                
                <div class="span12">
                    <div class="head clearfix">
                        <div class="isw-grid"></div>
                        <h1>Asignar paciente</h1>
                    </div>
                    <div class="block-fluid">                        
                        <form action="<%=PathCfg.ASIGNAR_TURNO%>" method="POST">
                            <input type="hidden" name="asignar_id" id="asignar_id" value="<%=asignar.getAsignar_id()%>"/>
                            <input type="hidden" name="turno_id" id="turno_id" value="<%=turno.getTurno_id()%>"/>
                            
                        <div class="row-form clearfix">
<!--                            <div class="span4"><label for="turno_id"></label>
                                <input type="hidden" name="turno_id" id="turno_id" value="span4"/></div>-->
                            <div class="span4"><label for="pac_id"></label>
                                <select name="pac_id" id="pac_id" value="span4">
                                    <option value="0">Seleccionar un paciente</option>
                                    <% for(Paciente paciente: lstPacientes){%>
                                    <option value="<%=paciente.getPac_id()%>"
                                            <% if (asignar.getPac_id() == paciente.getPac_id()){%> 
                                            selected 
                                            <%}%>
                                            >                                        
                                        <%=paciente.getPac_apellido() + ", " +paciente.getPac_nombre()%>
                                    </option>
                                    <% }%>
                                </select>
                                    
                            </div>
                        </div>                                                               
                        
<!--                        <div class="row-form clearfix">
                            <div class="span5"><label for=""></label><input type="text" name="" id="" value="span5"/></div>
                            <div class="span5"><label for=""></label><input type="text" name="" id="" value="span5"/></div>
                            <div class="span2"><label for=""></label><input type="text" name="" id="" value="span2"/></div>                            
                        </div>                                                                             

                        <div class="row-form clearfix">
                            <div class="span6"><label for=""></label><input type="text" name="" id="" value="span6"/></div>
                            <div class="span6"><label for=""></label><input type="text" name="" id="" value="span6"/></div>                            
                        </div>                                                                                       
                        
                        <div class="row-form clearfix">
                            <div class="span9"><label for=""></label><input type="text" name="" id="" value="span9"/></div>
                            <div class="span3"><label for=""></label><input type="text" name="" id="" value="span3"/></div>                            
                        </div>                                                                             

                        <div class="row-form clearfix">
                            <div class="span10"><label for=""></label><input type="text" value="span10"/></div>                            
                            <div class="span2"><label for=""></label><input type="text" value="span2"/></div>                                                        
                        </div>                                                                                                     
                        
                        <div class="row-form clearfix">
                            <div class="span12"><label for=""></label><input type="text" value="span12"/></div>                            
                        </div>                                                                             -->
                        <div class="row-form clearfix">
                            <div class="item clearfix">
                                <p>                                                      
                                    <input type="submit" class="btn btn-large span2" value="Guardar">
                                </p>
                            </div>
                        </div>  
                      </form>      
                    </div>
                </div>
                
            </div>            
            
            <div class="dr"><span></span></div>
            
        </div>

</body>
</html>