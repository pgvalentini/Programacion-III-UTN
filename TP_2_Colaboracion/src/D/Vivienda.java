/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package D;

import java.util.List;

/**
 *
 * @author Pablo Valentini
 */
public class Vivienda {
    private long id;
    private String calle;
    private int numeroCalle;
    private double superficieTerreno;
    private List<Habitacion> habitacion;
    private Barrio barrio;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getNumeroCalle() {
        return numeroCalle;
    }

    public void setNumeroCalle(int numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    public double getSuperficieTerreno() {
        return superficieTerreno;
    }

    public void setSuperficieTerreno(double superficieTerreno) {
        this.superficieTerreno = superficieTerreno;
    }

    public List<Habitacion> getHabitacion() {
        return habitacion;
    }

    public void setHabitacion(List<Habitacion> habitacion) {
        this.habitacion = habitacion;
    }

    public Barrio getBarrio() {
        return barrio;
    }

    public void setBarrio(Barrio barrio) {
        this.barrio = barrio;
    }
    
    public double getMetrosCuadradosCubiertos(){
        double metrosCubiertos=0;
        if (getHabitacion()!=null) {
            for(Habitacion h:getHabitacion()){
                metrosCubiertos =+ h.getMetrosCuadrados();
            }
        }
        if (getBarrio().getSuperficieTotalTerreno()<metrosCubiertos) {
            System.out.println("La superficie no puede ser mayor a la superficie del terreno");
        }
        return metrosCubiertos;
    }
    
}
