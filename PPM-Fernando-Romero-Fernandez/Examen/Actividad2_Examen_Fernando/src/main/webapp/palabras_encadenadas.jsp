<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Palabras Resultado</title>
</head>
<body>

<h1>Palabras encadenadas</h1>

<%

    String palabrasConcatenadas = (String) request.getAttribute("resultado");
    ArrayList<String> listaPalabras = (ArrayList<String>) request.getAttribute("listaDePalabras");

    out.print("<p> La concatenación de " + listaPalabras.get(0) + ", " + listaPalabras.get(1) + " y " + listaPalabras.get(2) + " es " + palabrasConcatenadas + "</p>");

%>

</body>
</html>