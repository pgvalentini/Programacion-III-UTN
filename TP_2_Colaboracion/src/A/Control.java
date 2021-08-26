package A;


import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Pablo Valentini
 */
public class Control {
    private int id;
    private String denomoniacion;
    private boolean esObligatorio;
    private ArrayList<EstadoControl> estadoControl = new ArrayList();
    private ArrayList<Expediente> expediete = new ArrayList();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDenomoniacion() {
        return denomoniacion;
    }

    public void setDenomoniacion(String denomoniacion) {
        this.denomoniacion = denomoniacion;
    }

    public boolean isEsObligatorio() {
        return esObligatorio;
    }

    public void setEsObligatorio(boolean esObligatorio) {
        this.esObligatorio = esObligatorio;
    }

    public ArrayList<EstadoControl> getEstadoControl() {
        return estadoControl;
    }

    public void setEstadoControl(ArrayList<EstadoControl> estadoControl) {
        this.estadoControl = estadoControl;
    }

    public ArrayList<Expediente> getExpediete() {
        return expediete;
    }

    public void setExpediete(ArrayList<Expediente> expediete) {
        this.expediete = expediete;
    }
    
}
