/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package A;

import java.util.Scanner;

/**
 *
 * @author Pablo Valentini
 */
public class CalculoFactura {

    /*
Los valores de los array se corresponden a:
El código del articulo a facturar
La denominación del articulo a facturar
El precio del artículo.
Unidad de Medida del Articulo U (Unidad), Kg (Kilogramos)
     */
    static String[][] articulos = {{"100", "Azucar", "20", "U"}, {"101", "Leche", "30", "U"}, {"102", "Aceite", "50", "U"}, {"103", "Sal", "45", "U"}, {"104", " Fideos", "15", "U"}, {"105", " Arroz", "28", "U"}, {"106", "Galletas", "26", "U"}, {"107", "Carne Molida", "220", "Kg"}, {"108", "Shampoo", "42", "U"}, {"109", "Queso Mantecoso", "178", "Kg"}, {"110", "Jamon Cocido", "320", "Kg"}, {"111", "Naranjas", "80", "Kg"}};
  
    public static void main(String[] args) {
  
        
        Scanner teclado = new Scanner(System.in);
        Factura f1 = new Factura();

        System.out.println("Ingrese fecha factura");
        f1.setFecha(teclado.nextLine());
        System.out.println("Ingrese Número factura");
        f1.setNroFactura(teclado.nextLong());
        System.out.println("Ingrese Razón Social");
        f1.setRazonSocial(teclado.nextLine());
        System.out.println("Ingrese CUIT");
        f1.setCuitCliente(teclado.nextLong());
        f1.setTipoPago(tipoPago());

        System.out.println("Cantidad de articulos a facturar");
        int cant = mayorACero();
        f1.iniciarArreglo(cant);
        int contador=0;
        while (contador==cant) {            
            contador++;
            System.out.println("Artículos a facturar");
            String[] art = new String[3];
            art = codigo();
            f1.cargarArticulo(cant,art[0], art[1], art[2], cantFac(art), String.valueOf(Double.parseDouble(art[2])*Double.parseDouble(cantFac(art))));
//            f1.setItemsFactura(f1.getItemsFactura());
        }
        double total = 0;
        for (int i = 0; i < f1.getItemsFactura().length; i++) {
            total += Double.parseDouble(f1.getItemsFactura()[i][4]);
        }
        double recargo = 0;
        if (f1.getTipoPago().equals("TC")) {
            recargo = total*0.1;
        } else if(f1.getTipoPago().equals("TD")) {
            recargo = total*0.05;
        }
        double monto_final = total+recargo;
        
        System.out.println("Cliente "+f1.getRazonSocial());
        System.out.println("Fecha "+f1.getFecha());
        System.out.println("Numero "+f1.getNroFactura());
        System.out.println("Tipo de pago "+f1.getTipoPago());
        
        System.out.println(espacios("Código")+espacios("Denominacion")+espacios("Precios")+espacios("Cantidad")+espacios("Subtotal"));
        for (int i = 0; i < f1.getItemsFactura().length; i++) {
            System.out.println(espacios(f1.getItemsFactura()[0][i])+espacios(f1.getItemsFactura()[1][i])+espacios(f1.getItemsFactura()[2][i])+espacios(f1.getItemsFactura()[3][i])+espacios(f1.getItemsFactura()[4][i]));
        }
        System.out.println(espacios("")+espacios("")+espacios("")+espacios("Total items ")+total);
        System.out.println(espacios("")+espacios("")+espacios("")+espacios("Recargo ")+recargo);
        System.out.println(espacios("")+espacios("")+espacios("")+espacios("Total final")+monto_final);
            
        }

    

    private static String tipoPago() {
        System.out.println("Ingrese Tipo pago");
        String pago = new Scanner(System.in).nextLine();
        if (pago.equals("C") || pago.equals("TC") || pago.equals("TD")) {
            System.out.println("Error ingrese las opciones C, TC o TD");
            tipoPago();
        }
        return pago;
    }
    
    private static int mayorACero(){
        int num = new Scanner(System.in).nextInt();
        try {
            if (num>0);
        } catch (Exception e) {
            System.out.println("Error, ingrese un número mayor a cero");
            mayorACero();
        }
        return num;
    }
    
    private static String[] codigo(){
         System.out.println("Ingrese el código del artículo");
         boolean encontrado = false;
         String cod = new Scanner(System.in).nextLine();
         String[] codEnc = new String[3];
         
         for (int i = 0; i < articulos.length; i++) {
                if (cod.equals(articulos[0][i])) {
                    encontrado=true;
                    codEnc[0] = articulos[0][i];
                    codEnc[1] = articulos[1][i];
                    codEnc[2] = articulos[2][i];
                    break;
                }
            }
         if (!encontrado) {
             System.out.println("El código ingresado es incorrecto");
             codigo();
        }
            return codEnc;
    }
    private static String cantFac(String[] array){
        System.out.println("Ingrese la cantidad");
        String cant = new Scanner(System.in).nextLine();
        String numString = "";
        for (int i = 0; i < articulos.length; i++) {
            if(array[0].equals(articulos[0][i])){
                if (articulos[3][i].equals("U")) {
                    System.out.println("Ingrese la cantidad (entero)");
                    int num = new Scanner(System.in).nextInt();
                    numString = String.valueOf(num);
                }else{
                    System.out.println("Ingrese la cantidad (Decimal)");
                    double num1 = new Scanner(System.in).nextDouble();
                    numString = String.valueOf(num1);
                }
            }
        }
        return numString;
    }
    
    private static String espacios(String s){
        int espacios = 20;
        if (s.length()<espacios) {
            for (int i = 0; i < (espacios-s.length()); i++) {
                s += " ";
            }
        }
        return s;
    }

}
