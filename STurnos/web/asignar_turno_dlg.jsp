<%@page import="bd.Agenda"%>
<%@page import="transaccion.TAgenda"%>
<%@page import="bd.Turno"%>
<%@page import="utilitarios.PathCfg"%>
<%@page import="bd.Asignar"%>
<%@page import="transaccion.TPaciente"%>
<%@page import="java.util.List"%>
<%@page import="bd.Paciente"%>
<%
    List<Paciente> lstPacientes = new TPaciente().getList();
    Asignar asignar = (Asignar) request.getAttribute("asignar");
    Turno turno = (Turno) request.getAttribute("turno");
    boolean turnoAsignado = turno.getTurno_estado()!=0;
    Paciente pacAsignado = (Paciente) request.getAttribute("paciente");
   
    if(asignar == null) asignar = new Asignar();
    String[] lstTipoDocu = {"DNI", "CI", "LE", "LC", "LE", "LC"};    
%>
<html>  
    <head>
        <jsp:include page="tpl_header.jsp"/>
        <script type='text/javascript' src='js/plugins/jtable/jquery.jtable.min.js'></script>    
    </head>
</html>
<body>
    <!--<div class="content">-->        
        <div class="workplace">            
            <div class="row-fluid">                
                <div class="span12">
<!--                    <div class="head clearfix">
                        <div class="isw-grid"></div>
                        <h1>Asignar paciente</h1>
                    </div>-->
                    <div class="block-fluid">
                        <% if(! turnoAsignado) {%>
                            
                        <div class="row-form clearfix">
                            <div class="span2"><label for=tipodoc_id">Tipo Doc.</label>
                                <select name="tipodoc_id" id="tipodoc_id" >
                                        <option value=""></option>
                                            <% for (int i = 0;i<lstTipoDocu.length;i++) {
                                            String tipo = lstTipoDocu[i]; %>
                                            <option value="<%=i%>"><%= tipo%></option>                                                                    
                                            <% }%>
                                </select>
                            </div>  
                            <div class="span2">
                                    <label for=pac_nrodoc">N&uacute;mero:</label>
                                    <input type="text" name="pac_nrodoc" id="pac_nrodoc" value="" />
                            </div>  
                            
                                                                                                                                                              
                        </div>         
                        
                        <div class="row-form clearfix ">
                            <div class="span2"><label for=pac_nombre">Nombre</label>
                                <input type="text" name="pac_nombre" id="pac_nombre" value="" />
                            </div>  
                            <div class="span2">
                                <label for=pac_apellido">Apellido</label>
                                <input type="text" name="pac_apellido" id="pac_apellido" value="" />
                            </div>  
                            
                                                                                                                                                                                   
                        </div>     
                            <div class="row-form clearfix">
                                  <div class="span3 btn-block">                                
                                    <button class="btn " id="btnBuscar">Buscar</button>
                                  </div>
                                
                            </div>       
                            
                        <form action="<%=PathCfg.ASIGNAR_TURNO_DLG%>" method="POST">
                            <input type="hidden" name="asignar_id" id="asignar_id" value="<%=asignar.getAsignar_id()%>"/>
                            <input type="hidden" name="turno_id" id="turno_id" value="<%=turno.getTurno_id()%>"/>

                        <div class="row-form clearfix" style="display:none">
                            <div class="item clearfix" id="lstPacientes"> </div>
                            </div>                          
                      </form>      
                    <%} else {%>
                            <div class="row-form clearfix">
                                <div class="item clearfix">                                    
                                        Turno asignado a : <%= pacAsignado.getPac_apellido() +  ", " + pacAsignado.getPac_nombre() %>
                                </div>                                        

<!--                            <div class="row-form clearfix">
                                <div class="item clearfix">-->
                                    <!--<button class="btn btn-small" id="btnCerrar">Cerrar</button>-->
<!--                                </div>                                        
                            </div>-->
                            </div>                                        

                    <% } %>
                    </div>
                </div>
                
            </div>            
        <!--</div>--> <!--Content -->
<script>
    $(document).ready(function(){
        $('#btnBuscar').click(function(){
            $.ajax({url:'<%= PathCfg.PACIENTES_LIST%>',
                dataType:'json',
                type:'POST',
                statusCode: {
                    404: function() {
                      alert( "page not found" );
                    }
                  },
                data:{
                    tipodoc_id: $('#tipodoc_id').val(),
                    pac_nrodoc:$('#pac_nrodoc').val(),
                    pac_nombre:$('#pac_nombre').val(),
                    pac_apellido:$('#pac_apellido').val(),
                },
                success:function(data){                    
                    if (data.Result == "OK"){
                        console.log(data);
                        $('#lstPacientes').html(construirTabla(data.Records));
                        $('#lstPacientes').parent().css('display','block')
                    }else 
                        $('#lstPacientes').html("");
                },
                
            })            
        });
    });
    var lstTipoDocu = {0:"",
                       1:"DNI",
                       2:"CE",
                       3:"CI",
                       4: "CUIL",};
                       
    function construirTabla(data){
        var html = "";
        if (data == undefined) {
            html += "<h6>No se encontro ningún paciente con ese tipo y número de documento</h6>";
        }
        else {
            html += "<h6>Seleccione el paciente</h6>";  
            html += "<table>";
            html +="<thead><th>Apellido y Nombre<th>Nro. Doc.</th><th></th><tbody>";
            for(var i = 0; i<data.length;i++){
                
                var p = data[i];
                id = "pac_" + p.pac_id;
                html += "<tr>";
                html +="<td>" + p.pac_apellido + ", " + p.pac_nombre + "</td>";
                html +="<td>" + lstTipoDocu[p.tipodoc_id] + " " + p.pac_nrodoc +"</td>";
//                html +="<td>" + p.pac_fnacimiento + "</td>";
//                html +="<td>" + p.pac_fnacimiento + "</td>";
                html +="<td><span class='icon-plus' onclick='asignar("+ p.pac_id +")'><span></td>";
                html +="</tr>";
            }
            html+="</tbody></table>";
        }
        return html;
    }
    function asignar(id){
        $.ajax({url:'<%=PathCfg.ASIGNAR_TURNO_DLG%>',
                //dataType:'json',
                type:'POST',
                statusCode: {
                    404: function() {
                      alert( "page not found" );
                    }
                  },
                data:{
                     pac_id:id,
                     asignar_id:$('#asignar_id').val(),
                     turno_id:$('#turno_id').val(),
                },
                success:function(data){
                    console.log(data); 
                    window.location = "<%=PathCfg.ASIGNAR_TURNO_DLG%>" + "?turno_id=" + $('#turno_id').val();
                },
                
            });            
        
        
    }
</script>
                        
</body>
</html>