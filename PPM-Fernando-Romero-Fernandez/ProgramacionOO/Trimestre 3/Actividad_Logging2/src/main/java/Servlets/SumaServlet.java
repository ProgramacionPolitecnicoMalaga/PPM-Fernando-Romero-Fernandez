package Servlets;

import Logging.MiLogger;
import Suma.Suma;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.logging.Level;

public class SumaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int numero1 = Integer.parseInt(req.getParameter("numero1"));
        int numero2 = Integer.parseInt(req.getParameter("numero2"));

        //Logger Parametros obtenidos
        MiLogger miLogger = new MiLogger();
        MiLogger.milogger.log(Level.INFO, "Los operandos recibidos son: " + numero1 + " y " + numero2);

        Suma suma = new Suma();

        int resultado = suma.sumar(numero1,numero2);
        req.setAttribute("resultado",resultado);

        //Logger Resultado
        MiLogger.milogger.log(Level.INFO, "El resultado es " + resultado);

        RequestDispatcher vista = req.getRequestDispatcher("suma.jsp");
        vista.forward(req,resp);
    }
}
