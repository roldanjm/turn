<%@page import="utilitarios.PathCfg"%>
<html>  
    <head>
        <jsp:include page="tpl_header.jsp"/>

        <!-- <script type='text/javascript' src='js/plugins/jtable/jquery.jtable.min.js'></script> -->
        <!-- <script type="text/javascript" src="js/plugins/jtable/localization/jquery.jtable.es.js"></script>-->

    </head>
</html>
<body>
    <jsp:include page="tpl_logo.jsp"/>
    <jsp:include page="tpl_menu.jsp"/>
    <div class="content">
        <jsp:include page="tpl_menusuperior.jsp"/>
        <div class="workplace">

            <div class="page-header">
                <h1>Especialidad <small>/ Administraci&oacute;n</small></h1>
            </div>
            <div class="row-fluid">
                <div class="span12">

                    <div class="span8">
                        <div class="span12">
                            <div class="head clearfix">
                                <div class="isw-zoom"></div>
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
                        </div>

                    </div>

                    <div class="span4">
                        <div class="head clearfix">
                            <div class="isw-list"></div>
                            <h1>Acciones</h1>
                            <ul class="buttons">                                        
                                <li class="toggle"><a href="#"></a></li>
                            </ul> 
                        </div>
                        

                    </div>
                </div>


            </div>

            <div class="row-fluid">
                <div class="span12">
                    <div id="tablaEspecialidad"></div>
                </div>
            </div>


        </div>
    </div>

    <script type="text/javascript">
        $('#tablaEspecialidad').jtable({
            title: 'Administraci&oacute;n de Especialidades',
            sorting: true,
            //paging: true,

            //pageSize: 10, //Set page size (default: 10)                                                                                                                
            actions: {
                listAction: '<%= PathCfg.ESPECIALIDADES_LIST%>',
                updateAction: '<%= PathCfg.ESPECIALIDADES_EDIT%>',
                createAction: '<%= PathCfg.ESPECIALIDADES_EDIT%>',
                deleteAction: '<%= PathCfg.ESPECIALIDADES_DEL%>',
            },
            fields: {
                espec_id: {
                    key: true,
                    list: false,
                },
                espec_detalle: {
                    title: 'Especialidad',
                    type: 'textarea'
                },
            }
        });
        jQuery(document).ready(function() {
            $('#tablaEspecialidad').jtable('load');
        });
    </script>
</body>
</html>