<%@page import="utilitarios.PathCfg"%>
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
                <h1>Profesionales <small>/ Administraci&oacute;n</small></h1>
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
                                    <div class="span4"><label for="prof_matricula">Matricula:<input type="text" id="prof_matricula" name="prof_matricula" value=""/></div>
                                </div>
                                <div class="row-form clearfix">
                                    <div class="span4"><label for="prof_nombre">Nombre:<input type="text" id="prof_nombre" name="prof_nombre" value=""/></div>
                                    <div class="span4"><label for="prof_apellido">Apellido:<input type="text" id="prof_apellido" name="prof_apellido" value=""/></div>
                                </div>          
                                <div class="row-form clearfix">
                                    <button class="btn btn-large" id="btnBuscar">Buscar</button>
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
                                        <button type="button" class="btn btn-large span12" onclick="location.href = '<%= PathCfg.PROFESIONALES_EDIT %>'">Nuevo Profesional</button>                                        
                                    </p>
                                </div>
                            </div>
                        </div>
                    </div>
<!--                    <div class="row-fluid">
                        <div class="span12">
                            
                        </div>
                    </div>-->
                </div>


            </div>
            <div class="row-fluid">
                <div class="span12">
                    <div id="tablaPofesional"></div> 
                </div>
            </div>
        </div>
        
    </div>
                   
    <script type="text/javascript">
        $('#tablaPofesional').jtable({
            title: 'Administraci&oacute;n de Profesionales',
            sorting: true,
            // messages: turkishMessages,
            //paging: true,
            //pageSize: 10, //Set page size (default: 10)                                                                                                                
            actions: {
                listAction:  '<%= PathCfg.PROFESIONALES_LIST %>',
//                updateAction:'<%= PathCfg.PROFESIONALES_EDIT %>',                                             
//                createAction:'<%= PathCfg.PROFESIONALES_EDIT %>',
                deleteAction:'<%= PathCfg.PROFESIONALES_DEL %>',
                },
                fields: {
                    prof_id:{
                        key: true,
                        list: false,
                    },
                    prof_matricula:{
                        title:'Matricula'
                    },
                    prof_nombre:{title:'Nombre'},
                    prof_apellido:{title:'Apellido'},
                    prof_domicilio:{list:false,title:'Domicilio'},
                    prof_telefono:{list:false,title:'Telefono'},
                    prof_ceular:{title:'Celular'},
                    espe_id:{
                        title:'Especialidad',
                        options:'<%=PathCfg.OPTIONS%>?type=Especialidades'                      
                    },
                    usu_id:{list:false,edit:false},
                    Editar: {
                            title: '',
                            width: '2%',
                            sorting: false,
                            edit: false,
                            create: false,
                            display: function(data) {
                                var $img2 = $('<button class="btn btn-small">Editar</button>');
                                $img2.click(function() {
                                    window.location = "<%=PathCfg.PROFESIONALES_EDIT%>" + '?prof_id=' + data.record.prof_id 
                                });
                                return $img2
                           }
                    }
                } 
            });
        jQuery(document).ready(function() {                                                        
                    $('#tablaPofesional').jtable('load');
        });
            </script>
</body>
</html>