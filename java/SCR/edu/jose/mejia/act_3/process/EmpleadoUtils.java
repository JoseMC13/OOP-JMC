package edu.jose.mejia.act_3.process;

import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;

public class EmpleadoUtils {

    public static Empleado mayorSalario(List<Empleado> empleados) {
        Empleado max = null;
        for (Empleado e : empleados) {
            if (max == null || e.getSalario() > max.getSalario()) {
                max = e;
            }
        }
        return max;
    }

    public static int edadMasComun(List<Empleado> empleados) {
        Map<Integer, Integer> conteo = new HashMap<>();
        for (Empleado e : empleados) {
            conteo.put(e.getEdad(), conteo.getOrDefault(e.getEdad(), 0) + 1);
        }

        int edad = 0, max = 0;
        for (var entry : conteo.entrySet()) {
            if (entry.getValue() > max ||
                    (entry.getValue() == max && entry.getKey() < edad)) {
                max = entry.getValue();
                edad = entry.getKey();
            }
        }
        return edad;
    }

    public static double promedioEdad(List<Empleado> empleados) {
        double suma = 0;
        for (Empleado e : empleados) {
            suma += e.getEdad();
        }
        return empleados.isEmpty() ? 0 : suma / empleados.size();
    }

    public static double promedioSalario(List<Empleado> empleados) {
        double suma = 0;
        for (Empleado e : empleados) {
            suma += e.getSalario();
        }
        return empleados.isEmpty() ? 0 : suma / empleados.size();
    }

    public static double promedioEdadSalarioMayor25k(List<Empleado> empleados) {
        double suma = 0;
        int count = 0;
        for (Empleado e : empleados) {
            if (e.getSalario() > 25000) {
                suma += e.getEdad();
                count++;
            }
        }
        return count == 0 ? 0 : suma / count;
    }

    public static List<Empleado> filtrarMenores25(List<Empleado> empleados) {
        List<Empleado> resultado = new ArrayList<>();
        for (Empleado e : empleados) {
            if (e.getEdad() < 25) {
                resultado.add(e);
            }
        }
        return resultado;
    }

    public static int contarDepartamentoSistemas(List<Empleado> empleados) {
        int count = 0;
        for (Empleado e : empleados) {
            if (e.getDepartamento().equalsIgnoreCase("sistemas")) {
                count++;
            }
        }
        return count;
    }

    public static Empleado mayorSalarioMayor30(List<Empleado> empleados) {
        Empleado max = null;
        for (Empleado e : empleados) {
            if (e.getEdad() > 30) {
                if (max == null || e.getSalario() > max.getSalario()) {
                    max = e;
                }
            }
        }
        return max;
    }

    public static Empleado menorSalarioEdadMenosComun(List<Empleado> empleados) {

        // Contar edades
        Map<Integer, Integer> conteo = new HashMap<>();
        for (Empleado e : empleados) {
            conteo.put(e.getEdad(), conteo.getOrDefault(e.getEdad(), 0) + 1);
        }

        // Buscar la edad menos común (pero con frecuencia > 1)
        int edadMenosComun = Integer.MAX_VALUE;
        int minFrecuencia = Integer.MAX_VALUE;

        for (var entry : conteo.entrySet()) {
            int edad = entry.getKey();
            int freq = entry.getValue();

            if (freq > 1 && freq < minFrecuencia) {
                minFrecuencia = freq;
                edadMenosComun = edad;
            } else if (freq == minFrecuencia && edad < edadMenosComun) {
                // si empatan en frecuencia, elegir la menor edad
                edadMenosComun = edad;
            }
        }

        // Tomar el PRIMER empleado con esa edad
        for (Empleado e : empleados) {
            if (e.getEdad() == edadMenosComun) {
                return e;
            }
        }

        return null;
    }

}