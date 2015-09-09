package pe.edu.ulima.model;

import pe.edu.ulima.model.beans.DetallePedido;
import pe.edu.ulima.model.beans.Pedido;

public class GestorPedidos {
    private static GestorPedidos singleton = null;
    
    public static GestorPedidos getInstance(){
        if (singleton == null){
            singleton = new GestorPedidos();
        }
        return singleton;
    }
    
    private GestorPedidos(){}
    
    public void registrarPedido(Pedido pedido){
        System.out.println("Se registro Pedido");
        System.out.println("Id: " + pedido.getId());
        System.out.println("Cliente: " + pedido.getCliente());
        System.out.println("Total: " + pedido.getTotal());
        System.out.println("---- Detalle ----");
        for (DetallePedido detalle : pedido.getDetalles()){
            System.out.println("IdDrone: " + detalle.getDrone().getId());
            System.out.println("Cantidad: " + detalle.getCantidad());
        }
    }
}
