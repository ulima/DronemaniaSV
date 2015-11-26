package pe.edu.ulima.controllers;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.ulima.controllers.adapters.LoginAdapter;
import pe.edu.ulima.controllers.adapters.LoginTwitterAdapter;
import pe.edu.ulima.controllers.dto.LoginTwitterResponse;

public class LoginTwitterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        LoginTwitterResponse loginTwitterResponse;
        try {
            LoginAdapter loginAdapter = new LoginTwitterAdapter();
            String urlCallback = loginAdapter.login(
                    request
            );
            
            loginTwitterResponse = new LoginTwitterResponse(
                    "OK",
                    "",
                    urlCallback
            );
        } catch (Exception ex) {
            loginTwitterResponse = new LoginTwitterResponse(
                    "Exception",
                    ex.getMessage(),
                    null
            );
        }
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(loginTwitterResponse));
    }

}
