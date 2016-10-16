<%-- 
    Document   : EncerraSessao
    Created on : 03/02/2016, 22:29:22
    Author     : pcrbrandao
--%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
         pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sessão encerrada</title>
    </head>
    <body>
        <h6><%=session.getAttribute("sessao")%><br/>
            <%=session.getAttribute("usuario")%>
        </h6>
            
        <h1>Sessão encerrada</h1>
        <%
        session.invalidate();
        response.sendRedirect("/Receitas");
        %>
        <a href="/Receitas">Início</a>
    </body>
</html>
