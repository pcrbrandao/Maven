<%-- 
    Document   : index
    Created on : 10/03/2016, 11:17:43
    Author     : pcrbrandao
--%>

<%@ page contentType="text/html; charset=ISO-8859-1" language="java" 
         pageEncoding="UTF-8" import="java.sql.*" errorPage="" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Web Services REST em /usuarios/services/</title>
    </head>
    <body>
    <h1>Web Services REST em /usuarios/services/</h1>
        <ul>
        	<li>GET: listarusuarios</li>
            <li>GET: encontraid: id</li>
            <li>POST: encontranome: usuario</li>
            <li>POST: autenticar: usuario</li>
            <li>POST: criar: usuario</li>
            <li>DELETE: delete: id</li>
            <li>POST: update: usuario</li>
        </ul>
    </body>
</html>
