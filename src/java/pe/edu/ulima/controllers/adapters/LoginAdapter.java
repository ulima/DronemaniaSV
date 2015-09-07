package pe.edu.ulima.controllers.adapters;

import javax.servlet.http.HttpServletRequest;

public interface LoginAdapter {
    public String login(HttpServletRequest request) throws Exception;
    public void verificarLogin(HttpServletRequest request) throws Exception;
}
