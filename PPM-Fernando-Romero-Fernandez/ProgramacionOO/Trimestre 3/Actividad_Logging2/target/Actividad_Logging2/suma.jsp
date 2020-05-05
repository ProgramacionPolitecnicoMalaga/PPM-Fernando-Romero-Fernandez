<%@ page import="Logging.MiLogger" %>
<%@ page import="java.util.logging.Level" %><%--
  Created by IntelliJ IDEA.
  User: Fernan
  Date: 30/04/2020
  Time: 21:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Suma</title>
</head>
<body>

<h1>¿Cuál fue el resultado de la suma?</h1>

<%
    int resultado = (Integer) request.getAttribute("resultado");
    out.print("<p> El resultado de la suma es: " + resultado + "</p>");

    MiLogger.milogger.log(Level.INFO, "Esta aplicación es de Fernando Romero Fernández");

%>

</body>
</html>