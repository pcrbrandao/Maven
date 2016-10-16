<%-- 
    Document   : index
    Created on : 22/02/2016, 19:39:49
    Author     : pcrbrandao
--%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
         pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livros Cliente</title>
    </head>
    <body>
        <h1>Escolha uma opção</h1>
        <h2>${mensagem}</h2>
        <ul>
            <li><a href="/knightCliente/LivroServlet">Livros Cliente</a></li>
        </ul>
    </body>
</html>
