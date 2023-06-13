package com.example.proyecto_final_base_japyld.BeansGenerales;

import java.math.BigDecimal;

public class Juegos {
    public int getIdJuegos() {
        return idJuegos;
    }

    public void setIdJuegos(int idJuegos) {
        this.idJuegos = idJuegos;
    }

    public String getNombreJuegos() {
        return nombreJuegos;
    }

    public void setNombreJuegos(String nombreJuegos) {
        this.nombreJuegos = nombreJuegos;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public String getEstaoJuego() {
        return estaoJuego;
    }

    public void setEstaoJuego(String estaoJuego) {
        this.estaoJuego = estaoJuego;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Imagen getImagen() {
        return imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    private int idJuegos;
    private String nombreJuegos;
    private int stock;
    private BigDecimal precio;
    private String estaoJuego;
    private String descripcion;
    private Imagen imagen;
    private Categoria categoria;
}
