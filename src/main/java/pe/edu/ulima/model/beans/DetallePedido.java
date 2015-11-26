package pe.edu.ulima.model.beans;

public class DetallePedido {
    private Drone drone;
    private int cantidad;

    public DetallePedido(Drone drone, int cantidad) {
        this.drone = drone;
        this.cantidad = cantidad;
    }

    public DetallePedido() {
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}
