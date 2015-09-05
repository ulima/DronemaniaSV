package pe.edu.ulima.controllers;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.ulima.controllers.dto.LoginFacebookResponse;
import pe.edu.ulima.controllers.dto.LoginTwitterResponse;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

public class LoginTwitterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Twitter twitter = new TwitterFactory().getInstance();
        request.getSession().setAttribute("twitter", twitter);
        twitter.setOAuthConsumer("kqpGWWje3zCidztrqnL9UZIbP", "QFpfF9qZN6jEl8ZwyW8vgzc5iSbv4dOIzRVnEIn7nbFu4nAh6H");
        
        LoginTwitterResponse loginTwitterResponse;
        try {
            StringBuffer callbackURL = request.getRequestURL();
            int index = callbackURL.lastIndexOf("/");
            callbackURL.replace(index, callbackURL.length(), "").append("/login-twitter-callback");

            RequestToken requestToken = twitter.getOAuthRequestToken(callbackURL.toString());
            request.getSession().setAttribute("requestToken", requestToken);
            loginTwitterResponse = new LoginTwitterResponse(
                        "OK", 
                        "", 
                        requestToken.getAuthenticationURL()
                    );
        } catch (TwitterException e) {
            loginTwitterResponse =
                new LoginTwitterResponse("Exception", e.getMessage(), null);
        }
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(new Gson().toJson(loginTwitterResponse));
    }

}
