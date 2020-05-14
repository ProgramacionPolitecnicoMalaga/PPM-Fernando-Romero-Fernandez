package Servlets;

import jakarta.servlet.annotation.WebServlet;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;

@WebServlet(
        name="colorCookie",
        urlPatterns = {"/colorCookie"}
)

public class CookieColorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String jsonResultado = "";
        String json = req.getReader().lines().collect(Collectors.joining());
        JSONParser jsonParser = new JSONParser();
        try{
            JSONObject jsonObject = (JSONObject) jsonParser.parse(json);
            String rgbcolor = (String) jsonObject.get("color");

            Cookie cookie = new Cookie("color",rgbcolor);
            cookie.setMaxAge(Integer.MAX_VALUE);
            resp.addCookie(cookie);

            jsonResultado = "{\"status\":\"ok\",\"color\":\""+rgbcolor+"\"}";

        } catch (org.json.simple.parser.ParseException e){
            jsonResultado = "{\"status\":\"ko\"}";
            e.printStackTrace();
        }
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json");
        out.print(jsonResultado);
    }
}
