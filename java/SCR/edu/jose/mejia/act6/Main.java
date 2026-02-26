package edu.jose.mejia.act6;

import edu.jose.mejia.act6.process.ClaseHija;
import edu.jose.mejia.act6.process.ClasePadre;
import edu.jose.mejia.act6.process.OperacionesMatematicas;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // ====== FACTORIAL ======
        System.out.print("Ingresa un numero para calcular el factorial: ");
        int numeroFactorial = scanner.nextInt();

        long resultadoFactorial = OperacionesMatematicas.factorial(numeroFactorial);
        System.out.println("El factorial es: " + resultadoFactorial);

        // ====== FIBONACCI ======
        System.out.print("Ingresa un numero para calcular Fibonacci: ");
        int numeroFibonacci = scanner.nextInt();

        int resultadoFibonacci = OperacionesMatematicas.fibonacci(numeroFibonacci);
        System.out.println("El Fibonacci es: " + resultadoFibonacci);

        // ====== HIDING ======
        System.out.println("\n--- Ejemplo de Hiding ---");
        System.out.println(ClasePadre.mensaje);
        System.out.println(ClaseHija.mensaje);

        ClasePadre.mostrarMensaje();
        ClaseHija.mostrarMensaje();

        // ====== SHADOWING ======
        System.out.println("\n--- Ejemplo de Shadowing ---");
        ClaseHija hija = new ClaseHija();
        hija.ejemploShadowing();
    }
}