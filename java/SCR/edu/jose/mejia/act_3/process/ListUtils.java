package edu.jose.mejia.act_3.process;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static List<Integer> moverCerosDerecha(List<Integer> lista) {
        List<Integer> resultado = new ArrayList<>();
        int ceros = 0;

        for (int n : lista) {
            if (n == 0) ceros++;
            else resultado.add(n);
        }

        for (int i = 0; i < ceros; i++) {
            resultado.add(0);
        }

        return resultado;
    }

    public static int contarPares(List<Integer> lista) {
        int contador = 0;

        for (int n : lista) {
            if (n % 2 == 0) contador++;
        }
        return contador;
    }
}
