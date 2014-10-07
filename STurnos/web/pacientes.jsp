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
            <div id="tablaPacientesList"></div>
        </div>
    </div>
        
    <script type="text/javascript">

        jQuery(document).ready(function() {
            $('#tablaPacientesList').jtable({
                                            title: 'Lista de Pacientes',
                                            paging: true,
                                            sorting: true,
                                            pageSize: 10, //Set page size (default: 10)                                                                                                                
                                            actions: {
                                                listAction:'PacienteList',
//                                                updateAction:'PacienteEdit', 
                                                deleteAction:'PacienteDelete'
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
                                                        type:'date'
                                                    },                                                    
                                                    tipodoc_id:{
                                                        title: "Tipo Doc",
                                                        width:'5%',
                                                    },
                                                    pac_nrodoc:{
                                                        title:"Nro Doc",
                                                        width: '10%'
                                                    },
                                                    pac_sexo:{
                                                        title:"Sexo",
                                                        width:'5%'
                                                    },
                                                   Editar: {
                                                        title: '',
                                                        width: '2%',
                                                        sorting: false,
                                                        edit: false,
                                                        create: false,
                                                        display: function(studentData) {
                                                            var $img2 = $('<button>Editar</button>');
                                                            $img2.click(function() {
                                                                window.location = "PacienteEdit?idpac=" + studentData.record.post_id
                                                            });
                                                            return $img2;
                                                        }
                                                    }
//                                                     pac_fechaalta:{},
/*                                                    Acciones: {
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
                                            
                    $('#tablaPacientesList').jtable('load');
        });
            </script>
</body>
</html>