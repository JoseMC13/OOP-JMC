package edu.jose.mejia.act_3.process;

import java.util.*;

public class Acomodador {

    public static Empleado mayorSalario(List<Empleado> lista) {
        Empleado max = null;

        for (Empleado e : lista) {
            if (max == null || e.getSalario() > max.getSalario()) {
                max = e;
            }
        }
        return max;
    }

    public static double promedioEdad(List<Empleado> lista) {
        double suma = 0;

        for (Empleado e : lista) {
            suma += e.getEdad();
        }

        return lista.isEmpty() ? 0 : suma / lista.size();
    }

    public static int edadMasComun(List<Empleado> lista) {
        Map<Integer, Integer> conteo = new HashMap<>();

        for (Empleado e : lista) {
            conteo.put(e.getEdad(),
                    conteo.getOrDefault(e.getEdad(), 0) + 1);
        }

        int edad = 0, max = 0;

        for (var entry : conteo.entrySet()) {
            if (entry.getValue() > max) {
                max = entry.getValue();
                edad = entry.getKey();
            }
        }
        return edad;
    }
}
