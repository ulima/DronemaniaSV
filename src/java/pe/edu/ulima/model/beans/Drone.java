package pe.edu.ulima.model.beans;

public class Drone {
    private long id;
    private String modelo;
    private String marca;
    private int stock;
    private double precio;

    public Drone() {
    }

    public Drone(long id, String modelo, String marca, int stock, double precio) {
        this.id = id;
        this.modelo = modelo;
        this.stock = stock;
        this.marca = marca;
        this.precio = precio;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    
}
