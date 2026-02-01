package edu.jose.mejia.act_3.process;

public class StringUtils {
    public static boolean esPalindromo(String texto) {
        String limpio = texto.replace(" ", "").toLowerCase();
        int i = 0, j = limpio.length() - 1;

        while (i < j) {
            if (limpio.charAt(i) != limpio.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }

    public static int contarVocales(String texto) {
        int contador = 0;
        for (char c : texto.toLowerCase().toCharArray()) {
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                contador++;
            }
        }
        return contador;
    }

    public static String invertir(String texto) {
        String resultado = "";
        for (int i = texto.length() - 1; i >= 0; i--) {
            resultado += texto.charAt(i);
        }
        return resultado;
    }

    public static int primeraPosicion(String texto, char c) {
        for (int i = 0; i < texto.length(); i++) {
            if (texto.charAt(i) == c) return i;
        }
        return -1;
    }
}
