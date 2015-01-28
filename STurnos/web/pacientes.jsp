<%@page import="utils.TFecha"%>
<%@page import="utilitarios.PathCfg"%>
<%
        String[] lstTipoDocu = {"","DNI", "CI", "LE", "LC", "LE", "LC"};    
%>
<html>  
    <head>
    <jsp:include page="tpl_header.jsp"/>
<!-- <script type='text/javascript' src='js/plugins/jtable/jquery.jtable.min.js'></script>-->
<!--<script type="text/javascript" src="js/plugins/jtable/localization/jquery.jtable.es.js"></script>-->

    
</head>
</html>
<body>
    <jsp:include page="tpl_logo.jsp"/>
    <jsp:include page="tpl_menu.jsp"/>
    <div class="content">
        <jsp:include page="tpl_menusuperior.jsp"/>
           <div class="workplace">
            <div class="page-header">
                <h1>Pacientes <small>/ Administraci&oacute;n</small></h1>
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
                                    <div class="span2"><label for="tipodoc_id" >Tipo Doc.</label>
                                <select name="tipodoc_id" id="tipodoc_id" >
                                        <option>  </option>                                                                  
                                            <% for (int i = 0;i<lstTipoDocu.length;i++) {
                                            String tipo = lstTipoDocu[i]; %>
                                            <option value="<%=i%>"><%= tipo%></option>                                                                    
                                            <% }%>
                                </select></div>
                                    <div class="span4"><label for="pac_nrodoc" >N&uacute;mero:<input type="text" name="pac_nrodoc" id="pac_nrodoc" value=""/></label></div>
                                </div>
                                <div class="row-form clearfix">
                                    <div class="span4"><label for="pac_nombre" >Nombre:<input type="text" name="pac_nombre" id="pac_nombre" value=""/></label></div>
                                    <div class="span4"><label for="pac_apellido" >Apellido:<input type="text" name="pac_apellido" id="pac_apellido" value=""/></label></div>
                                </div>                                                               
                                <div class="row-form clearfix">
                                    <p>
                                        <button class="btn btn-large" id="btnBuscar">Buscar</button>
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
                                    <p>                                                      
                                        <button type="button" class="btn btn-large span12"onclick="location.href = '<%= PathCfg.PACIENTES_EDIT %>'">Nuevo Paciente</button>                                        
                                    </p>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>


            </div>
            <div class="row-fluid">
                <div class="span12">
                    <div id="tablaPacientesList"></div>
                </div>
            </div>
        </div>
    </div>
        
    <script type="text/javascript">
            $('#tablaPacientesList').jtable({
                title: 'Administraci&oacute;n de Pacientes',
                paging: true,
                sorting: true,
                pageSize: 10, //Set page size (default: 10)                                                                                                                
                actions: {
                    listAction:'<%= PathCfg.PACIENTES_LIST %>',
                    /* updateAction:'<%= PathCfg.PACIENTES_EDIT %>',  */
                    deleteAction:'<%= PathCfg.PACIENTES_DEL %>'
                    },
                    fields: {
                         pac_id:{
                            key: true,
                            list: false,
                        },
                        pac_nombre:{
                            title:'Nombre',
                            width:'10%'
                        },
                        pac_apellido:{
                            title:'Apellido',
                            width:'10%'
                        },
                        pac_fnacimiento:{
                            title:'Fecha Nac.',
                            width:'7%',
                            type:'date',
                            display: function(data){
                                return formatDate(new Date(getDateFromFormat(data.record.pac_fnacimiento,"<%= TFecha.formatoBD %>")),"<%= TFecha.formatoVista%>")
                                //convertirFecha(data.record.pac_fnacimiento,"yyyy-mm-dd");
                            },
                        },                                                    
                        tipodoc_id:{
                            title: "Tipo Doc",
                            width:'5%',
                            options:'<%=PathCfg.OPTIONS%>?type=TipoDoc' 
                        },
                        pac_nrodoc:{
                            title:"Nro Documento",
                            width: '10%'
                        },
                        pac_sexo:{
                            title:"Sexo",
                            width:'5%',
                            options:{'0':'Sin definir','1':'Masculino','2':'Femenino'},
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
                                    window.location = "<%=PathCfg.PACIENTES_EDIT%>" + '?pac_id=' + data.record.pac_id 
                                });
                                return $img2
                           }
                        }
//                       pac_fechaalta:{},                              
/*                          Acciones: {                          
                            title: 'Acciones',
                            width: '2%',
                            sorting: false,
                            edit: false,
                            create: false,
                            display: function(data) {
                                var $img2 = $('<button>Editar</button>');
                                $img2.click(function() {
                                    window.location = "PacienteEdit?id=" + data.record.post_id
                                });
                                return $img2;
                            }
                        },   */                                                 
/*
                        perfil: {
                            title: 'Perfil',
                            width: '2%',
                            sorting: false,
                            edit: false,
                            create: false,
                            display: function(data) {
                                var $img2 = $('<button>Vista</button>');
                                $img2.click(function() {
                                    dialog(data.record.post_id);
                                });
                                return $img2;
                            }
                        },
                        Historia: {
                            title: '',
                            width: '2%',
                            sorting: false,
                            edit: false,
                            create: false,
                            display: function(studentData) {
                                var $img2 = $('<button>Perfil</button>');
                                $img2.click(function() {
                                    window.location = "Perfil?id=" + studentData.record.post_id
                                });
                                return $img2;
                            }
                        }, */                                                  
                    } 
                });
        function convertirFecha(fecha,formato){
            var arr = fecha.split("-");
            return arr[2] + "/" + arr[1] + "/" + arr[0];
        }
        jQuery(document).ready(function() {                     
          $('#tablaPacientesList').jtable('load');
            $('#btnBuscar').click(function(){
                $('#tablaPacientesList').jtable('load',{
                    tipodoc_id:$('#tipodoc_id').val(),
                    pac_nrodoc:$('#pac_nrodoc').val(),
                    pac_nombre:$('#pac_nombre').val(),
                    pac_apellido:$('#pac_apellido').val(),
                });
            });
        });
            </script>
</body>
</html>