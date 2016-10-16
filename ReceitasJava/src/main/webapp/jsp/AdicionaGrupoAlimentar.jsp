<%-- 
    Document   : AdicionaGrupoAlimentar
    Created on : 30/01/2016, 12:40:23
    Author     : pcrbrandao
--%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
         pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Adiciona Grupo Alimentar</title>
    <body>
        <h6><%=session.getAttribute("sessao")%><br/>
            <%=session.getAttribute("usuario")%>
        </h6>
        <h1>Digite um nome e clique em adiciona</h1>
        <form action="/Receitas/ReceitaServlet?logica=AdicionaGrupoAlimentar" method="POST"><br/>
            <fieldset >
                <legend>Adiciona Grupo Alimentar</legend>
                    Descricao: <input type="text" name="descricao" value="" />
                    <input type="submit" value="Adiciona" name="OK" />
                    <input type="reset" name="reset" value="Limpa" />
            </fieldset>
            <p><a href="Menu.jsp">Inicio</a></p>
        </form>
    </body>
</html>
