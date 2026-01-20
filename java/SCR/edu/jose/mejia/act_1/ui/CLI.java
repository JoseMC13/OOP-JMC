package edu.jose.mejia.act_1.ui;

import edu.jose.mejia.act_1.process.Coche;

import java.util.Scanner;
import java.text.NumberFormat;
import java.time.LocalDate;

public class CLI {
    public static void start(){
        Coche coche_wifi=new Coche();
        Scanner scanner=new Scanner(System.in);
        Scanner scanner2=new Scanner(System.in);
        Scanner scanner3=new Scanner(System.in);
        Scanner scanner4=new Scanner(System.in);
        Scanner scanner5=new Scanner(System.in);
        Scanner scanner6=new Scanner(System.in);

        //System.out.println("Bienvenido a nuestra concesionaria Honda");
        System.out.println("Tenemos tres segmentos de productos:");

        System.out.println();
        System.out.println("1. SUV");
        System.out.println("2. Automovil");
        System.out.println("3. Familiar");

        System.out.println();
        System.out.println("Selecciona un segmento para mostrarte nuestros productos: ");
        int segmento=scanner.nextInt();

        System.out.println("Has seleccionado nuestro segmento: " + coche_wifi.getTipo(segmento));
        System.out.println();

        if (segmento==1){
            System.out.println("Estos son los modelos de SUV que poseemos, escoja uno para ver sus caracteristicas:");
            System.out.println();
            System.out.println("a. CR-V");
            System.out.println("b. HR-V");
            System.out.println("c. BR-V");
            System.out.println();
        } else if (segmento==2) {
            System.out.println("Estos son los modelos de Automovil que poseemos, escoja uno para ver sus caracteristicas:");
            System.out.println();
            System.out.println("a. Accord");
            System.out.println("b. Civic");
            System.out.println("c. City");
            System.out.println();
        } else if (segmento==3) {
            System.out.println("Estos son los modelos de Familiar que poseemos, escoja uno para ver sus caracteristicas:");
            System.out.println();
            System.out.println("a. Pilot");
            System.out.println("b. Odissey");
            System.out.println();
        }

        String Producto=scanner2.next();
        String ProdSel = coche_wifi.getProducto(Producto);

        System.out.println("Has escogido un " + ProdSel);

        System.out.println("Este auto tiene las siguientes caracteristicas:");

        Double precio = coche_wifi.getPrecio(Producto);
        String hp =coche_wifi.getHp(Producto);
        String color=coche_wifi.getColor(Producto);

        NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(); // Usa la configuración regional del sistema
        String montoFormateado = formatoMoneda.format(precio);

        System.out.println("Precio: " + montoFormateado);
        System.out.println("Hp: " + hp);
        System.out.println("Este auto puede venir en uno de estos colores: " + color);
        System.out.println();
        System.out.println("Decida que color desea");

        String Colour=scanner3.next();
        System.out.println("Su auto sera " + Colour);

        System.out.println("¿Le gustaria comprar el vehiculo?:");
        System.out.println("Y. Si");
        System.out.println("N. No");

        String Vehiculo=scanner4.next();

        System.out.println(coche_wifi.getVehiculo(Vehiculo));

        System.out.println("1. Comprar otro vehiculo.");
        System.out.println("2. Generar factura y salir.");

        String OtroVehiculo=scanner4.next();

        if(Integer.parseInt(OtroVehiculo)==1){
            System.out.println();
            System.out.println("Te presentamos de nuevo nuestras opciones.");
            CLI.start();
        }
        else{

            System.out.println();
            System.out.println("Escriba su Nombre completo para generar su factura");
            String Nombre=scanner5.next();
            System.out.println("Escriba su metodo de pago: Tarjeta de credito, enganche, cheque");
            String Pago=scanner6.next();
            System.out.println("Nombre: " + Nombre);
            System.out.println("Metodo de pago: " + Pago);
            System.out.println("Fecha: " + LocalDate.now().toString() );
            System.out.println("Coche:" + ProdSel);
            System.out.println("Precio: " + montoFormateado);
            System.out.println("Hp: " + hp);
            System.out.println("Color: " + Colour);
        }

        System.out.println("Desea comprar un vehiculo más:");
        System.out.println("1. Si");
        System.out.println("2. No");

        String OtroVehiculo2=scanner4.next();

        if(Integer.parseInt(OtroVehiculo2)==1){
            System.out.println();
            System.out.println("Te presentamos de nuevo nuestras opciones.");
            CLI.start();
        }
        else{
            System.out.println("Hasta la proxima!");
        }
    }
}