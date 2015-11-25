package pe.edu.ulima.controllers.factories;

import pe.edu.ulima.controllers.adapters.LoginAdapter;
import pe.edu.ulima.controllers.adapters.LoginFacebookAdapter;
import pe.edu.ulima.controllers.adapters.LoginTwitterAdapter;
import pe.edu.ulima.utilitarios.Utiles;

public class LoginFactory {
    private static LoginFactory singleton = null;
    
    public static LoginFactory getInstance(){
        if (singleton == null){
            singleton = new LoginFactory();
        }
        return singleton;
    }
    
    private LoginFactory(){}
    
    public LoginAdapter obtenerLoginAdapter(String tipoLogin){
        //String tipoLogin = Utiles.getValueFromProperty("login");
        
        if (tipoLogin.equals("facebook")){
            return new LoginFacebookAdapter();
        }else if (tipoLogin.equals("twitter")){
            return new LoginTwitterAdapter();
        }else{
            return null;
        }
    }
}
