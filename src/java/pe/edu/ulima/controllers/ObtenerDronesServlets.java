/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.ulima.controllers;

import com.google.gson.Gson;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.ulima.controllers.dto.ObtenerDronesResponse;
import pe.edu.ulima.model.GestorDrones;

/*
Input:
{
}
Output:
{
    "drones" : [
        {
            "id": 1,
            "modelo":"Modelo 1",
            "stock": 3,
            "marca" : "Marca 1",
            "precio": 145.45
        },
        {
            "id": 2,
            "modelo":"Modelo 2",
            "stock": 0,
            "marca" : "Marca 1",
            "precio": 300
        },
        {
            "id": 3,
            "modelo":"Modelo 3",
            "stock": 7,
            "marca" : "Marca 2",
            "precio": 95.7
        },
    ],
    "msgStatus" : "OK",
    "msgError": ""
}
*/


public class ObtenerDronesServlets extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ObtenerDronesResponse obtenerDronesResponse = 
                new ObtenerDronesResponse();
        obtenerDronesResponse.setDrones(
                GestorDrones.getInstance().obtenerDrones());
        obtenerDronesResponse.setMsgStatus("OK");
        obtenerDronesResponse.setMsgError("");
        
        String json = new Gson().toJson(obtenerDronesResponse);
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(json);
    }
}
