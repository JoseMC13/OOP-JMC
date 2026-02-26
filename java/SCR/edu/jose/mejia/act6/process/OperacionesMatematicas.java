package edu.jose.mejia.act6.process;

public class OperacionesMatematicas {
    // Método para calcular factorial
    public static long factorial(int n) {
        long resultado = 1;

        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }

        return resultado;
    }

    // Método para calcular Fibonacci
    public static int fibonacci(int n) {

        if (n == 0) return 0;
        if (n == 1) return 1;

        int a = 0;
        int b = 1;
        int resultado = 0;

        for (int i = 2; i <= n; i++) {
            resultado = a + b;
            a = b;
            b = resultado;
        }

        return resultado;
    }
}
