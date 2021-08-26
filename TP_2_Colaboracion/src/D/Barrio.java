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
public class Barrio {
    private long id;
    private String nombre;
    private String empresaConstructora;
    private List<Vivienda> vivienda;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmpresaConstructora() {
        return empresaConstructora;
    }

    public void setEmpresaConstructora(String empresaConstructora) {
        this.empresaConstructora = empresaConstructora;
    }

    public List<Vivienda> getVivienda() {
        return vivienda;
    }

    public void setVivienda(List<Vivienda> vivienda) {
        this.vivienda = vivienda;
    }
    
    public double getSuperficieTotalTerreno(){
        double totalTerreno = 0;
        if (getVivienda() != null) {
            for(Vivienda v: getVivienda()){
                totalTerreno =+ v.getSuperficieTerreno();                
            }
        }
        return totalTerreno;
    }
    
    public double getSuperficieTotalCubierta(){
        double superficieTotalCubierta=0;
        if (getVivienda()!=null) {
            for(Vivienda v:getVivienda()){
               superficieTotalCubierta =+ v.getMetrosCuadradosCubiertos();
            }
        }
        return superficieTotalCubierta;
    }
    
    
}
