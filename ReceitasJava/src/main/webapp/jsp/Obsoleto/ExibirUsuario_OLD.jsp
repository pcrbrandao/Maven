<%-- 
    Document   : ExibeUsuario
    Created on : 02/02/2016, 19:35:24
    Author     : pcrbrandao
--%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
         pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Exibe Usuario</title>
    </head>
    <body>
        <h6><%=session.getAttribute("sessao")%><br/>
            <%=session.getAttribute("usuario")%>
        </h6>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                    <th>Editar</th>
                    <th>Excluir</th>
                </tr>
            </thead>
            <tr>
                <td>${usuario.id}</td>
                <td>${usuario.nome}</td>
                <td><a href="/Receitas/ReceitaServlet?logica=EditaUsuario?id=${usuario.id}">Editar</a></td>
                <td><a href="/Receitas/ReceitaServlet?logica=ExcluirUsuario?id=${usuario.id}">Excluir</a></td>
            </tr>
        </table><br/>
        <a href="jsp/Menu.jsp">Inicio</a>
    </body>
</html>
