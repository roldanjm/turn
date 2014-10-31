<%@page import="transaccion.TEspecialidad"%>
<%@page import="bd.Especialidad"%>
<%@page import="utils.TFecha"%>
<%@page import="bd.Profesional"%>
<%@page import="transaccion.TProfesional"%>
<%@page import="bd.Agenda"%>
<%@page import="utilitarios.PathCfg"%>
<%
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
                    <h1>Turnos <small>/ Administraci&oacute;n</small></h1>
            </div>
            <div class="row-fluid">
                <div class="span12">

                    <!--<div class="span8">-->
<!--                        <div class="span12">
                            <div class="head clearfix">
                                <div class="isw-grid"></div>
                                <h1>Busqueda</h1>
                                <ul class="buttons">                                        
                                <li class="toggle"><a href="#"></a></li>
                            </ul> 
                            </div>
                            <div class="block-fluid">                        

                                <div class="row-form clearfix">
                                    <div class="span4"><input type="text" value="span4"/></div>
                                    <div class="span4"><input type="text" value="span4"/></div>
                                    <div class="span4"><input type="text" value="span4"/></div>                            
                                </div>                                                               

                                                                                                                     
                            </div>
                        </div>-->

                    <!--</div>-->
                    <div class="span8">
                        <div class="head clearfix">
                            <div class="isw-calendar"></div>
                            <h1>Agenda</h1>
                            <ul class="buttons">                                        
                                <li class="toggle"><a href="#"></a></li>
                            </ul> 
                        </div>
                        <div class="block users scrollBox">

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
                                        <label for="agenda_prof">Dia:</label>
                                        <input type="text" id="agenda_prof" disabled value="<%= TFecha.formatearFecha(agenda.getAgenda_dia(), TFecha.formatoBD, TFecha.formatoVista) %> " />
                                    </div>
                                
                                    <div class="span3">
                                    <label for="agenda_prof">Hora Inicio:</label>
                                    <input type="text" id="agenda_prof" disabled value="<%=agenda.getAgenda_hinicio() %> " />
                                    </div>
                                    <div class="span3">
                                        <label for="agenda_prof">Hora Fin:</label>
                                        <input type="text" id="agenda_prof" disabled value="<%=agenda.getAgenda_hfin() %> " />
                                    </div>
                                </div>                                
                            </div>
                        </div>

                    </div>
                    <div class="span4">
                        <div class="head clearfix">
                            <div class="isw-cloud"></div>
                            <h1>Acciones</h1>
                            <ul class="buttons">                                        
                                <li class="toggle"><a href="#"></a></li>
                            </ul> 
                        </div>
                        <div class="block users scrollBox">

                            <div class="scroll" style="">

                                <div class="item clearfix">
                                    <p>                                                      
                                        <!--<button type="button" class="btn btn-large span12">Nuevo Paciente</button>-->                                        
                                    </p>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>


            </div>
            <div class="row-fluid">
                <div class="span12">
                    <div id="idTabla"></div>
                </div>
            </div>
        </div>
        <script language="javascript">
            $('#idTabla').jtable({
                title:'Turnos disponibles',
                paging: true,
                sorting: true,
                pageSize: 10, //Set page size (default: 10)    
                actions:{
                    listAction:'<%=PathCfg.TURNOS_LIST%>',
//                    updateAction:'',
//                    createAction:'',
//                    deleteAction:''
                },
                fields:{
                    
//                    espe_id:{
//                        title:'',
//                        options:'<%=PathCfg.OPTIONS%>?type=Especialidades'
//                    },
                    turno_id:{ key:true,
                                list:false,
                                edit:false,
                    },
                    agenda_id:{
                        list:false,                    
                        edit:true,
                    },
                    turno_hinicio:{
                        title:"Inicio",
                        width:"2%",
                    },
                    turno_hfin:{
                        title:"Fin",
                        width:"2%",
                    },
                    turno_tipoturno:{
                        title:"Tipo",
                        options:'<%=PathCfg.OPTIONS%>?type=TipoTurno'
                    },                            
                    turno_estado:{
                        title:"Estado",
                        options: {'0':'Creado','1':'Asignado','2':'En espera','3':'Finalizado','4':'No disponible'},
                       //options:'<%=PathCfg.OPTIONS%>?type=EstadoTurno'                      
                    },
                    Asignar: {
                            title: '',
                            width: '2%',
                            sorting: false,
                            edit: false,
                            create: false,
                            display: function(data) {
                                var $img2 = $('<button class="btn btn-small">Asignar</button>');
                                $img2.click(function() {
                                    window.location = "<%=PathCfg.ASIGNAR_TURNO%>" + '?turno_id=' + data.record.turno_id 
                                });
                                return $img2
                           }
                    }
                }
            });
            $(document).ready(function(){
               $('#idTabla').jtable('load',{agenda_id:<%= agenda.getAgenda_id() %>});
            });
        </script>
</body>
</html>