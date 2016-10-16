<%-- 
    Document   : AdicionaReceitaIngrediente
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
        <title>Adiciona Ingrediente na Receita</title>
    <body>
        <h6><%=session.getAttribute("sessao")%><br/>
            <%=session.getAttribute("usuario")%>
        </h6>
        <h1>Preencha dos dados e clique em adiciona</h1>
        <form action="/Receitas/ReceitaServlet?logica=AdicionaIngredienteNaReceita" method="POST"><br/>
            <fieldset >
                <legend>Adiciona Ingrediente na Receita: ${receita.descricao}</legend>
                <input type="hidden" name="receitaId" value="${receita.id}" />
                Ingrediente: <select name="ingredienteId" size="1">
                    <c:forEach var="in" items="${dependencias['Ingrediente']}">
                        <option value="${in.id}">${in.descricao}</option>
                    </c:forEach>
                </select>
                Unidade: <select name="unidadeId" size="1">
                    <c:forEach var="un" items="${dependencias['Unidade']}">
                        <option value="${un.id}">${un}</option>
                    </c:forEach>
                </select>
                Quantidade: <input type="number" name="quantidade" value="" />
                <input type="submit" name="OK" value="Adiciona" />
                <input type="reset" name="reset" value="Limpa" /><br/>
            </fieldset>
            <p><a href="jsp/Menu.jsp">Inicio</a></p>
        </form>
    </body>
</html>
