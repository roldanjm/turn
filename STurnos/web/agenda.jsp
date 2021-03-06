<%@page import="utils.TFecha"%>
<%@page import="bd.Profesional"%>
<%@page import="transaccion.TProfesional"%>
<%@page import="java.util.List"%>
<%@page import="utilitarios.PathCfg"%>
<%
 List<Profesional> lstProfesional = new TProfesional().getList();    
%>
<html>  
    <head>
        <jsp:include page="tpl_header.jsp"/>
    </head>
</html>

<body>
    <jsp:include page="tpl_logo.jsp"/>
    <jsp:include page="tpl_menu.jsp"/>
    <div class="content">
        <jsp:include page="tpl_menusuperior.jsp"/>
        <div class="workplace">
            <div class="page-header">
                    <h1>Agenda <small>/ Administraci&oacute;n</small></h1>
            </div>
            <div class="row-fluid">
                <div class="span12">

                    <div class="span8">
                        <div class="span12">
                            <div class="head clearfix">
                                <div class="isw-grid"></div>
                                <h1>Busqueda</h1>
                                <ul class="buttons">                                        
                                <li class="toggle"><a href="#"></a></li>
                            </ul> 
                            </div>
                            <div class="block-fluid">                        

                                <div class="row-form clearfix">
                                    <div class="span4"><label for="prof_id">Profesional:</label>
                                    <select name="prof_id" id="prof_id">
                                        <option value="0">Seleccionar el profesional </option>
                                        <% for (Profesional prof: lstProfesional) {%>
                                        <option value="<%=prof.getProf_id()%>">
                                            <%= prof.getProf_apellido() + ", " +prof.getProf_nombre()%>
                                        </option>
                                        <% }%>
                                    </select>                                    
                                    </div>
                                    <div class="span4">
                                            <label name="agenda_dia">Dia:</label><input type="text" name="agenda_dia" id="agenda_dia" value="<%=TFecha.ahora(TFecha.formatoVista)%>"/>
                                    </div>
                                    <div class="span4">
                                        <button type="button" id="buscar" class="btn btn-large span12">Buscar Agendas</button>                                                
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
                        <div class="block scrollBox">
                            <div class="scroll" style="">
                                <div class="item clearfix">
                                    <p>                                                      
                                        <button type="button" class="btn btn-large span12" onclick="location.href = '<%= PathCfg.AGENDA_CREA %>'">Nueva Agenda</button>                                        
                                    </p>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>


            </div>
            <div class="row-fluid">
                <div class="span12">
                    <div id="tablaAgenda"></div>
                </div>
            </div>
        </div>
        <script>
            var $prof_id = $('#prof_id');            
            $('#tablaAgenda').jtable({
                title:'Administraci&oacute;n de agendas',
                sorting:true,
                actions:{
                    listAction:'<%= PathCfg.AGENDA_LIST %>',
                    deleteAction:'<%= PathCfg.AGENDA_DEL %>'
                },
                fields:{
                    agenda_id:{                        
                        key:true,
                        list:false,
                    },
                    prof_id:{                        
                        title:'Profesional',
                        options:'<%=PathCfg.OPTIONS%>?type=Profesionales'                    
                    },
                    agenda_dia:{
                        title:'Dia',
                        display:function(data){
                            return formatDate(new Date(getDateFromFormat(data.record.agenda_dia,"<%= TFecha.formatoBD %>")),"<%= TFecha.formatoVista%>")
                        },
                    },
                    agenda_turnos:{
                        title:"Turnos",
                        display:function(data){
                            console.log(data.record);                        
                            return data.record.agenda_turn_asig+ "/" + data.record.agenda_turn_cant;                    
                        }                
                    },
                    agenda_consultorio:{
                        title:'Consultorio',
                    },
                    agenda_hinicio:{
                        title:'H. Inicio',
                    },
                    agenda_hfin:{
                        title:'H. Fin',
                    },
                    agenda_alta:{
                        title:'',
                        list:false,
                        edit:false,
                    },
                    Administrar:{
                        title: '',
                            width: '1%',
                            sorting: false,
                            edit: false,
                            create: false,
                            display: function(data) {
                                var $img2 = $('<button class="btn btn-small">Administrar</button>');
                                $img2.click(function() {
                                    window.location = "<%=PathCfg.TURNOS_PATH%>" + '?agenda_id=' + data.record.agenda_id 
                                });
                                return $img2
                           }
                    },
                    Editar: {
                            title: '',
                            width: '1%',
                            sorting: false,
                            edit: false,
                            create: false,
                            display: function(data) {
                                var $img2 = $('<button class="btn btn-small">Editar</button>');
                                $img2.click(function() {
                                    window.location = "<%=PathCfg.AGENDA_EDIT%>" + '?agenda_id=' + data.record.agenda_id 
                                });
                                return $img2
                           }
                    }

                },
            });
           
            $(document).ready(function(){
                //loadTabla($('#prof_id').val());
                $('#buscar').click(function(){
                    loadTabla($('#prof_id').val(),$('#agenda_dia').val());
                });
                loadTabla($('#prof_id').val(),$('#agenda_dia').val());
                $('#agenda_dia').datepicker();
            });
            function loadTabla(id,dia){
                $('#tablaAgenda').jtable('load',{prof_id:id,agenda_dia:dia});
                
            }
                
        </script>
</body>
</html>