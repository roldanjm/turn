<%@page import="java.util.ArrayList"%>
<%@page import="utilitarios.PathCfg"%>
<%@page import="bd.Agenda"%>
<%@page import="bd.Profesional"%>
<%@page import="java.util.List"%>
<%@page import="transaccion.TProfesional"%>
<%
    List<Profesional> lstProfesional = new TProfesional().getList();
    Agenda agenda = (Agenda) request.getAttribute("agenda");
    if (agenda==null) {
        agenda = new Agenda();
    }
    int[] lstIntervalos = {10,15,30,45,60};
%>
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
                    <h1>Agenda <small>/ Nueva </small></h1>
            </div>    
            <div class="row-fluid">
                
                <div class="span12">
                    <div class="head clearfix">
                        <div class="isw-grid"></div>
                        <h1>Datos de la agenda</h1>
                    </div>
                    <div class="block-fluid">                        
                        <form action="<%=PathCfg.AGENDA_EDIT %>" method="POST">
                            <input type="hidden" name="agenda_id" value="<%=agenda.getAgenda_id()%>">
                            <input type="hidden" name="agenda_alta" value="<%= agenda.getAgenda_alta() %>">
                        <div class="row-form clearfix">
                            <div class="span4"><label for="prof_id">Profesional:</label>
                                <select name="prof_id" id="prof_id">
                                    <option value="0">Seleccionar el profesional </option>
                                    <% for (Profesional prof: lstProfesional) {%>
                                    <option value="<%=prof.getProf_id()%>"
                                           <% if (agenda.getProf_id() == prof.getProf_id()) { %>
                                           selected
                                           <% } %>
                                           ><%=prof.getProf_apellido() + ", " +prof.getProf_nombre()%>
                                    </option>
                                    <% }%>
                                </select>                                    
                            </div>
                            
                        </div>                                                               
                        
                        <div class="row-form clearfix">
                            <div class="span2"><label for="agenda_dia">Dia:</label><input type="text" name="agenda_dia" id="agenda_dia" value="<%= agenda.getAgenda_dia()%>"/></div>
                            <div class="span2"><label for="agenda_hinicio">Hora inicio:</label><input type="text" name="agenda_hinicio" id="agenda_hinicio" value="<%= agenda.getAgenda_hinicio()%>"/></div>
                            <div class="span2"><label for="agenda_hfin">Hora fin:</label><input name="agenda_hfin" id="agenda_hfin" type="text" value="<%=agenda.getAgenda_hfin()%>"/></div>                            
                            <div class="span2"><label for="agenda_intervalo">Intervalo:</label>
                                <select name="agenda_intervalo" id="agenda_intervalo" value="<%=agenda.getAgenda_hfin()%>"/>                                
                                    <% for (int i=0;i<lstIntervalos.length;i++) {%>
                                        <option value="<%=lstIntervalos[i]%>">
                                            <%=lstIntervalos[i]%>
                                        </option>
                                        <% }%>
                                </select>
                                
                            </div>
                        </div>                                                                             

                        <div class="row-form clearfix">
                            <div class="span4"><label for="agenda_consultorio">Consultorio:</label><input type="text" name="agenda_consultorio" id="agenda_consultorio" value="<%= agenda.getAgenda_consultorio() %>"/></div>                            
                        </div>   
                        
                        <div class="row-form clearfix">
                            <div class="item clearfix">
                                <p>                                                      
                                    <input type="submit" class="btn btn-large span2" value="Guardar">
                                </p>
                            </div>
                        </div>                           
                                                                            
                        </form>
                    </div>
                </div>
                
            </div>            
            
            <div class="dr"><span></span></div>
            
        </div>

</body>
</html>