package pe.edu.ulima.controllers;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.ulima.controllers.adapters.LoginAdapter;
import pe.edu.ulima.controllers.dto.LoginSocialResponse;
import pe.edu.ulima.controllers.factories.LoginFactory;

public class LoginSocialServlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        LoginFactory loginFactory = LoginFactory.getInstance();
        
        String tipoLogin = request.getParameter("network") != null 
                ? request.getParameter("network") : "facebook";
        
        LoginAdapter loginAdapter = loginFactory.obtenerLoginAdapter(tipoLogin);
        LoginSocialResponse loginSocialResponse ;
        try {
            String urlCallback = loginAdapter.login(request);
            loginSocialResponse = new LoginSocialResponse(
                        "OK", 
                        "", 
                        urlCallback
                );
        } catch (Exception ex) {
            loginSocialResponse = new LoginSocialResponse(
                        "Exception", 
                        ex.getMessage(), 
                        null
                );
        }
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(loginSocialResponse));
    }

}
