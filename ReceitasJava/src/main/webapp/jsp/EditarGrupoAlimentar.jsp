<%-- 
    Document   : Editar Alimento
    Created on : 30/01/2016, 12:40:23
    Author     : pcrbrandao
--%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
         pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<%@page import="org.receitas.dominio.GrupoAlimentar" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Grupo Alimentar</title>
    <body>
        <h6><%=session.getAttribute("sessao")%><br/>
            <%=session.getAttribute("usuario")%>
        </h6>
        <h1>Faça a alteração e clique em Modificar</h1>
        <a href="/Receitas/ReceitaServlet?logica=ExcluirGrupoAlimentar&id=${grupoalimentar.id}">Excluir</a><br/>
        <form action="/Receitas/ReceitaServlet?logica=EditarGrupoAlimentar&id=${grupoalimentar.id}" method="POST"><br/>
            <fieldset >
                <legend>Editar Grupo Alimentar</legend>
                    Id: ${grupoalimentar.id}<br/>
                    Descrição: <input type="text" name="descricao" value="${grupoalimentar.descricao}">
                    <input type="submit" name="OK" value="Modificar">
                    <input type="reset" name="reset" value="Limpa">
            </fieldset>
        </form>
        <p><a href="jsp/Menu.jsp">Inicio</a></p>
    </body>
</html>
