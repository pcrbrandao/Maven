<%-- 
    Document   : HomeUsuario
    Created on : 03/02/2016, 21:55:22
    Author     : pcrbrandao
--%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
         pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<html>
    <head>
        <title>Receitas</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
        <h6><%=session.getAttribute("sessao")%><br/>
            <%=session.getAttribute("usuario")%>
        </h6>
        <h1>Menu ${param.entidade}</h1>
        <ul>
            <li><a href="/Receitas/ReceitaServlet?logica=PreAdiciona&entidade=${param.entidade}">Adiciona</a></li>
            <li><a href="/Receitas/ReceitaServlet?logica=ListaEntidades&entidade=${param.entidade}">Lista</a></li>
        </ul>
        <a href="Menu.jsp">Menu principal</a>
    </body>
</html>
