package pe.edu.ulima.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Input:
 * {
 *   "usuario":"is2",
 *   "password": "123"
 * }
 * Output:
 * {
 *   "msg_status": "OK",
 *   "msg_error" : ""
 * }
*/

public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}