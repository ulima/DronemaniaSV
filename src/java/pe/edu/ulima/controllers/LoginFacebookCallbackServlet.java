package pe.edu.ulima.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.ulima.controllers.adapters.LoginAdapter;
import pe.edu.ulima.controllers.adapters.LoginFacebookAdapter;

public class LoginFacebookCallbackServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            LoginAdapter loginAdapter = new LoginFacebookAdapter();
            loginAdapter.verificarLogin(request);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        response.sendRedirect("main.jsp");
    }

}
