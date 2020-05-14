package Servlets;

import jakarta.servlet.annotation.WebServlet;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(
        name="colorFondoCookie",
        urlPatterns = {"/colorFondoCookie"}
)

public class ColorElegidoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonResultado = "";

        Cookie[] cookies = req.getCookies();
        if(cookies != null){
            for(Cookie cookie : cookies){
                if(cookie.getName().equals("color")){
                    jsonResultado = "{\"status\":\"ok\",\"color\":\""+cookie.getValue()+"\"}";
                }
            }
        } else if(cookies == null){
            jsonResultado = "{\"status\":\"ko\"}";
        }
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        out.print(jsonResultado);
    }

}
