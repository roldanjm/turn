<%@page import="java.util.List"%>
<%@page import="transaccion.TEspecialidad"%>
<%@page import="bd.Especialidad"%>
<%@page import="bd.Profesional"%>
<%@page import="utilitarios.PathCfg"%>
<%
    List<Especialidad> lstEspecialidades = new TEspecialidad().getList();
    Profesional profesional = (Profesional) request.getAttribute("profesional");
    if (profesional == null){
        profesional = new Profesional();
    }
%>
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
            <div class="page-header">
                <h1>Profesionales <small>/  <% if (profesional.getProf_id()==0) { %>Nuevo<% } else { %> Editar <% } %> profecional</small></h1>
            </div>

           <div class="row-fluid">
                
                <div class="span12">
                    <div class="head clearfix">
                        <div class="isw-grid"></div>
                        <h1>Datos del profesional</h1>
                    </div>
                    <div class="block-fluid">                        
                        <form action="<%= PathCfg.PROFESIONALES_EDIT %>" method="POST">
                        <input type="hidden" name="prof_id" value="<%=profesional.getProf_id()%>">
                        <div class="row-form clearfix">
                            <div class="span3"><label for="prof_matricula">Matricula</label><input type="text" name="prof_matricula" id="prof_matricula" value="<%= profesional.getProf_matricula()%>" /></div>
                        </div>
                        <div class="row-form clearfix">
                            <div class="span4"><label for="prof_apellido">Apellido:</label><input  type="text" name="prof_apellido" id="prof_apellido" value="<%= profesional.getProf_apellido() %>" /></div>
                            <div class="span4"><label for="prof_nombre">Nombre:</label><input type="text" name="prof_nombre" id="prof_nombre" value="<%= profesional.getProf_nombre() %>" /></div>                            
                        </div>
                        <div class="row-form clearfix">
                            <div class="span4">
                                <label for="espe_id">Especialidad</label>
                                <select name="espe_id" id="espe_id">
                                    <% for (Especialidad espe: lstEspecialidades) {%>
                                    <option value="<%= espe.getEspec_id()%>"
                                            <% if(espe.getEspec_id() == profesional.getEspe_id()) {%> selected <% }%>><%= espe.getEspec_detalle() %></option>
                                    <% } %>
                                </select>
                                
                            </div>
                        </div>
                                    
                        <div class="row-form clearfix">
                                <div class="span3"><label for="prof_domicilio" class="">Domicilio</label><input type="text" name="prof_domicilio" id="prof_domicilio" value="<%= profesional.getProf_domicilio()%>"/></div>                       
                                <div class="span3"><label for="prof_telefono" class="">Telefono</label><input type="text" name="prof_telefono" id="pac_telefono" value="<%= profesional.getProf_telefono()%>"/></div>
                                <div class="span3"><label for="prof_celular" class="">Celular</label><input type="text" name="prof_celular" id="pac_celular" value="<%= profesional.getProf_celular()%>"/></div>                       
<!--                                <div class="span6"><label for="prof_mail" class="">Email:</label><input type="text" name="prof_mail" id="pac_mail" value=""/></div> -->
                        </div>                           
                                                                                                 
                        
                        <div class="row-form clearfix">
                            <div class="item clearfix">
                                <p>                                                      
                                    <input type="submit" class="btn btn-large span2" value="Guardar">
                                </p>
                            </div>
                        </div>                        
                        
                    </div>
                </div>
              </form>  
            </div>               
        </div>
        
    </div>
                   
    <script type="text/javascript">
        jQuery(document).ready(function() {                                                        
       
        });
            </script>
</body>
</html>