<%-- 
    Document   : AdicionaReceita
    Created on : 30/01/2016, 12:40:23
    Author     : pcrbrandao
--%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
         pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adiciona Receita</title>
    <body>
        <h6><%=session.getAttribute("sessao")%><br/>
            <%=session.getAttribute("usuario")%>
        </h6>
        <h1>Preencha dos dados e clique em adiciona</h1>
        <form action="/Receitas/ReceitaServlet?logica=AdicionaReceita" method="POST"><br/>
            <fieldset >
                <legend>Adiciona Receita</legend>
                    Descrição: <input type="text" name="descricao" value="" /><br/>
                    Procedimento: <br/>
                    <textarea cols="40" rows="5" name="procedimento" value=""></textarea><br/>
                    <input type="submit" name="OK" value="Adiciona" />
                    <input type="reset" name="reset" value="Limpa" /><br/>
            </fieldset>
            <p><a href="jsp/Menu.jsp">Inicio</a></p>
        </form>
    </body>
</html>
