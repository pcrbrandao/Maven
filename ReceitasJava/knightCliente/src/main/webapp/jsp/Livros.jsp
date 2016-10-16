<%-- 
    Document   : Livros
    Created on : 20/02/2016, 18:54:19
    Author     : pcrbrandao
--%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
         pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livros</title>
    </head>
    <body>
        <h1>Menu Livros</h1>
        <h2>${mensagem}</h2>
        <table>
            <thead>
                <tr>
                    <th>ID</th><th>Nome</th>
                </tr>
            </thead>
            <c:forEach var="livro" items="${livros}">
                <tr>
                    <td>${livro.id}</td><td>${livro.nome}</td>
                </tr>
            </c:forEach>
        </table><br/>
        <ul>
            <li><a href="/knightCliente/index.jsp">Início</a></li>
        </ul>
    </body>
</html>
