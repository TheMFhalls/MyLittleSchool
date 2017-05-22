package controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Controlador extends HttpServlet {
    public void outJson(
        HttpServletRequest request, 
        HttpServletResponse response,
        String getData
    ) throws IOException{
        Gson json = new GsonBuilder().setDateFormat("dd/MM/yyyy HH:mm:ss").create();
        String data = json.toJson(request.getAttribute(getData));
        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(data);
    }
}
