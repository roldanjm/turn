<%@page import="utils.TFecha"%>
<%@page import="java.util.HashMap"%>
<%@page import="bd.Paciente"%>
<%@page import="utilitarios.PathCfg"%>
<%@page import="bd.Obra_social"%>
<%@page import="bd.Bd_localidad"%>
<%@page import="transaccion.TProvincia"%>
<%@page import="transaccion.TProvincia"%>
<%@page import="transaccion.TObraSocial"%>
<%@page import="java.util.List"%>
<%@page import="bd.Bd_provincia"%>
<%
    String[] lstTipoDocu = {"","DNI", "CI", "LE", "LC", "LE", "LC"};    
    String[] lstSexo = {"No especifica","Femenino","Masculino"};
            
    List<Bd_provincia> lProvincias = new TProvincia().getList();
    List<Bd_localidad> lLocalidades = null;
    List<Obra_social> lObraSocial = new TObraSocial().getList();
    Paciente  paciente = (Paciente) request.getAttribute("paciente");
    if (paciente == null){
        paciente = new Paciente();
    }
    
    int idProv = 0;
    String tipoDocu = "";
    try{
        tipoDocu = lstTipoDocu[paciente.getTipodoc_id()];
    } catch(IndexOutOfBoundsException ex){        
    }
    
%>
<jsp:include page="tpl_header.jsp"/>
<body>
    <jsp:include page="tpl_logo.jsp"/>
    <jsp:include page="tpl_menu.jsp"/>
    <div class="content">
        <jsp:include page="tpl_menusuperior.jsp"/>
        <div class="workplace">
            <div class="page-header">
                    <h1>Pacientes <small>/ <% if (paciente.getPac_id()==0) { %>Nuevo<% } else { %> Editar <% } %> Paciente</small></h1>
            </div>
            <!--<div class="dr"><span></span></div>-->
            
            <div class="row-fluid">
                
                <div class="span12">
                    <div class="head clearfix">
                        <div class="isw-grid"></div>
                        <h1>Datos del paciente</h1>
                    </div>
                    <div class="block-fluid">                        
                        <form action="<%= PathCfg.PACIENTES_EDIT %>" method="POST">
                        <input type="hidden" name="pac_id" value="<%=paciente.getPac_id()%>">
                        <input type="hidden" name="pac_fechaalta" value="<%=paciente.getPac_fechaalta()%>">
                        
                        <div class="row-form clearfix">
                            <div class="span4"><label for="pac_apellido">Apellido:</label><input  type="text" name="pac_apellido" id="pac_apellido" value="<%= paciente.getPac_apellido() %>" /></div>
                            <div class="span4"><label for="pac_nombre">Nombre:</label><input type="text" name="pac_nombre" id="pac_nombre" value="<%= paciente.getPac_nombre() %>" /></div>                            
                        </div>
                        <div class="row-form clearfix">
                            <div class="span2"><label for="pac_nrodoc">Sexo:</label>
                                <select name="pac_sexo"  id="pac_nrodoc" >
                                    <% for(int i = 0;i<lstSexo.length;i++) {%>
                                    <option value="<%= i %>" <% if(i==paciente.getPac_sexo()) {%> selected <% }%> >
                                        <%= lstSexo[i] %></option>
                                    <% } %>
                                </select>
                            </div>  
                        
                                <div class="span2">
                                        <label for="pac_fnacimiento">Fecha Nacimiento:</label><input type="text" name="pac_fnacimiento" id="pac_fnacimiento" value="<%= TFecha.formatearFecha(paciente.getPac_fnacimiento(),TFecha.formatoBD, TFecha.formatoVista)%>" /></div>
                            <div class="span1"><label for=tipodoc_id">Tipo Doc.</label>
                                    <select name="tipodoc_id" id="pac_nrodoc" value="" >
                                        <option>  </option>                                                                  
                                            <% for (int i = 0;i<lstTipoDocu.length;i++) {
                                            String tipo = lstTipoDocu[i]; %>
                                            <option value="<%=i%>"
                                                    <% if (i == paciente.getTipodoc_id()) {%> selected <% }%>
                                                    ><%= tipo%></option>                                                                    
                                            <% }%>
                                </select>
                            </div>  
                            <div class="span2"><label for=pac_nrodoc">N&uacute;mero:</label><input type="text" name="pac_nrodoc" id="pac_nrodoc" value="<%= paciente.getPac_nrodoc()%>" /></div>  
                            
                            
                        </div>
                        
                                                                          

                        <div class="row-form clearfix">
                            <div class="span4"><label for="prov_id">Provincia:</label>
                                <select id="prov_id" name="prov_id" value="span6"/>
                                    <option value="0">Seleccione una provincia</option>
                                    <%
                                        for (Bd_provincia prov : lProvincias) {
                                    %>
                                    <option value="<%=prov.getProv_id()%>" 
                                            <% if (prov.getProv_id() == paciente.getProv_id()) {%> selected <% }%>

                                            > <%=prov.getProv_descripcion()%></option>

                                    <% }%>
                            
                            </select>
                            </div>
                            <div class="span4"><label for="loc_id">Localidad:</label>
                                <select id="loc_id" name="loc_id" value="span6"/>
                                    <option value='0'>Seleccione su localidad</option>
                                </select>
                            </div>                              
                            <div class="span4"><label for="pac_direccion">Direcci&oacute;n:</label><input type="text" id="pac_direccion" name="pac_direccion" value="<%= paciente.getPac_direccion()%>"/></div>                                    
                        </div>        
                        <div class="row-form clearfix">
                            <div class="span4">
                                <label for="os_id">Obra Social:</label>
                                <select name="os_id" id="os_id">
                                    <option value="0"> No posee </option>
                            <% for (Obra_social os: lObraSocial){ %>
                            
                            <option value="<%=os.getOs_id()%>"
                                    <% if (os.getOs_id() == paciente.getOs_id()) {%> selected <% }%>
                                    > <%= os.getOs_nombre()%>                             
                            </option>
                            <% } %>
                                </select>
                            </div>        
                                    
                        </div>            
                                    
                        <div class="row-form clearfix">
                                <div class="span3"><label for="pac_telefono" class="">Telefono:</label><input type="text" name="pac_telefono" id="pac_telefono" value="<%= paciente.getPac_telefono()%>"/></div>
                                <div class="span3"><label for="pac_celular" class="">Celular</label><input type="text" name="pac_celular" id="pac_celular" value="<%= paciente.getPac_celular()%>"/></div>                       
                                <div class="span6"><label for="pac_mail" class="">Email:</label><input type="text" name="pac_mail" id="pac_mail" value="<%=paciente.getPac_mail()%>"/></div>
                        </div>                           
                                                                                                 

                        <div class="row-form clearfix">
                            <div class="span12">
                                <label for="pac_observaciones">Observaciones:</label>
                                <textarea id="pac_observaciones">
                                    <%= paciente.getPac_observaciones() %>
                                </textarea>
                            </div>                            
                            
                        </div>                                                                                                     
                        
                        <div class="row-form clearfix">
                            <div class="item clearfix">
                                <p>                                                      
                                    <input type="submit" class="btn btn-large span2" value="Guardar">
                                </p>
                            </div>
                        </div>                        
                                
