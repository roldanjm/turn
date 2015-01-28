<%@page import="java.util.Calendar"%>
<%@page import="java.util.ArrayList"%>
<%@page import="utilitarios.PathCfg"%>
<%@page import="bd.Agenda"%>
<%@page import="bd.Profesional"%>
<%@page import="java.util.List"%>
<%@page import="transaccion.TProfesional"%>
<%
    List<Profesional> lstProfesional = new TProfesional().getList();    
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
                        <form action="<%=PathCfg.AGENDA_CREA %>" method="POST">
                            <input type="hidden" name="agenda_id" value="">
                            <input type="hidden" name="agenda_alta" value="">
                        <div class="row-form clearfix">
                            <div class="span4"><label for="prof_id">Profesional:</label>
                                <select name="prof_id" id="prof_id">
                                    <option value="0">Seleccionar el profesional </option>
                                    <% for (Profesional prof: lstProfesional) {%>
                                    <option value="<%=prof.getProf_id()%>">
                                        <%=prof.getProf_apellido() + ", " +prof.getProf_nombre()%>
                                    </option>
                                    <% }%>
                                </select>                                    
                            </div>                            
                        </div>                                                               
                        
                        <div class="row-form clearfix">
                            <div class="span2"><label for="agenda_dia">Dia Inicio:</label><input type="text" name="agenda_dia_inicio" id="agenda_dia_inicio" value=""/></div>
                            <div class="span2"><label for="agenda_dia">Dia Fin:</label><input type="text" name="agenda_dia_fin" id="agenda_dia_fin" value=""/></div>
                            <div class="span2">
                                    <label for="agenda_dia_lun">Lunes:<input type="checkbox" name="agenda_dia_sem" id="agenda_dia_lun" value="<%=Calendar.MONDAY %>"/></label>
                                    <label for="agenda_dia_mar">Martes:<input type="checkbox" name="agenda_dia_sem" id="agenda_dia_mar" value="<%=Calendar.TUESDAY %>"/> </label>
                                    <label for="agenda_dia_mier">Miercoles:<input type="checkbox" name="agenda_dia_sem" id="agenda_dia_mier" value="<%=Calendar.WEDNESDAY %>"/></label>
                            </div> 
                            <div class="span2"> 
                                    <label for="agenda_dia_jue">Jueves:<input type="checkbox" name="agenda_dia_sem" id="agenda_dia_jue" value="<%=Calendar.THURSDAY %>"/></label>
                                    <label for="agenda_dia_vie">Viernes:<input type="checkbox" name="agenda_dia_sem" id="agenda_dia_vie" value="<%=Calendar.FRIDAY %>"/></label>
                                    <label for="agenda_dia_sab">Sabado:<input type="checkbox" name="agenda_dia_sem" id="agenda_dia_sab" value="<%=Calendar.SATURDAY %>"/></label>
                            </div>
                            <div class="span2">                                     
                                    <label for="agenda_dia_dom">Domingo:<input type="checkbox" name="agenda_dia_sem" id="agenda_dia_dom" value="<%=Calendar.SUNDAY %>"/></label>
                            </div>
                        </div>
                       <div class="row-form clearfix">     
                            <div class="span2"><label for="agenda_hinicio">Hora inicio:</label><input type="text" name="agenda_hinicio" id="agenda_hinicio" value=""/></div>
                            <div class="span2"><label for="agenda_hfin">Hora fin:</label><input name="agenda_hfin" id="agenda_hfin" type="text" value=""/></div>                            
                            <div class="span2"><label for="agenda_intervalo">Intervalo:</label>
                                <select name="agenda_intervalo" id="agenda_intervalo" value=""/>                                
                                    <% for (int i=0;i<lstIntervalos.length;i++) {%>
                                        <option value="<%=lstIntervalos[i]%>">
                                            <%=lstIntervalos[i]%>
                                        </option>
                                        <% }%>
                                </select>
                                
                            </div>
                        </div>                                                                             

                        <div class="row-form clearfix">
                            <div class="span4"><label for="agenda_consultorio">Consultorio:</label><input type="text" name="agenda_consultorio" id="agenda_consultorio" value=""/></div>                            
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
<script>
    $(document).ready(function(){
        $('#agenda_dia_inicio').datepicker();
        $('#agenda_dia_fin').datepicker();
    });
</script>
</body>
</html>