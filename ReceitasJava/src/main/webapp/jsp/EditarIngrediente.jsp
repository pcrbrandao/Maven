<%-- 
    Document   : Editar Ingrediente
    Created on : 30/01/2016, 12:40:23
    Author     : pcrbrandao
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
         pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Ingrediente</title>
    <body>
        <h6><%=session.getAttribute("sessao")%><br/>
            <%=session.getAttribute("usuario")%>
        </h6>
        <h1>Faça a alteração e clique em Modificar</h1>
        <a href="/Receitas/ReceitaServlet?logica=ExcluirIngrediente&id=${ingrediente.id}">Excluir</a><br/>
        <form action="/Receitas/ReceitaServlet?logica=EditarIngrediente&id=${ingrediente.id}" method="POST"><br/>
            <fieldset >
                <legend>Editar Ingrediente</legend>
                    Id: ${ingrediente.id}<br/>
                    Descrição: <input type="text" name="descricao" value="${ingrediente.descricao}">
                        Alimento: <select name="alimentoId" size="1">
                            <option value="${ingrediente.alimento.id}">${ingrediente.alimento}</option>
                            <c:forEach var="a" items="${dependencias['Alimento']}">
                                <option value="${a.id}">${a}</option>
                            </c:forEach>
                        </select>
                    <input type="submit" name="OK" value="Modificar">
                    <input type="reset" name="reset" value="Limpa">
            </fieldset>
        </form>
        <p><a href="jsp/Menu.jsp">Inicio</a></p>
    </body>
</html>
