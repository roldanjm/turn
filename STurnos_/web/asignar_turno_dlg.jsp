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
    String[] lstTipoDocu = {"","DNI", "CI", "LE", "LC", "LE", "LC"};    
%>
<html>  
    <head>
        <jsp:include page="tpl_header.jsp"/>
        <script type='text/javascript' src='js/plugins/jtable/jquery.jtable.min.js'></script>    
    </head>
</html>
<body>
    <div class="content">        
        <div class="workplace">            
            <div class="row-fluid">                
                <div class="span12">
                    <div class="head clearfix">
                        <div class="isw-grid"></div>
                        <h1>Asignar paciente</h1>
                    </div>
                    <div class="block-fluid">
                        <% if(! turnoAsignado) {%>
                        
                        
                            
                        <div class="row-form clearfix">
                            <div class="span2"><label for=tipodoc_id">Tipo Doc.</label>
                                <select name="tipodoc_id" id="tipodoc_id" >
                                        <option>  </option>                                                                  
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
                            
                            <div class="span3 btn-block">                                
                                <button class="btn " id="btnBuscar">Buscar</button>
                            </div>                                                                                                                                                                
                        </div>         
                        <form action="<%=PathCfg.ASIGNAR_TURNO_DLG%>" method="POST">
                            <input type="hidden" name="asignar_id" id="asignar_id" value="<%=asignar.getAsignar_id()%>"/>
                            <input type="hidden" name="turno_id" id="turno_id" value="<%=turno.getTurno_id()%>"/>

                        <div class="row-form clearfix">
                            <div class="item clearfix" id="lstPacientes"> </div>
                            <div class="item clearfix">
                                <p>                                                      
                                    <input type="submit" class="btn btn-large span2" value="Guardar">
                                </p>
                            </div>
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
        </div>
<script>
    $(document).ready(function(){
        $('#btnBuscar').click(function(){
            console.log("click");
        
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
                },
                success:function(data){
                    console.log(data);
                    if (data.Result == "OK"){
                        $('#lstPacientes').html(construirTabla(data.Records));
                    }                    
                },
                
            })            
        });
    });
    function construirTabla(data){
        var html = "";
        if (data == undefined) {
            html += "<h6>No se encontro ningún paciente con ese tipo y número de documento</h6>";
        }
        else {
            html += "<h6>Seleccione el paciente</h6><ul style='list-style:none'>";    
            for(var i = 0; i<data.length;i++){
                var p = data[i];
                id = "pac_" + p.pac_id;
                html += "<li><label for='" + id + "'><input type='radio' name='pac_id' id='" + id  + "' value='" + p.pac_id +"'>" + p.pac_apellido + ", " + p.pac_nombre + "</label></li>";
            }
            html+="</ul>";
        }
        return html;
    }
</script>
                        
</body>
</html>