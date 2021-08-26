package A;


import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pablo Valentini
 */
public class Expediente {
    private int id;
    private String letra;
    private int numero;
    private String descripcion;
    private String tipo;
    private String ambito;
    private List<Expediente> expedienteHijos;
    private Expediente expedientePadre;
    private ArrayList<Control> control = new ArrayList();

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLetra() {
        return letra;
    }

    public void setLetra(String letra) {
        this.letra = letra;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getAmbito() {
        return ambito;
    }

    public void setAmbito(String ambito) {
        this.ambito = ambito;
    }

    public ArrayList<Control> getControl() {
        return control;
    }

    public void setControl(ArrayList<Control> control) {
        this.control = control;
    }
    
    public String getCaratulaExpediente(){
        return this.getNumero()+"-"+this.getLetra()+"-"+this.getDescripcion();
    }
    
    public String getControlesObligatorios (){
        String lista="";
        if (control.get(0).getDenomoniacion() != null) {
            for (int i = 0; i < control.size(); i++) {
            lista = control.get(i).getDenomoniacion() + ",";
            }
        }
        return lista;
    }
    
    public boolean getEstadoControles(){
        boolean aprobado=true;
        if (control.get(0).getEstadoControl()!= null) {
            for (int i = 0; i < control.size(); i++) {
                for (int j = 0; j < control.get(i).getEstadoControl().size(); i++) {
                    if (!control.get(i).getEstadoControl().get(j).isAprobado()) {
                        aprobado=false;
                        break;
                    }   
                }
            }
        }
        return aprobado; 
    }
    
    public List<Expediente> getExpedienteHijos() {
        return expedienteHijos;
    }

    public void setExpedienteHijos(List<Expediente> expedienteHijos) {
        this.expedienteHijos = expedienteHijos;
    }

    public Expediente getExpedientePadre() {
        return expedientePadre;
    }

    public void setExpedientePadre(Expediente expedientePadre) {
        this.expedientePadre = expedientePadre;
    }
    
    public List<Expediente> listaExpedientes(){
        List<Expediente> listaRecursiva = new ArrayList<Expediente>();
        listaExpedienteRecursiva(this, listaRecursiva);
        return listaRecursiva;
    }   
    
    public void listaExpedienteRecursiva(Expediente ex,List<Expediente> lista){
        lista.add(ex);
        if (ex.getExpedienteHijos()!= null) {
            for (Expediente exhijo : ex.getExpedienteHijos()) {
                listaExpedienteRecursiva(exhijo, lista);
            }
        }
    }
    
}
