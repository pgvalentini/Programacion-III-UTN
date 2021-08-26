/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C;

import java.util.List;

/**
 *
 * @author Pablo Valentini
 */
public class TipoActividad {
    private int codigo;
    private char denominacion;
    private double puntosAsignados;
    private List<Actividad> actividad;

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public char getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(char denominacion) {
        this.denominacion = denominacion;
    }

    public double getPuntosAsignados() {
        return puntosAsignados;
    }

    public void setPuntosAsignados(double puntosAsignados) {
        this.puntosAsignados = puntosAsignados;
    }

    public List<Actividad> getActividad() {
        return actividad;
    }

    public void setActividad(List<Actividad> actividad) {
        this.actividad = actividad;
    }
    
}
