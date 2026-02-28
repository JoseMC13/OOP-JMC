package edu.jose.mejia.proyecto.core;

import edu.jose.mejia.proyecto.data.Libro;
import java.util.ArrayList;
import java.util.List;

/**
 * Representa el carrito de compras de un usuario.
 * Permite agregar, quitar y listar libros seleccionados,
 * así como calcular el subtotal de la compra.
 * Cuando se agrega un libro al carrito:
 * Se verifica que haya stock disponible.</li>
 * Si hay stock, el libro se añade al carrito.</li>
 * El stock del libro se reduce en 1.
 * Si el carrito está vacío, el subtotal será 0.
 */
public class CarritoDeCompras {
    private List<Libro> libros;
    /**
     * Constructor que inicializa el carrito vacío.
     */
    public CarritoDeCompras() {
        libros = new ArrayList<>();
    }
    /**
     * Agrega un libro al carrito si hay stock disponible.
     * Reduce el stock del libro en 1 unidad.
     * @param libro Libro que se desea agregar.
     */
    public void agregarLibro(Libro libro) {

        if (libro.hayStock()) {
            libros.add(libro);
            libro.reducirStock();
            System.out.println("Libro agregado al carrito: " + libro.getTitulo());
        } else {
            System.out.println("No hay stock disponible para: " + libro.getTitulo());
        }
    }
    /**
     * Elimina un libro del carrito.
     * @param libro Libro que se desea eliminar.
     */
    public void quitarLibro(Libro libro) {
        if (libros.remove(libro)) {
            libro.incrementarStock();
        }
    }
    /**
     * Devuelve la lista de libros actualmente en el carrito.
     * @return Lista de libros.
     */
    public List<Libro> getLibros() {
        return libros;
    }
    /**
     * Calcula el subtotal sumando el precio de todos
     * los libros en el carrito.
     * @return Subtotal de la compra.
     */
    public double calcularSubtotal() {
        double subtotal = 0;
        for (Libro l : libros) {
            subtotal += l.getPrecio();
        }
        return subtotal;
    }
    /**
     * Muestra en consola los libros del carrito
     * junto con su subtotal.
     */
    public void mostrarCarrito() {
        System.out.println("----- CARRITO -----");

        if (libros.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }

        for (Libro l : libros) {
            System.out.println(l.getTitulo() + " - $" + l.getPrecio());
        }
        System.out.println("Subtotal: $" + calcularSubtotal());
    }
    /**
     * Vacía completamente el carrito eliminando todos los libros.
     */
    public void vaciarCarrito() {
        libros.clear();
        System.out.println("El carrito ha sido vaciado.");
    }
}