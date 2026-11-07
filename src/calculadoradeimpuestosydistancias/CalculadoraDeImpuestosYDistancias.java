/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package calculadoradeimpuestosydistancias;

import java.util.Scanner;

/**
 *
 * @author munsi_gm6lqlf
 */
public class CalculadoraDeImpuestosYDistancias {
    static Scanner sc = new Scanner (System.in);
    public static void main(String[] args) {
        menu();
    }
    public static void menu(){
        int opcion, repetir;
        do{
                System.out.println("-------- CID (Calculadora de Impuestos y Distancias) ---------");
                System.out.println("Bienvenid@, por favor ingrese una de las siguientes opciones:");
                System.out.println("1.Calcular impuesto\n2.Calcular distancia");
                opcion = validarOpcion(1,2);
                switch(opcion){
                    case 1:
                        calcularImpuesto();
                        break;
                    case 2:
                        calcularDistancia();
                        break;
                }
                System.out.println("------------------------- ¿Repetir? --------------------------");
                System.out.println("1.Sí\n2.No");
                repetir = validarOpcion(1,2);
        }while(repetir==1); 
    }
    
    public static void calcularImpuesto(){
        String nombre;
        double costo_inicial, porcentaje_descuento;
        int acreditado, equipo;
        System.out.println("--------------------- Calcular Impuesto -----------------------");
        System.out.println("Ingrese el nombre de su producto: ");
        nombre = sc.next();
        System.out.println("Ingrese el precio de su "+nombre+":");
        costo_inicial = validarRangoDouble(100,16777216);
        System.out.println("Para calcular su descuento, responda las siguientes preguntas:");
        System.out.println("¿Eres un alumno acreditado?\n1.Si \n0.No");
        acreditado = validarOpcion(0,1);
        System.out.println("¿El equipo está dentro del catálogo educativo?\n1.Si \n0.No");
        equipo = validarOpcion(0,1);
        if(acreditado==1 && equipo==1){
            porcentaje_descuento = 0.16;
        }
        else if(acreditado==0 && equipo==0){
            porcentaje_descuento = 0;
        }
        else{
            porcentaje_descuento = 0.08;
        }
        calcularDescuento(nombre, costo_inicial, porcentaje_descuento);
    }
    
    public static void calcularDistancia(){
        float x1, x2, y1, y2, incrementox, incrementoy;
        double distancia;
        
        System.out.println("--------------------- Calcular Distancia ----------------------");
        System.out.println("Ingrese el valor de x1:");
        x1 = validarRangoFloat(-100,100);
        System.out.println("Ingrese el valor de y1");
        y1 = validarRangoFloat(-100,100);
        do{
            System.out.println("Ingrese el valor de x2:");
            x2 = validarRangoFloat(-100,100);
            System.out.println("Ingrese el valor de y2");
            y2 = validarRangoFloat(-100,100);
            if(x1==x2 && y1==y2){
                System.out.println("=========================== ¡Error! ==========================");
                System.out.println("Por favor ingrese coordenadas diferentes a las iniciales");
            }
        }while(x1==x2 && y1==y2);
        incrementox = x2 - x1;
        incrementoy = y2 - y1;
        distancia = Math.sqrt(incrementox * incrementox + incrementoy * incrementoy);
        System.out.println("------------------- Resultados del cálculo -------------------");
        System.out.printf("Punto 1: "+x1+","+y1);
        System.out.printf("\nPunto 2: "+x2+","+y2);
        System.out.printf("\nIncremento en x: %.2f%n"+incrementox);
        System.out.printf("\nIncremento en y: %.2f%n"+incrementoy);
        System.out.printf("\nDistancia entre los dos puntos: %.2f%n"+distancia);
        System.out.println("\n--------------------------------------------------------------");
    }
    
    
public static void calcularDescuento(String nombre, double costo_inicial, double porcentaje_descuento) {
    double descuento, subtotal;
    descuento = costo_inicial * porcentaje_descuento;
    subtotal = costo_inicial - descuento;
    if (porcentaje_descuento > 0) {
        System.out.printf("¡Felicidades!, has obtenido un descuento del %.0f%%%n", porcentaje_descuento * 100);
    } else {
        System.out.println("Lo sentimos, su compra no es válida para descuento");
    }
    System.out.println("---------------------- Ticket de compra ----------------------");
    System.out.printf("Costo inicial de %s: $%.2f%n", nombre, costo_inicial);
    System.out.printf("Descuento aplicado: $%.2f%n", descuento);
    System.out.printf("Total a pagar: $%.2f%n", subtotal);
    System.out.println("------------------ ¡Gracias por su compra! -------------------");
}

    
    public static int validarEntero() {
        while (!sc.hasNextInt()) {
            System.out.println("=========================== ¡Error! ==========================");
            System.out.println("Por favor ingrese un valor válido");
            sc.next();
         }
         return sc.nextInt();
   }
    
    public static int validarOpcion(int minimo, int maximo) {
        int opcion;
        do {
            opcion = validarEntero();
            if (opcion < minimo || opcion > maximo) {
                System.out.println("=========================== ¡Error! ==========================");
                System.out.println("Por favor ingrese una opción válida");
            }
        } while (opcion < minimo || opcion > maximo);
        return opcion;
    } 
    
    public static double validarDouble() {
    while (!sc.hasNextFloat()) {
        System.out.println("=========================== ¡Error! ==========================");
        System.out.println("Por favor ingrese un valor válido");
        sc.next();
    }
    return sc.nextFloat();
    }
    
    public static double validarRangoDouble(double minimo, double maximo) {
    double numero;
    do {
        numero = validarDouble();
        if (numero < minimo || numero > maximo) {
            System.out.println("=========================== ¡Error! ==========================");
            System.out.println("Por favor ingrese un número entre " + minimo + " y " + maximo);
        }
    } while (numero < minimo || numero > maximo);
    return numero;
    }
    
    public static float validarRangoFloat(float minimo, float maximo) {
    float numero;
    do {
        numero = validarFloat();
        if (numero < minimo || numero > maximo) {
            System.out.println("=========================== ¡Error! ==========================");
            System.out.println("Por favor ingrese un número entre " + minimo + " y " + maximo);
        }
    } while (numero < minimo || numero > maximo);
    return numero;
    }
    
    public static float validarFloat() {
        while (!sc.hasNextFloat()) {
            System.out.println("=========================== ¡Error! ==========================");
            System.out.println("Por favor ingrese un valor válido");
            sc.next();
         }
         return sc.nextFloat();
   }
}
