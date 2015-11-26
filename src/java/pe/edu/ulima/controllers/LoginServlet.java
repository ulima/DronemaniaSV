package pe.edu.ulima.controllers;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.ulima.controllers.dto.LoginRequest;
import pe.edu.ulima.controllers.dto.LoginResponse;
import pe.edu.ulima.model.GestorUsuarios;

/*
 * Input:
 * {
 *   "usuario":"is2",
 *   "password": "123"
 * }
 * Output:
 * {
 *   "msgStatus": "OK",
 *   "msgError" : ""
 * }
*/

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InputStream is = request.getInputStream();
        
        Reader reader = new InputStreamReader(is, "UTF-8");
        LoginRequest loginRequest = 
                new Gson().fromJson(reader, LoginRequest.class);
        
        GestorUsuarios gestorUsuarios = GestorUsuarios.getInstance();
        boolean res = gestorUsuarios.login(
                loginRequest.getUsuario(), 
                loginRequest.getPassword()
        );
        
        String json = "";
        if (res){
            LoginResponse loginResponse = new LoginResponse("OK", "");
            json = new Gson().toJson(loginResponse);
        }else{
            LoginResponse loginResponse = new LoginResponse("Error", 
                    "Login incorrecto");
            json = new Gson().toJson(loginResponse);
        }
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(json);
        
    }

}
