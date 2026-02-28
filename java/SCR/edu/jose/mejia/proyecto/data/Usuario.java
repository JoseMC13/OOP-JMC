package edu.jose.mejia.proyecto.data;

/**
 * Representa un usuario del sistema de tienda.
 * Un usuario puede ser de distintos tipos: Estudiante, Maestro o ClienteComun.
 */
public class Usuario {
    /** Nombre del usuario */
    protected String nombre;
    /**
     * Constructor de la clase Usuario.
     * @param nombre Nombre del usuario
     */
    public Usuario(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Obtiene el nombre del usuario.
     * @return nombre del usuario
     */
    public String getNombre() { return nombre; }

    /**
     * Representa un usuario tipo Estudiante.
     */
    public static class Estudiante extends Usuario {
        /**
         * Constructor de Estudiante.
         * @param nombre Nombre del estudiante
         */
        public Estudiante(String nombre) {
            super(nombre);
        }
    }

    /**
     * Representa un usuario tipo Maestro.
     */
    public static class Maestro extends Usuario {
        /**
         * Constructor de Maestro.
         * @param nombre Nombre del maestro
         */
        public Maestro(String nombre) {
            super(nombre);
        }
    }

    /**
     * Representa un usuario tipo ClienteComun.
     */
    public static class Cliente extends Usuario {
        /**
         * Constructor de ClienteComun.
         * @param nombre Nombre del cliente
         */
        public Cliente(String nombre) {
            super(nombre);
        }
    }
}