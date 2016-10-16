<%-- 
    Document   : index
    Created on : 03/02/2016, 16:56:39
    Author     : pcrbrandao
--%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
         pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autenticado</title>
    </head>
    <body>
        <h6><%=session.getAttribute("sessao")%><br/>
            <%=session.getAttribute("usuario")%>
        </h6>
        <h3>Olá, <%=((org.receitas.dominio.Usuario)session.getAttribute("usuario")).getNome()%>!<br/>
            Você está autenticado no sistema!</h3><br/>
            <a href="jsp/Menu.jsp">Menu principal</a>
    </body>
</html>
