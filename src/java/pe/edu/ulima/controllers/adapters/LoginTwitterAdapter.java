
package pe.edu.ulima.controllers.adapters;

import javax.servlet.http.HttpServletRequest;
import twitter4j.Twitter;
import twitter4j.TwitterFactory;
import twitter4j.auth.RequestToken;

public class LoginTwitterAdapter implements LoginAdapter{

    @Override
    public String login(HttpServletRequest request) throws Exception{
        Twitter twitter = new TwitterFactory().getInstance();
        request.getSession().setAttribute("twitter", twitter);
        twitter.setOAuthConsumer("kqpGWWje3zCidztrqnL9UZIbP",
                "QFpfF9qZN6jEl8ZwyW8vgzc5iSbv4dOIzRVnEIn7nbFu4nAh6H");
        
        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, callbackURL.length(), "").append(
                "/login-twitter-callback");

        RequestToken requestToken = twitter.getOAuthRequestToken(callbackURL.toString());
        request.getSession().setAttribute("requestToken", requestToken);

        return requestToken.getAuthenticationURL();
    }

    @Override
    public void verificarLogin(HttpServletRequest request) throws Exception {
        Twitter twitter = (Twitter) request.getSession().getAttribute("twitter");
        RequestToken requestToken = (RequestToken) request.getSession().getAttribute("requestToken");
        String verifier = request.getParameter("oauth_verifier");
        
        twitter.getOAuthAccessToken(requestToken, verifier);
        request.getSession().removeAttribute("requestToken");
        
        
    }
    
}
