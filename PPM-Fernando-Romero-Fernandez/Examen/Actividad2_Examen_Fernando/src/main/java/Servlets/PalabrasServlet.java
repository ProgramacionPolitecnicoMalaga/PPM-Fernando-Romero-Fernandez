package Servlets;

import Concatenacion.Concatenacion;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class PalabrasServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String v_palabra1 = req.getParameter("palabra1");
        String v_palabra2 = req.getParameter("palabra2");
        String v_palabra3 = req.getParameter("palabra3");

        Concatenacion concatenacion = new Concatenacion();

        ArrayList<String> palabras = new ArrayList<>();
        palabras.add(v_palabra1);
        palabras.add(v_palabra2);
        palabras.add(v_palabra3);

        String resultado = concatenacion.concatenar(palabras);

        req.setAttribute("resultado",resultado);
        req.setAttribute("listaDePalabras",palabras);

        RequestDispatcher vista = req.getRequestDispatcher("palabras_encadenadas.jsp");
        vista.forward(req,resp);
    }
}
