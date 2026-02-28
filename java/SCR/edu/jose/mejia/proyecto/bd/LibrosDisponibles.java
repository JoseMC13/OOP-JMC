package edu.jose.mejia.proyecto.bd;

import edu.jose.mejia.proyecto.data.Libro;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que actúa como repositorio en memoria para la gestión de libros.
 * Al inicializarse, el repositorio se carga automáticamente con una
 * colección de libros predefinidos.
 */
public class LibrosDisponibles {
    /**
     * Lista que almacena los libros del repositorio.
     */
    private List<Libro> libros;
    /**
     * Constructor del repositorio.
     * Inicializa la lista de libros y carga un conjunto de libros iniciales.
     */
    public LibrosDisponibles() {
        libros = new ArrayList<>();
        cargarLibrosIniciales();
    }

    /**
     * Carga una colección inicial de libros en el repositorio.
     * Este metodo es privado ya que solo debe ejecutarse durante
     * la inicialización del repositorio.
     */
    private void cargarLibrosIniciales() {
        libros.add(new Libro("Primer Java", "Kathy Sierra", 300, 5));
        libros.add(new Libro(" Comenzando a programar con Java para Dummies", "Barry Burd", 450, 3));
        libros.add(new Libro("Java: conceptos básicos de programación para principiantes", "Nathan Clark", 600, 4));
        libros.add(new Libro("Java: una guía para principiantes", "Herbert Schildt", 200, 10));
        libros.add(new Libro("Core Java Volumen I", "Cay S. Horstman", 200, 3));
        libros.add(new Libro("Think Java: Cómo pensar como un científico informático", "Allen B. Downey", 550, 8));
        libros.add(new Libro("Java efectivo", "Joshua Bloch", 250, 7));
        libros.add(new Libro("Java: la referencia completa", "Herbert Schildt", 700, 13));
        libros.add(new Libro("Java 8 en acción", "Alan Mycroft", 400, 5));
        libros.add(new Libro("Pensando en Java", "Bruce Eckel", 300, 4));
        libros.add(new Libro("Aprender Java mediante la creación de juegos para Android", "Jonh Horton", 800, 4));
        libros.add(new Libro("Java en pocas palabras", "Ben Evans", 200, 2));
        libros.add(new Libro("Core Java para los impacientes", "Cay S. Horstmann", 450, 11));
        libros.add(new Libro("Java: una introducción a la programación del mundo real", "Marc Loy", 250, 8));
        libros.add(new Libro("Asimilando la entrevista de Java", "Javin Paul", 500, 6));
        libros.add(new Libro("El sistema de módulos de Java", "Nikolai Parlog", 300, 14));
        libros.add(new Libro("Java moderno en acción", "Mario Fusco", 400, 7));
        libros.add(new Libro("Problemas clásicos de informática en Java", "David Kopec", 500, 4));
        libros.add(new Libro("Aprende a hacer código", "Eric Freeman", 400, 5));
        libros.add(new Libro("Manual de artesanía de software ágil", "Robert C. Martin", 200, 7));
        libros.add(new Libro("El lenguaje oculto del hardware y el software informático", "Charles Petzold", 700, 10));
        libros.add(new Libro("Entrevista de Cracking the Coding", "Gayle Laakmann McDowell", 350, 4));
        libros.add(new Libro("Algoritmos de Grokking: una guía ilustrada para programadores", "Aditya Y. Bhargava", 600, 2));
        libros.add(new Libro("Introducción a los algoritmos", "Thomas H. Cormen", 450, 7));
        libros.add(new Libro("Piense en estructuras de datos", "Allen B. Downey", 550, 17));

    }

    /**
     * Devuelve la lista de libros almacenados en el repositorio.
     * @return lista de libros
     */
    public List<Libro> getLibros() {
        return libros;
    }

    /**
     * Agrega un nuevo libro al repositorio.
     * @param libro libro a agregar
     */
    public void agregarLibro(Libro libro) {
        libros.add(libro);
    }
}