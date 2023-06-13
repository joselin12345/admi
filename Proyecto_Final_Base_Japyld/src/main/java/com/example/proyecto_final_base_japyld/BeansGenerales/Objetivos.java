package com.example.proyecto_final_base_japyld.BeansGenerales;

import java.math.BigDecimal;
import java.util.Date;

public class Objetivos {
    public int getIdObjetivos() {
        return idObjetivos;
    }

    public void setIdObjetivos(int idObjetivos) {
        this.idObjetivos = idObjetivos;
    }

    public BigDecimal getVentasPorMesJuego() {
        return ventasPorMesJuego;
    }

    public void setVentasPorMesJuego(BigDecimal ventasPorMesJuego) {
        this.ventasPorMesJuego = ventasPorMesJuego;
    }

    public BigDecimal getGastosPorMesJuego() {
        return gastosPorMesJuego;
    }

    public void setGastosPorMesJuego(BigDecimal gastosPorMesJuego) {
        this.gastosPorMesJuego = gastosPorMesJuego;
    }

    public int getUsuarioPorMes() {
        return usuarioPorMes;
    }

    public void setUsuarioPorMes(int usuarioPorMes) {
        this.usuarioPorMes = usuarioPorMes;
    }

    public int getIdManager() {
        return idManager;
    }

    public void setIdManager(int idManager) {
        this.idManager = idManager;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    private int idObjetivos;
    private BigDecimal ventasPorMesJuego;
    private BigDecimal gastosPorMesJuego;
    private int usuarioPorMes;
    private int idManager;
    private Date fecha;
}
