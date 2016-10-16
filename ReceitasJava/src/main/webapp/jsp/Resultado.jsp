<%-- 
    Document   : adicionaUsuario
    Created on : 30/01/2016, 00:02:17
    Author     : pcrbrandao
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Resultado</title>
    </head>
    <body>
        <h6><%=session.getAttribute("sessao")%><br/>
            <%=session.getAttribute("usuario")%>
        </h6>
        <h1>${mensagem}</h1>
        <a href="jsp/Menu.jsp">Início</a>
    </body>
</html>
