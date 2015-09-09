package pe.edu.ulima.model.beans;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private long id;
    private String cliente;
    private int total;
    private List<DetallePedido> detalles;

    public Pedido() {
    }
    
    public Pedido(long id, String cliente, int total) {
        this.id = id;
        this.cliente = cliente;
        this.total = total;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<DetallePedido> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<DetallePedido> detalles) {
        this.detalles = detalles;
    }
    
    public void addDetalle(DetallePedido detalle){
        if (this.detalles == null){
            this.detalles = new ArrayList<DetallePedido>();
        }
        this.detalles.add(detalle);
    }
}
