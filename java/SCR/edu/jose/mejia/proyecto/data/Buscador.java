package edu.jose.mejia.proyecto.data;

import java.util.List;

/**
 * La clase Buscador permite buscar libros dentro de una lista
 * utilizando como criterio el título o el autor.
 * La búsqueda no distingue entre mayúsculas y minúsculas.
 * Si no encuentra coincidencias, retorna null.
 */
public class Buscador {
    /**
     * Busca un libro por su título.
     *
     * @param titulo Título del libro a buscar.
     * @param libros Lista de libros donde se realizará la búsqueda.
     * @return El libro encontrado o null si no existe.
     */
    public Libro buscarLibroPorTitulo(String titulo, List<Libro> libros) {
        for (Libro l : libros) {
            if (l.getTitulo().equalsIgnoreCase(titulo)) {
                return l;
            }
        }
        return null;
    }

    /**
     * Busca un libro por su autor.
     *
     * @param autor Autor del libro a buscar.
     * @param libros Lista de libros donde se realizará la búsqueda.
     * @return El libro encontrado o null si no existe.
     */
    public Libro buscarLibroPorAutor(String autor, List<Libro> libros) {
        for (Libro l : libros) {
            if (l.getAutor().equalsIgnoreCase(autor)) {
                return l;
            }
        }
        return null;
    }
}