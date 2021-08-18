/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;

import java.util.ArrayList;

/**
 *
 * @author Pablo Valentini
 */
public class Cliente {
    private int numero;
    private String razonSocial;
    private long cuit;
    private ArrayList<Factura> factura = new ArrayList<>();

    public Cliente(int numero, String razonSocial, long cuit) {
        this.numero = numero;
        this.razonSocial = razonSocial;
        this.cuit = cuit;
    }
    public Cliente(String razonSocial, long cuit) {
        this.razonSocial = razonSocial;
        this.cuit = cuit;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public long getCuit() {
        return cuit;
    }

    public void setCuit(long cuit) {
        this.cuit = cuit;
    }

    public ArrayList<Factura> getFactura() {
        return factura;
    }

    public void setFactura(ArrayList<Factura> factura) {
        this.factura = factura;
    }
    
}
