package pe.edu.ulima.controllers;

import com.google.gson.Gson;
import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.ulima.controllers.dto.LoginFacebookResponse;

public class LoginFacebookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Facebook facebook = new FacebookFactory().getInstance();
        facebook.setOAuthAppId("29901234339", "c2f3fc2a246a16b4c8d1cf3d40ff6138");
        request.getSession().setAttribute("facebook", facebook);
        
        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, 
                callbackURL.length(), "").append("/login-facebook-callback");
        
        LoginFacebookResponse loginFacebookResponse 
                = new LoginFacebookResponse(
                        "OK", 
                        "", 
                        facebook.getOAuthAuthorizationURL(callbackURL.toString())
                );
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(loginFacebookResponse));
    }

}
