package pe.edu.ulima.model;

public class GestorUsuarios {
    private static GestorUsuarios singleton = null;
    
    public static GestorUsuarios getInstance(){
        if (singleton == null){
            singleton = new GestorUsuarios();
        }
        return singleton;
    }
    
    private GestorUsuarios(){}
    
    public boolean login(String usuario, String password){
        if (usuario.equals("is2") && password.equals("123")){
            return true;
        }else{
            return false;
        }
    }
}
