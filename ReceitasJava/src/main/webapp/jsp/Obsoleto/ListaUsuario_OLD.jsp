<%-- 
    Document   : ListaUsuarios
    Created on : 01/02/2016, 23:05:56
    Author     : pcrbrandao
--%>


<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
         pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista dos Usuários</title>
    </head>
    <body>
        <h6><%=session.getAttribute("sessao")%><br/>
            <%=session.getAttribute("usuario")%>
        </h6>
        <h1>Lista todos os usuários</h1>
        <table>
            <thead>
                <tr>
                    <th>Id</th>
                    <th>Nome</th>
                </tr>
            </thead>
            <c:forEach var="usuario" items="${listaEntidades}">
                <tr>
                    <td><a href="jsp/EditarUsuario.jsp?id=${usuario.id}&nomeNovo=${usuario.nome}">${usuario.id}</a></td>
                    <td>${usuario.nome}</td>
                </tr>
            </c:forEach>
        </table><br/>
        <a href="jsp/Menu.jsp">Início</a>
    </body>
</html>
