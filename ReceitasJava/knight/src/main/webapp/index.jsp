<%-- 
    Document   : index
    Created on : 20/02/2016, 18:41:49
    Author     : pcrbrandao
--%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
         pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Livros</title>
    </head>
    <body>
        <h1>Escolha uma opção</h1>
        <h2>${mensagem}</h2>
        <ul>
            <li><a href="/knight/LivroServlet">Livros</a></li>
            <li><a href="/knight/IniciarLivros">Iniciar WebService Livros</a></li>
        <%--<li><a href="/knight/LivroWServlet">Livros WebService</a></li> --%>
        </ul>
    </body>
</html>
