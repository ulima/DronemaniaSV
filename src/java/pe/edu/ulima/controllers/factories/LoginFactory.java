package pe.edu.ulima.controllers.factories;

import pe.edu.ulima.controllers.adapters.LoginAdapter;
import pe.edu.ulima.controllers.adapters.LoginFacebookAdapter;
import pe.edu.ulima.controllers.adapters.LoginTwitterAdapter;
import pe.edu.ulima.utilitarios.Utiles;

public class LoginFactory {
    public LoginAdapter obtenerLoginAdapter(){
        String tipoLogin = Utiles.getValueFromProperty("login");
        
        if (tipoLogin.equals("facebook")){
            return new LoginFacebookAdapter();
        }else if (tipoLogin.equals("twitter")){
            return new LoginTwitterAdapter();
        }else{
            return null;
        }
    }
}
