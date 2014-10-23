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
                                    <div class="span4"><label name="agenda_dia">Dia:</label><input type="text" name="agenda_dia" id="agenda_dia" value="span4"/></div>
                                    
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
                                        <button type="button" class="btn btn-large span12" onclick="location.href = '<%= PathCfg.AGENDA_EDIT%>'">Nueva Agenda</button>                                        
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
                title:'Administraci&oacute;n de agenda',
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
                    Editar: {
                            title: '',
                            width: '2%',
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
            $prof_id.change(function(){                
                loadTabla($(this).val());
            });
            $(document).ready(function(){
                loadTabla($('#prof_id').val());
            });
            function loadTabla(id){                
                $('#tablaAgenda').jtable('load',{prof_id:id});
            }
                
        </script>
</body>
</html>