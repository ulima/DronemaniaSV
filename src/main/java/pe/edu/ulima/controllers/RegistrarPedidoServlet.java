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
import pe.edu.ulima.controllers.dto.GenericResponse;
import pe.edu.ulima.controllers.dto.RegistrarPedidoRequest;
import pe.edu.ulima.controllers.dto.RegistrarPedidoRequest.RegistrarPedidoDetalle;
import pe.edu.ulima.model.GestorPedidos;
import pe.edu.ulima.model.beans.DetallePedido;
import pe.edu.ulima.model.beans.Drone;
import pe.edu.ulima.model.beans.Pedido;

/*
Input:
{
    "id": 1,
    "cliente":"Jose Perez",
    "detalle":[
        {
            "idDrone": 3,
            "cantidad": 2
        },
        {
            "idDrone": 2,
            "cantidad": 1
        }
    ]
}
Output:
{
    "msgStatus" : "OK",
    "msgError": ""
}
*/
public class RegistrarPedidoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        InputStream is = request.getInputStream();
        
        Reader reader = new InputStreamReader(is, "UTF-8");
        RegistrarPedidoRequest registrarPedidoRequest = 
                new Gson().fromJson(reader, RegistrarPedidoRequest.class);
        
        Pedido pedido = new Pedido();
        pedido.setId(registrarPedidoRequest.getId());
        pedido.setCliente(registrarPedidoRequest.getCliente());
        
        for (RegistrarPedidoDetalle det : registrarPedidoRequest.getDetalle()){
            DetallePedido detallePedido = new DetallePedido();
            detallePedido.setCantidad(det.getCantidad());
            Drone drone = new Drone();
            drone.setId(det.getIdDrone());
            detallePedido.setDrone(drone);
            pedido.addDetalle(detallePedido);
        }
        
        GestorPedidos.getInstance().registrarPedido(pedido);
        
        GenericResponse genericResponse = new GenericResponse(
                "OK",
                ""
        );
        
        String json = new Gson().toJson(genericResponse);
        
        response.setContentType("application/json");
        PrintWriter out = response.getWriter();
        out.print(json);
    }

}
