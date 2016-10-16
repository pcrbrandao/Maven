<%-- 
    Document   : index
    Created on : 03/02/2016, 18:05:25
    Author     : pcrbrandao
--%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
         pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Autenticação</title>
    </head>
    <body>
        <h6>
            <%
                String mensagem =(String)session.getAttribute("mensagem");
                if(mensagem==null || mensagem.length()==0)
                    mensagem="Olá, você!";
                out.print(mensagem);
            %>
        </h6>
        <h1>Digite o nome do usuário e clique em Autentica</h1>
        <form action="/Receitas/AutenticaServlet" method="POST">
            <fieldset>
                <legend>Autenticação</legend>
                Nome: <input type="text" name="nome" value="" />
                <input type="submit" value="Autentica" name="procuraInput" />
                <input type="reset" name="reset" value="Limpa" />
            </fieldset><br/>
        </form>
    </body>
</html>
