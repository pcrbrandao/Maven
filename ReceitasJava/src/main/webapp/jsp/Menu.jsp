<%-- 
    Document   : Menu
    Created on : 03/02/2016, 20:18:00
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
        <h1>Menu Principal</h1>
        <ul>
            <li><a href="Home.jsp?entidade=Usuario">Usuarios</a></li>
            <li><a href="Home.jsp?entidade=Ingrediente">Ingredientes</a></li>
            <li><a href="Home.jsp?entidade=Receita">Receitas</a></li>
            <li><a href="Home.jsp?entidade=Unidade">Unidades</a></li>
            <li><a href="Home.jsp?entidade=Alimento">Alimentos</a></li>
            <li><a href="Home.jsp?entidade=GrupoAlimentar">Grupo Alimentar</a></li>
        </ul>
        <a href="EncerraSessao.jsp">Encerra sessao</a>
    </body>
</html>