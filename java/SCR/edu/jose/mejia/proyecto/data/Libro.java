package edu.jose.mejia.proyecto.data;

import edu.jose.mejia.proyecto.idioma.Idioma;

/**
 * Representa un libro dentro del sistema de la tienda.
 * Contiene información básica como título, autor,
 * precio y cantidad disponible en stock.
 * Permite consultar si hay stock disponible y reducir
 * la cantidad cuando se realiza una compra.
 */
public class Libro {
    private String titulo;
    private String autor;
    private double precio;
    private int stock;
    private String imagen;
    private String sinopsis;

    /**
     * Constructor que crea un libro con sus datos básicos.
     * @param titulo Título del libro.
     * @param autor Autor del libro.
     * @param precio Precio del libro.
     * @param stock Cantidad disponible en inventario.
     */
    public Libro(String titulo, String autor, double precio, int stock) {
        this.titulo = titulo;
        this.autor = autor;
        this.precio = precio;
        this.stock = stock;
    }
    /**
     * Obtiene el título del libro.
     * @return Título del libro.
     */
    public String getTitulo() { return titulo; }
    /**
     * Obtiene el autor del libro.
     * @return Autor del libro.
     */
    public String getAutor() { return autor; }
    /**
     * Obtiene el precio del libro.
     * @return Precio del libro.
     */
    public double getPrecio() { return precio; }
    /**
     * Obtiene la cantidad disponible en stock.
     * @return Cantidad en inventario.
     */
    public int getStock() { return stock; }
    /**
     * Indica si el libro tiene stock disponible.
     * @return true si el stock es mayor a 0, false en caso contrario.
     */
    public boolean hayStock() {
        return stock > 0;
    }
    /**
     * Reduce el stock en una unidad si hay disponibilidad.
     */
    public void reducirStock() {
        if (stock > 0) {
            stock--;
        }
    }
    public void incrementarStock() {
        stock++;
    }
    public String mostrar(Idioma idioma) {
        return titulo + " | " +
                idioma.autor() + ": " + autor +
                " | $" + precio +
                " | " +
                idioma.stock() + ": " + stock;
    }
}