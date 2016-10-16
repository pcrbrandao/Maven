<%-- 
    Document   : AdicionarLivro
    Created on : 20/02/2016, 19:07:06
    Author     : pcrbrandao
--%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
         pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adicionar Livro</title>
    </head>
    <body>
        <h1>Preencha os dados e clique em adiciona</h1>
        <form action="/knight/AdicionarLivro" method="POST">
            <fieldset>
                <legend>Adicionar Livro</legend>
                Nome: <input type="text" name="nome" value=""/>
                <input type="submit" name="OK" value="Adiciona" />
                <input type="reset" name="reset" value="Limpa" /><br/>
            </fieldset><br/>
            <a href="/knight/index.jsp">Início</a>
        </form>
    </body>
</html>
