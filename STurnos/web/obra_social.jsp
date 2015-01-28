<%@page import="utilitarios.PathCfg"%>
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
                    <h1>Obra Social <small>/ Administraci&oacute;n</small></h1>
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
                                    <div class="span4"><label for="os_nombre" >Nombre:<input type="text" name="os_nombre" id="os_nombre" value=""/></label></div>
                                </div>
                                <div class="row-form clearfix">
                                    <div class="span4"><label for="os_cuit" >Cuit:<input type="text" name="os_cuit" id="os_cuit" value=""/></label></div>
                                </div>                                                               
                                <div class="row-form clearfix">
                                    <p>
                                        <button class="btn btn-small" id="btnBuscar">Buscar</button>
                                    </p>
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
<!--                                    <p>                                                      
                                        <button type="button" class="btn btn-large span12 jtable-toolbar-item ">Nueva Obra Social</button>                                       
                                    </p>-->
                                </div>
                            </div>
                        </div>

                    </div>
                </div>


            </div>
            <div class="row-fluid">
                <div class="span12">
                    <div id="obraSocial"></div>
                </div>
            </div>
        </div>
        <script language="javascript">
            var idTabla = "#obraSocial";
            $(idTabla).jtable({
                title:'Obras Sociales',
//                paging: true,
//                sorting: true,
//                pageSize: 10, //Set page size (default: 10)    
                actions:{
                    listAction:  '<%= PathCfg.OBRASOCIAL_LIST %>',
                    updateAction:'<%= PathCfg.OBRASOCIAL_EDIT %>',
                    createAction:'<%= PathCfg.OBRASOCIAL_EDIT %>',
                    deleteAction:'<%= PathCfg.OBRASOCIAL_DEL %>',
                },
                fields:{
                    os_id:{
                        title:'',
                        key:true,
                        list: false,
                    },
                    os_nombre:{
                        title:'Nombre',
                    },
                    os_cuit:{
                        title:'CUIT',
                    },
                    os_direccion:{
                        title:'Direccion',
                        list:true,
                    },
                    os_telefono:{
                        title:'Telefono',
                    },                    
                }
            });
            $(document).ready(function(){
               $(idTabla).jtable('load');
               
               $('#btnBuscar').click(function(){
                $(idTabla).jtable('load',{
                    os_nombre: $('#os_nombre').val(),
                    os_cuit  : $('#os_cuit').val(),
                });
                });
            });
        </script>
</body>
</html>