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
            <div id="tablaPofesional"></div>
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
                updateAction:'<%= PathCfg.PROFESIONALES_EDIT %>',                                             
                createAction:'<%= PathCfg.PROFESIONALES_EDIT %>',
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
                    usu_id:{list:false,edit:false}

                } 
            });
        jQuery(document).ready(function() {                                                        
                    $('#tablaPofesional').jtable('load');
        });
            </script>
</body>
</html>