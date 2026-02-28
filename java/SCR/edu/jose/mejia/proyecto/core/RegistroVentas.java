package edu.jose.mejia.proyecto.core;

import edu.jose.mejia.proyecto.data.Libro;
import java.util.ArrayList;
import java.util.List;

/**
 * La clase RegistroVentas se encarga de almacenar
 * los libros que han sido vendidos.
 * Permite registrar una venta y consultar la lista
 * de libros vendidos.
 * Esta clase funciona como un historial simple de ventas.
 */
public class RegistroVentas {
    private List<Libro> vendidos = new ArrayList<>();
    /**
     * Registra un libro como vendido.
     * @param libro Libro que ha sido vendido.
     */
    public void registrarVenta(Libro libro) {
        vendidos.add(libro);
    }
    /**
     * Devuelve la lista de libros vendidos.
     * @return Lista de libros vendidos.
     */
    public List<Libro> getVendidos() {
        return vendidos;
    }
}