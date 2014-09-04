<jsp:include page="tpl_header.jsp"/>
<body>
    <jsp:include page="tpl_logo.jsp"/>
    <jsp:include page="tpl_menu.jsp"/>
    <div class="content">
        <jsp:include page="tpl_menusuperior.jsp"/>
        <div class="workplace">
            <div id="tablaPacientesList"></div>
        </div>
    </div>
        <script>
            $('#tablaPacientesList').jtable({
                                                title: 'Lista de Pacientes',
                                                paging: true,
                                                sorting: true,
                                                pageSize: 10, //Set page size (default: 10)                                                                                                                
                                                actions: {
                                                    listAction:'PacientesListServlet'
                                                },
                                                /* fields: {
                                                    post_id: {
                                                        key: true,
                                                        list: false,
                                                    },
                                                    post_nombre: {
                                                        title: 'Nombre',
                                                        width: '10%',
                                                    },
                                                    post_apellido: {
                                                        title: 'Apellido',
                                                        width: '10%',
                                                    },
                                                    post_sexo: {
                                                        title: 'Sexo',
                                                        width: '2%',
                                                    },
                                                    post_documento: {
                                                        title: 'Documento'
                                                    },
                                                    post_calificacion_general: {
                                                        title: 'Calificacion',
                                                        type: 'double',
                                                        width: '3%'
                                                    },
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
                                                    },                                                   
                                                } */
                                            });
            </script>
</body>
</html>