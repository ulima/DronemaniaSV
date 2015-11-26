package pe.edu.ulima.controllers.dto;

import java.util.List;

public class RegistrarPedidoRequest {
    private long id;
    private String cliente;
    private List<RegistrarPedidoDetalle> detalle;

    public RegistrarPedidoRequest() {
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

    public List<RegistrarPedidoDetalle> getDetalle() {
        return detalle;
    }

    public void setDetalle(List<RegistrarPedidoDetalle> detalle) {
        this.detalle = detalle;
    }
    
    public class RegistrarPedidoDetalle{
        private long idDrone;
        private int cantidad;

        public long getIdDrone() {
            return idDrone;
        }

        public void setIdDrone(long idDrone) {
            this.idDrone = idDrone;
        }

        public int getCantidad() {
            return cantidad;
        }

        public void setCantidad(int cantidad) {
            this.cantidad = cantidad;
        }
        
        
    }
}
