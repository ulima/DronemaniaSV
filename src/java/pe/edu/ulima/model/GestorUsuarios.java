package pe.edu.ulima.model;

public class GestorUsuarios {
    public boolean login(String usuario, String password){
        if (usuario.equals("is2") && password.equals("123")){
            return true;
        }else{
            return false;
        }
    }
}