<!--                         <div class="row-form clearfix">
                            <div class="span9"><input type="text" value="span9"/></div>
                            <div class="span3"><input type="text" value="span3"/></div>                            
                        </div>   
                        <div class="row-form clearfix">
                            <div class="span12"><input type="text" value="span12"/></div>                            
                        </div>                                                                             -->
                        
                    </div>
                </div>
              </form>  
            </div>   
            
        </div>
    </div>
        <script language="javascript">
            $(document).ready(function(){
                $('#prov_id').change(function() {
                    cargarLocalidades($(this).val(),$('#loc_id').val());
                });
                if($('#prov_id').val() != 0){
                    cargarLocalidades($('#prov_id').val(),<%= paciente.getLoc_id()%>);
                }
                $('#pac_fnacimiento').datepicker({
                      //yearRange: "-20:+0", // this is the option you're looking for                      
                      changeYear: true, 
                      yearRange : '-90:+0',
                      changeMonth: true,
                });

            });
            
            function cargarLocalidades(prov_id,loc_default){
            $('#loc_id').html("");
                        var url = "OpcionesLst?type=Localidades&prov_id=" + prov_id;
                        $.ajax({
                            url: url,
                            dataType:'json',
                            success: function(data) {
                                var html = "<option value='0'>Seleccione su localidad</option>";
                                for( var i = 1; i<data.Options.length;i++){
                                    html += "<option value='" + data.Options[i].Value + "'> " + data.Options[i].DisplayText + "</option>";
                                }
                                $('#loc_id').html(html);
                                
                                $('#loc_id').val(loc_default);
                                console.log($('#loc_id').val());
                            }
                        });
            }
            </script>
</body>
</html>