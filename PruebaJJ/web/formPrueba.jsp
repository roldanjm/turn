<%-- 
    Document   : formPrueba
    Created on : 12-jul-2014, 11:44:28
    Author     : Axioma
--%>


<%@page import="commands.Prueba"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<%
            Prueba prueba= new Prueba();
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>


        <form action="ServletAlta">
            <input type="text" name="clase" value="Prueba">
            <%=prueba.build("nombre", new String[] {"style='font-size:25px'"})%>
            <%=prueba.build("apellido", new String[] {"style='font-size:25px'"})%>
            <%=prueba.build("dni", new String[] {"style='font-size:25px'"})%>
            <input type="submit" value="Enviar"/>
        </form>
    </body>
</html>
