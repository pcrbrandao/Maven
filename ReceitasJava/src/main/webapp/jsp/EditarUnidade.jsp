<%-- 
    Document   : Editar Unidade
    Created on : 30/01/2016, 12:40:23
    Author     : pcrbrandao
--%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
         pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Unidade</title>
    <body>
        <h6><%=session.getAttribute("sessao")%><br/>
            <%=session.getAttribute("usuario")%>
        </h6>
        <h1>Faça a alteração e clique em Modificar</h1>
        <a href="/Receitas/ReceitaServlet?logica=ExcluirUnidade&id=${unidade.id}">Excluir</a><br/>
        <form action="/Receitas/ReceitaServlet?logica=EditarUnidade&id=${unidade.id}" method="POST"><br/>
            <fieldset >
                <legend>Editar Unidade</legend>
                    Id: ${unidade.id}<br/>
                    Descricao: <input type="text" name="descricao" value="${unidade.descricao}">
                    Símbolo: <input type="text" name="simbolo" value="${unidade.simbolo}">
                    <input type="submit" name="OK" value="Modificar">
                    <input type="reset" name="reset" value="Limpa">
            </fieldset>
        </form>
        <p><a href="jsp/Menu.jsp">Inicio</a></p>
    </body>
</html>
