/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package B;

import java.util.Scanner;
import B.Factura;
import B.Cliente;
import B.DetalleFactura;
import B.Articulo;
import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Pablo Valentini
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    private static Scanner sc = new Scanner(System.in).useDelimiter("\n");
    private static final String[][] listaArticulos = {{"100", "Azucar", "20", "U"}, {"101", "Leche", "30", "U"},
                                    {"102", "Aceite", "50", "U"}, {"103", "Sal", "45", "U"},
                                    {"104", "Fideos", "15", "U"}, {"105", "Arroz", "28", "U"},
                                    {"106", "Galletas", "26", "U"}, {"107", "Carne Molida", "220", "Kg"},
                                    {"108", "Shampoo", "42", "U"}, {"109", "Queso Mantecoso", "178", "Kg"},
                                    {"110", "Jamón Cocido", "320", "Kg"}, {"111", "Naranjas", "80", "Kg"}};
    
    public static void main(String[] args) {
        Factura factura = crearFactura();
        
        ingresarArticulos(factura);
        imprimirFactura(factura);
        
    }
    
    static Factura crearFactura() {
        
        Factura factura = new Factura();
        factura.setFecha(leerFecha());
        factura.setNumero(leerNumeroFactura());
        factura.setCliente(leerDatosCliente());
        factura.setTipoPago(leerTipoPago());
        factura.getCliente().getFactura().add(factura);
        
        return factura;
    }
    
    static java.util.Date leerFecha() {
        System.out.println("Ingrese el día de facturación:");
        int dia = sc.nextInt();
        System.out.println("Ingrese el mes de facturación:");
        int mes = sc.nextInt();
        System.out.println("Ingrese el año de facturación:");
        int anio = sc.nextInt();
        boolean fechaValida = ((dia < 1) || (dia > 31) || (mes < 1) || (mes > 12));
        if (fechaValida) {
            System.out.println("[ERROR]: La fecha ingresada no es válida. Inténtelo nuevamente.");
            leerFecha();
        }
        return new java.util.Date(anio, mes, dia);
    }
    
    static void imprimirFactura(Factura factura) {
        System.out.println("Cliente: " + completarConEspacios(factura.getCliente().getRazonSocial()) + "\nCUIT: " + factura.getCliente().getCuit());
        System.out.println("Fecha: " + completarConEspacios((factura.getFecha().getDate()) + "/" + (factura.getFecha().getMonth()) + "/" + (factura.getFecha().getYear())));
        System.out.println("N° factura: " + factura.getNumero());
        System.out.println("Tipo Pago: " + factura.getTipoPago());
        System.out.println(completarConEspacios("Código Ítem") + "\t" + completarConEspacios("Denominación") + "\t" + completarConEspacios("Precio") 
                + "\t" + completarConEspacios("Cantidad") + completarConEspacios("Subtotal"));
        for (DetalleFactura df : factura.getDetalleFactura()) {
            System.out.println(completarConEspacios(String.valueOf(df.getArticulo().getCodigo())) + "\t" + completarConEspacios(df.getArticulo().getDenominacion()) 
                    + "\t" + completarConEspacios(String.valueOf(df.getArticulo().getPrecio())) + "\t" + completarConEspacios(String.valueOf(df.getCantidad())) 
                    + completarConEspacios(String.valueOf(df.getSubtotal())));
        }
        System.out.println("============================================================================================");
        System.out.println("\t\t\t\t\t\t" + completarConEspacios("Total ítems: " + factura.getTotalItems()));
        System.out.println("\t\t\t\t\t\t" + completarConEspacios("Recargo: " + factura.getRecargo()));
        System.out.println("\t\t\t\t\t\t" + completarConEspacios("Total Final: " + factura.getTotalFinal()));
    }
    
    static String completarConEspacios(String cadena) {
        int cantidadEspacios = 12 - cadena.length();
        for (int i = 0; i < cantidadEspacios; i++) {
            cadena += " ";
        }
        return cadena;
    }
        
    static Cliente leerDatosCliente() {
        System.out.println("Ingrese razón social:");
        String razonSocial = sc.next();
        long cuit = 0;
        boolean cuitValido;
        do {
            System.out.println("Ingrese CUIT del cliente:");
            cuit = sc.nextLong();
            cuitValido = (String.valueOf(cuit).length() == 11) ? true : false;
            if (!cuitValido) {
                System.out.println("[ERROR]: El CUIT ingresado no es válido. Inténtelo nuevamente.");
            }
        } while (!cuitValido);
        
        return new Cliente(razonSocial, cuit);
    }

    private static int leerNumeroFactura() {
        System.out.println("Ingrese el número de factura:");
        int nroFactura = sc.nextInt();
        if (nroFactura <= 0) {
            System.out.println("[ERROR]: El número de factura no es válido. Inténtelo nuevamente.");
            nroFactura = leerNumeroFactura();
        }
        return nroFactura;
    }
    
    static String leerTipoPago() {
        System.out.println("Ingrese el tipo de pago (C/TC/TD):");
        String tipoPago = sc.next().toUpperCase();
        if ((!tipoPago.toUpperCase().equals("C")) && (!tipoPago.toUpperCase().equals("TC")) && (!tipoPago.toUpperCase().equals("TD"))) {
            System.out.println("[ERROR]: El tipo de pago ingresado no es válido. Inténtelo nuevamente.");
            tipoPago = leerTipoPago();
        }
        
        return tipoPago;
    }
    
    static int leerCantidadFacturar() {
        
        System.out.println("Ingrese la cantidad de artículos a facturar:");
        int cantidad = sc.nextInt();
        if (cantidad <= 0) {
            System.out.println("[ERROR]: La cantidad de artículos a facturar debe ser mayor a cero. Inténtelo nuevamente.");
            cantidad = leerCantidadFacturar();
        }
        
        return cantidad;
    }
    
    static void ingresarArticulos(Factura factura) {
        int cantidadArticulosFactura = leerCantidadFacturar();
        int contador = 0;
        double totalCompra = 0;
        
        do {
            Articulo articulo = buscarArticulo();
            System.out.println("Ingrese la cantidad deseada del artículo:");
            String cantidadDeseada = sc.next();
            double subTotal = new BigDecimal(Double.valueOf(cantidadDeseada) * Double.valueOf(articulo.getPrecio())).setScale(2, RoundingMode.HALF_DOWN).doubleValue();
            if (articulo.getUnidadMedida().toUpperCase().equals("KG")) {
                double cantidadKg = Double.parseDouble(cantidadDeseada);
                factura.getDetalleFactura().add(new DetalleFactura((int)cantidadKg, subTotal, articulo));
            } else {
                int cantidadUnidad = Integer.parseInt(cantidadDeseada);
                factura.getDetalleFactura().add(new DetalleFactura(cantidadUnidad, subTotal, articulo));
            }
            totalCompra += factura.getTotalItems() + factura.getDetalleFactura().get(contador).getSubtotal();
            contador++;
        } while (contador < cantidadArticulosFactura);
        factura.setTotalItems(totalCompra);
        
        if (factura.getTipoPago().toUpperCase().equals("TC")) {
            factura.setRecargo(factura.getTotalItems() * 10 / 100);
        } else if (factura.getTipoPago().toUpperCase().equals("TD")) {
            factura.setRecargo(factura.getTotalItems() * 5 / 100);
        }
        factura.setTotalFinal(factura.getTotalItems() + factura.getRecargo());
    }
    
    static Articulo buscarArticulo() {
        Articulo articulo = new Articulo();
        System.out.println("ARTÍCULOS A FACTURAR");
        System.out.println("Ingrese el código del artículo:");
        String codigo = sc.next();
        boolean encontrado = false;
        for (int i = 0; i < listaArticulos.length; i++) {
            if (codigo.equals(listaArticulos[i][0])) {
                articulo.setCodigo(Integer.valueOf(listaArticulos[i][0]));
                articulo.setDenominacion(listaArticulos[i][1]);
                articulo.setPrecio(Double.valueOf(listaArticulos[i][2]));
                articulo.setUnidadMedida(listaArticulos[i][3]);
                encontrado = true;
                break;
            }
        }
        
        if (!encontrado) {
            System.out.println("[ERROR]: El código ingresado no corresponde a un artículo en venta. Inténtelo nuevamente.");
            buscarArticulo();
        }
        return articulo;
    }
    
}
