<%-- 
    Document   : AdicionaIngrediente
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
        <title>Adiciona Ingrediente</title>
    <body>
        <h6><%=session.getAttribute("sessao")%><br/>
            <%=session.getAttribute("usuario")%>
        </h6>
        <h1>Preencha dos dados e clique em adiciona</h1>
        <form action="/Receitas/ReceitaServlet?logica=AdicionaIngrediente" method="POST"><br/>
            <fieldset >
                <legend>Adiciona Ingrediente</legend>
                    Descrição: <input type="text" name="descricao" value="" />
                    <input type="submit" value="Adiciona" name="OK" />
                    <input type="reset" name="reset" value="Limpa" /><br/>
                    Alimento: <select name="alimentoId" size="1">
                        <c:forEach var="a" items="${dependencias['Alimento']}">
                            <option value="${a.id}">${a}</option>
                        </c:forEach>
                    </select>
            </fieldset>
            <p><a href="jsp/Menu.jsp">Inicio</a></p>
        </form>
    </body>
</html>
