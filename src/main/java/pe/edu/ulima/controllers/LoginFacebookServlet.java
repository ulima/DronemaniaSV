package pe.edu.ulima.controllers;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.ulima.controllers.adapters.LoginAdapter;
import pe.edu.ulima.controllers.adapters.LoginFacebookAdapter;
import pe.edu.ulima.controllers.dto.LoginFacebookResponse;

public class LoginFacebookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        LoginAdapter loginFacebookAdapter = new LoginFacebookAdapter();
        LoginFacebookResponse loginFacebookResponse ;
        try {
            String urlCallback = loginFacebookAdapter.login(request);
            loginFacebookResponse = new LoginFacebookResponse(
                        "OK", 
                        "", 
                        urlCallback
                );
        } catch (Exception ex) {
            loginFacebookResponse = new LoginFacebookResponse(
                        "Exception", 
                        ex.getMessage(), 
                        null
                );
        }
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(loginFacebookResponse));
    }

}
