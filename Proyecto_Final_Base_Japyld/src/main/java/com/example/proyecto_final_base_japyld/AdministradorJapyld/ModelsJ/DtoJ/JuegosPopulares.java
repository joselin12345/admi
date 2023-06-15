package com.example.proyecto_final_base_japyld.AdministradorJapyld.ModelsJ.DtoJ;

public class JuegosPopulares {
    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public int getCantidadVentasJuegos() {
        return cantidadVentasJuegos;
    }

    public void setCantidadVentasJuegos(int cantidadVentasJuegos) {
        this.cantidadVentasJuegos = cantidadVentasJuegos;
    }

    public int getCantidadVentasCategorias() {
        return cantidadVentasCategorias;
    }

    public void setCantidadVentasCategorias(int cantidadVentasCategorias) {
        this.cantidadVentasCategorias = cantidadVentasCategorias;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    private int stock;
    private double precio;
    private String nombreCategoria;
    private int cantidadVentasJuegos;
    private int cantidadVentasCategorias;
    private String usuario;
}
