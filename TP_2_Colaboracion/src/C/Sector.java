/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package C;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo Valentini
 */
public class Sector {
    private int numero;
    private String denominacion;
    private String tipo;
    private Sector sectorPadre;
    private List<Sector> sectorHijos;
    private List<Persona> persona;

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Sector getSectorPadre() {
        return sectorPadre;
    }

    public void setSectorPadre(Sector sectorPadre) {
        this.sectorPadre = sectorPadre;
    }

    public List<Sector> getSectorHijos() {
        return sectorHijos;
    }

    public void setSectorHijos(List<Sector> sectorHijos) {
        this.sectorHijos = sectorHijos;
    }

    public List<Persona> getPersona() {
        return persona;
    }

    public void setPersona(List<Persona> persona) {
        this.persona = persona;
    }
    
    public void listaSectoresRecursiva(Sector s,List<Sector> lista){
        lista.add(s);
        if (s.getSectorHijos() != null) {
            for(Sector sect : s.getSectorHijos()){
                listaSectoresRecursiva(sect, lista);
            }
        }
    }
    
    public List<Sector> obtenerTotalSubsectores(){
        List<Sector> listaSubsectores = new ArrayList<>();
        listaSectoresRecursiva(this, listaSubsectores);
        return listaSubsectores;
    }
    
}
