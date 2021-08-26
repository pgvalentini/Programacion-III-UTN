/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Pablo Valentini
 */
public class Empleado {
    private String nombre;
    private long cuit;
    private String domicilio;
    private String email;
    private RegimenHorario regimenHorario;
    private List<Asistencia> asistencia;
    private List<Tardanza> tardanza;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RegimenHorario getRegimenHorario() {
        return regimenHorario;
    }

    public void setRegimenHorario(RegimenHorario regimenHorario) {
        this.regimenHorario = regimenHorario;
    }

    public List<Asistencia> getAsistencia() {
        return asistencia;
    }

    public void setAsistencia(List<Asistencia> asistencia) {
        this.asistencia = asistencia;
    }

    public List<Tardanza> getTardanza() {
        return tardanza;
    }

    public void setTardanza(List<Tardanza> tardanza) {
        this.tardanza = tardanza;
    }
    

    
    public List<Asistencia> getAsistenciaXMesXAnio(int mes,int anio){
        List<Asistencia> lista = new ArrayList<>();
        if (this.getAsistencia() != null) {
            for(Asistencia asist : this.getAsistencia()){
                if(anio==asist.getFecha().getYear()){
                    if (mes==asist.getFecha().getMonth()) {
                        lista.add(asist);
                    }
                }
                
            }
        }
         return lista;
    }
    
    public boolean calcularTardanza(){
        return (this.getAsistencia().get(0).getMinuto() - this.getRegimenHorario().getMinutoIngreso())>15;
    }
    
    public List<Tardanza> getDiasConTardanza(int mes, int anio){
        List<Tardanza> lista = new ArrayList<>();
        if (this.getTardanza()!= null) {
            for(Tardanza tard : this.getTardanza()){
                if(anio==tard.getFecha().getYear()){
                    if (mes==tard.getFecha().getMonth()) {
                        lista.add(tard);
                    }
                }
                
            }
        }
         return lista;
    }
    
}
