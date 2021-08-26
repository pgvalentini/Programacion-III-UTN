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
public class Persona {
    private char nombre;
    private char tipoDocumento;
    private long nroDocumento;
    private int telefono;
    private char email;
    private char celular;
    private Sector sector;
    private List<Actividad> actividad;

    public char getNombre() {
        return nombre;
    }

    public void setNombre(char nombre) {
        this.nombre = nombre;
    }

    public char getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(char tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public long getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(long nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public char getEmail() {
        return email;
    }

    public void setEmail(char email) {
        this.email = email;
    }

    public char getCelular() {
        return celular;
    }

    public void setCelular(char celular) {
        this.celular = celular;
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public List<Actividad> getActividad() {
        return actividad;
    }

    public void setActividad(List<Actividad> actividad) {
        this.actividad = actividad;
    }
    
    public double totalPuntosAsignados(){
        double ptos=0;
        if (getActividad()!=null) {
            for(Actividad act : getActividad()){
               ptos =+ act.getTipoActividad().getPuntosAsignados();
            }
        }
        return ptos;
    }
    
    public double totalPuntosAsignados (int codigo){
        double ptos=0;
        if (getActividad()!=null) {
            for(Actividad act : getActividad()){
               if(act.getTipoActividad().getCodigo()==codigo){
                ptos =+ act.getTipoActividad().getPuntosAsignados();
                }
            }
        }
        return ptos;
    }
    
     public double totalPuntosAsignados (int codigo, int anio){
        double ptos=0;
        if (getActividad()!=null) {
            for(Actividad act : getActividad()){
               if(act.getTipoActividad().getCodigo()==codigo){
                ptos =+ act.getTipoActividad().getPuntosAsignados();
                    if(act.getFechaFin().getYear()==anio){
                    ptos =+ act.getTipoActividad().getPuntosAsignados();
                    }
               }
            }
        }
        return ptos;
    }
    
}