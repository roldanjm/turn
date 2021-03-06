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
                    <h1>Categor&iacute;a <small>/ Administraci&oacute;n</small></h1>
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
                                    <div class="span4"><input type="text" value="span4"/></div>
                                    <div class="span4"><input type="text" value="span4"/></div>
                                    <div class="span4"><input type="text" value="span4"/></div>                            
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
                                        <button type="button" class="btn btn-large span12">Nuevo Paciente</button>                                        
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
                title:'Titulo de la tabla',
                paging: true,
                sorting: true,
                pageSize: 10, //Set page size (default: 10)    
                actions:{
                    listAction:'',
                    updateAction:'',
                    createAction:'',
                    deleteAction:''
                },
                fields:{
                    
                    espe_id:{
                        title:'',
                        options:'<%=PathCfg.OPTIONS%>?type=Especialidades'                      
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
                                    window.location = "<%=PathCfg.PROFESIONALES_EDIT%>" + '?prof_id=' + data.record.prof_id 
                                });
                                return $img2
                           }
                    }
                }
            });
            $(document).ready(function(){
               //$('#idTabla').jtable('load');
            });
        </script>
</body>
</html>