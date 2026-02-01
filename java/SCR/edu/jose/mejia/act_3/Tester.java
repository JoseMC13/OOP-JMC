package edu.jose.mejia.act_3;

import edu.jose.mejia.act_3.process.*;
import edu.jose.mejia.act_3.process.Empleado;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class Tester {

    @Test
    void testMoverCerosDerecha() {
        List<Integer> entrada = Arrays.asList(0, 2, 1, 4, 0, 2);
        List<Integer> esperado = Arrays.asList(2, 1, 4, 2, 0, 0);

        assertEquals(esperado, ListUtils.moverCerosDerecha(entrada));
    }

    @Test
    void testContarNumerosPares() {
        List<Integer> entrada = Arrays.asList(3, 4, 5, 7, 6);
        assertEquals(2, ListUtils.contarPares(entrada));
    }

    @Test
    void testPalindromoTrue() {
        assertTrue(StringUtils.esPalindromo("ana"));
    }

    @Test
    void testPalindromoFalse() {
        assertFalse(StringUtils.esPalindromo("hola mundo"));
    }

    @Test
    void testContarVocales() {
        assertEquals(2, StringUtils.contarVocales("hola"));
    }

    @Test
    void testInvertirCadena() {
        assertEquals("aloh", StringUtils.invertir("hola"));
    }

    @Test
    void testPrimeraPosicionCaracterEncontrado() {
        assertEquals(1, StringUtils.primeraPosicion("hola", 'o'));
    }

    @Test
    void testPrimeraPosicionCaracterNoEncontrado() {
        assertEquals(-1, StringUtils.primeraPosicion("hola", 'r'));
    }

    private List<Empleado> empleados() {
        return Arrays.asList(
                new Empleado("Ana", 23, 20000, "sistemas"),
                new Empleado("Luis", 35, 30000, "ventas"),
                new Empleado("Carlos", 40, 50000, "sistemas"),
                new Empleado("Maria", 35, 25000, "rh"),
                new Empleado("Elena", 23, 18000, "sistemas")
        );
    }

    @Test
    void testMayorSalario() {
        Empleado e = EmpleadoUtils.mayorSalario(empleados());
        assertEquals("Carlos", e.getNombre());
    }

    @Test
    void testEdadMasComun() {
        assertEquals(23, EmpleadoUtils.edadMasComun(empleados()));
    }

    @Test
    void testPromedioEdad() {
        assertEquals(31.2, EmpleadoUtils.promedioEdad(empleados()));
    }

    @Test
    void testPromedioSalario() {
        assertEquals(28600, EmpleadoUtils.promedioSalario(empleados()));
    }

    @Test
    void testPromedioEdadMayores25k() {
        assertEquals(37.5, EmpleadoUtils.promedioEdadSalarioMayor25k(empleados()));
    }

    @Test
    void testFiltrarMenores25() {
        List<Empleado> resultado = EmpleadoUtils.filtrarMenores25(empleados());
        assertEquals(2, resultado.size());
    }

    @Test
    void testContarDepartamentoSistemas() {
        assertEquals(3, EmpleadoUtils.contarDepartamentoSistemas(empleados()));
    }

    @Test
    void testMayorSalarioMayor30() {
        Empleado e = EmpleadoUtils.mayorSalarioMayor30(empleados());
        assertEquals("Carlos", e.getNombre());
    }

    @Test
    void testMenorSalarioEdadMenosComun() {
        Empleado e = EmpleadoUtils.menorSalarioEdadMenosComun(empleados());
        assertEquals("Ana", e.getNombre());
    }
}