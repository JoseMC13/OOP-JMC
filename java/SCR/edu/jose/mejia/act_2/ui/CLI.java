package edu.jose.mejia.act_2.ui;
import edu.jose.mejia.act_2.process.Calculo;
import org.w3c.dom.ls.LSOutput;

import java.lang.classfile.instruction.SwitchCase;
import java.util.Scanner;

public class CLI {
    public static void start() {
        Calculo calc = new Calculo();
        Scanner scanner = new Scanner(System.in);
        Scanner scanner2 = new Scanner(System.in);
        Scanner scanner3 = new Scanner(System.in);
        Scanner scanner4 = new Scanner(System.in);
        Scanner scanner5 = new Scanner(System.in);
        Scanner scanner6 = new Scanner(System.in);

        System.out.println("Selecciona una operacion a hacer:");

        System.out.println();
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicacion");
        System.out.println("4. Division");
        System.out.println("5. Modulo");
        System.out.println("6. Potencia");
        System.out.println("7. Raiz");
        System.out.println("8. Logaritmo");

        System.out.println();
        int opera = scanner.nextInt();
        String sOpera = calc.getopera(opera);

        System.out.println("Has seleccionado la operacion de " + sOpera);

        System.out.println("Ingresa el primer operando: ");
        System.out.println();
        int op1 = scanner2.nextInt();
        System.out.println("Ingresa el segundo operando: ");
        System.out.println();
        int op2 = scanner3.nextInt();

        if (opera == 1) {
            System.out.println("El resultado de la suma de " + op1 + " mas " + op2 + " es igual a " + calc.suma(op1, op2));
        } else if (opera == 2) {
            System.out.println("El resultado de la resta de " + op1 + " menos " + op2 + " es igual a " + calc.resta(op1, op2));
        } else if (opera == 3) {
            System.out.println("El resultado de la multiplicacion de " + op1 + " por " + op2 + " es igual a " + calc.multi(op1, op2));
        } else if (opera == 4) {
            System.out.println("El resultado de la divsion de " + op1 + " entre " + op2 + " es igual a " + calc.divi(op1, op2));
        } else if (opera == 5) {
            System.out.println("El resultado del modulo de " + op1 + " entre " + op2 + " es igual a " + calc.modulo(op1, op2));
        } else if (opera == 6) {
            System.out.println("El resultado de " + op1 + " elevado a la " + op2 + " es igual a " + calc.potencia(op1, op2));
        } else if (opera == 7) {
            System.out.println("El resultado de la raiz de " + op1 + " elevado al cuadrodo es igual a " + calc.raiz(op1));
        } else if (opera == 8) {
            System.out.println("El logaritmo natural de " + op1 + " es igual a " + calc.logar(op1));
    }
    }
}