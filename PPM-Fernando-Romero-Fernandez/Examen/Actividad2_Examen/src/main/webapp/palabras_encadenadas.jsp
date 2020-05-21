<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Palabras Resultado</title>
</head>
<body>

<h1>Palabras encadenadas</h1>

<%
    int resultado = (Integer) request.getAttribute("resultado");

    String palabrasConcatenadas = (String) request.getAttribute("resultado");
    ArrayList<String> listaPalabras = (ArrayList<String>) request.getAttribute("listaDePalabras");


    out.print("<p> El resultado de la suma es: " + resultado + "</p>");
    out.print("<p> La concatenación de " + listaPalabras.get(1) + ", " + listaPalabras.get(2) + "y " + listaPalabras.get(3) + " es " + palabrasConcatenadas + "</p>");

%>

</body>
</html>