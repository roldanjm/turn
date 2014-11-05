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
                                        <button type="button" class="btn btn-large span12">Asignar Contraturno</button>                                        
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
        <div id="dialog" title="Cambio de estado">
            <input type="hidden" id="turno_id" name="turno_id"  value="">
            <select id="turno_estado" name="turno_estado">
                <option value='0'>Creado</option>
                <option value='1'>Asignado</option>
                <option value='2'>En espera</option>
                <option value='3'>Finalizado</option>
                <option value='4'>No disponible</option>                
            </select>            
            <div>
                <h6 id="msgError"></h6>
            </div>
            <button class="btn btn-small" id="btnGuardar">Guardar</button>
        </div>
        </div>
        <script language="javascript">
            $('#idTabla').jtable({
                title:'Turnos disponibles',
                paging: false,
                sorting: true,
                pageSize: 10, //Set page size (default: 10)    
                actions:{
                    listAction:'<%=PathCfg.TURNOS_LIST%>',
                },
                fields:{
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
                                dialog(data.record.turno_id);
                            });
                            return $img2;
                        }
                    },
                    Cambiar: {
                        title: '',
                        width: '2%',
                        sorting: false,
                        edit: false,
                        create: false,
                        display: function(data) {
//                               
                            var $img2 = $('<button class="btn btn-small">Cambiar</button>');
                            $img2.click(function() {
                                $('#turno_estado').val(data.record.turno_estado);
                                $('#turno_id').val(data.record.turno_id);
                                $('#dialog').dialog('open');
                            });
                            return $img2;
                        }
                    }
                }, recordsLoaded:function(event,data){
                    console.log(data.records);
                    
                    for(var i = 0;i<data.records.length;i++){
                        var d = data.records[i];
                        if (d.turno_estado != 0){
                            console.log(d);
                            $('#idTabla').find('.jtable tbody tr[data-record-key='+ d.turno_id +']').css("color", "gray");
                        }
                    }
                },
            });
            $(document).ready(function(){
               loadTabla();
               $('#dialog').dialog({autoOpen: false,
               width:350,
           });
               $('#btnGuardar').click(function(){
                   $.ajax({
                        url:'<%=PathCfg.TURNOS_EDIT_ESTADO%>',
                        type:'POST',
                        data:{
                            turno_id:$('#turno_id').val(),
                            turno_estado:$('#turno_estado').val(),
                        },
                        success:function(data){
                            console.log(data);
                            loadTabla();
                            if (data == "OK"){        
                                $('#msgError').html("");
                                $('#dialog').dialog('close');
                            }else{
                                $('#msgError').html("Ha ocurrido un error al modificar el estado del turno");
                            }                   
                        },
                    });
              });               
            });
            function loadTabla(){
                $('#idTabla').jtable('load',{agenda_id:<%= agenda.getAgenda_id() %>});
            }
            function dialog(id) {
                var page = "/AsignarTurnoDlg?turno_id=" + id;
                var $dialog = $('<div></div>')
                        .html('<iframe style="border: 0px; " src="' + page + '" width="100%" height="100%"></iframe>')
                        .dialog({
                    autoOpen: false,
                    modal: true,
                    height: 500,
                    width: 800,
                    title: "ASIGNAR PACIENTE", 
                    close: function( event, ui ) {
                        console.log("Close");                    
                        $('#idTabla').jtable('load',{agenda_id:<%= agenda.getAgenda_id() %>});
                    }
                });
                $dialog.dialog('open');
        }
        </script>
</body>
</html>