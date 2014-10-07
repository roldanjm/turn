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
            <div id="tablaEspecialidad"></div>
        </div>
    </div>
        
    <script type="text/javascript">
$('#tablaEspecialidad').jtable({
                                        title: 'Administraci&oacute;n de Especialidades',
                                        sorting: true,
                                        //paging: true,

                                        //pageSize: 10, //Set page size (default: 10)                                                                                                                
                                        actions: {
                                            listAction:  '<%= PathCfg.ESPECIALIDADES_LIST %>',
                                            updateAction:'<%= PathCfg.ESPECIALIDADES_EDIT %>',                                             
                                            createAction:'<%= PathCfg.ESPECIALIDADES_EDIT %>',
                                            deleteAction:'<%= PathCfg.ESPECIALIDADES_DEL %>',
                                            },
                                            fields: {
                                                espec_id:{
                                                    key: true,
                                                    list: false,
                                                },
                                                espec_detalle:{
                                                    title:'Especialidad',                                                        
                                               },                                       
                                            } 
                                        });
        jQuery(document).ready(function() {                                                        
                    $('#tablaEspecialidad').jtable('load');
        });
            </script>
</body>
</html>