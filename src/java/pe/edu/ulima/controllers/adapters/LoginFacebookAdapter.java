package pe.edu.ulima.controllers.adapters;

import facebook4j.Facebook;
import facebook4j.FacebookFactory;
import javax.servlet.http.HttpServletRequest;

public class LoginFacebookAdapter implements LoginAdapter{

    @Override
    public String login(HttpServletRequest request) {
        Facebook facebook = new FacebookFactory().getInstance();
        facebook.setOAuthAppId("29901234339","c2f3fc2a246a16b4c8d1cf3d40ff6138");
        request.getSession().setAttribute("facebook", facebook);
        
        StringBuffer callbackURL = request.getRequestURL();
        int index = callbackURL.lastIndexOf("/");
        callbackURL.replace(index, 
                callbackURL.length(), "").append("/login-facebook-callback");
        
        return facebook.getOAuthAuthorizationURL(callbackURL.toString());
    }

    @Override
    public void verificarLogin(HttpServletRequest request) throws Exception{
        
        Facebook facebook = (Facebook) request.getSession().getAttribute("facebook");

        String oauthCode = request.getParameter("code");
        facebook.getOAuthAccessToken(oauthCode);

    }
    
}
