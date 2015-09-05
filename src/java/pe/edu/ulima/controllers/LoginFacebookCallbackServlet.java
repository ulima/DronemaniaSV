package pe.edu.ulima.controllers;

import facebook4j.Facebook;
import facebook4j.FacebookException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFacebookCallbackServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");
            
            String oauthCode = request.getParameter("code");
            facebook.getOAuthAccessToken(oauthCode);
        } catch (FacebookException ex) {
            Logger.getLogger(LoginFacebookCallbackServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("main.jsp");
    }

}
