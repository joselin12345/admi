package com.example.proyecto_final_base_japyld.BeansGenerales;


import java.math.BigDecimal;
import java.util.Date;

public class VentaJuegosGeneral {
    private int idVenta;
    private Date fechaPublicacion;
    private String estadoVenta;
    private String razonRechazo;



    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(String estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public String getRazonRechazo() {
        return razonRechazo;
    }

    public void setRazonRechazo(String razonRechazo) {
        this.razonRechazo = razonRechazo;
    }

    public BigDecimal getPrecioUsuario() {
        return precioUsuario;
    }

    public void setPrecioUsuario(BigDecimal precioUsuario) {
        this.precioUsuario = precioUsuario;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public BigDecimal getPrecioAdmi() {
        return precioAdmi;
    }

    public void setPrecioAdmi(BigDecimal precioAdmi) {
        this.precioAdmi = precioAdmi;
    }

    public Personas getUsuario() {
        return usuario;
    }

    public void setUsuario(Personas usuario) {
        this.usuario = usuario;
    }

    public Personas getAdministrador() {
        return administrador;
    }

    public void setAdministrador(Personas administrador) {
        this.administrador = administrador;
    }

    public Juegos getJuego() {
        return juego;
    }

    public void setJuego(Juegos juego) {
        this.juego = juego;
    }

    public Consola getConsola() {
        return consola;
    }

    public void setConsola(Consola consola) {
        this.consola = consola;
    }

    private BigDecimal precioUsuario;
    private String disponibilidad;
    private BigDecimal precioAdmi;
    private  Personas usuario;
    private Personas administrador;
    private Juegos juego;
    private Consola consola;
}
