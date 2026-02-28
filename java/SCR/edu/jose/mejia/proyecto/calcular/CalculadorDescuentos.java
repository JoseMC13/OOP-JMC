package edu.jose.mejia.proyecto.calcular;

import edu.jose.mejia.proyecto.data.Usuario;

/**
 * La clase CalculadorDescuentos se encarga de determinar
 * el porcentaje de descuento que se le aplica a un usuario
 * dependiendo de su tipo.
 * Tipos de descuento:
 * Estudiante: 10%
 * Maestro: 15%
 * Otro tipo: 0%
 */
public class CalculadorDescuentos {
    /**
     * Calcula el porcentaje de descuento según el tipo de usuario.
     * @param u Usuario al que se le calculará el descuento.
     * @return El porcentaje de descuento:
     * 0.10 si es Estudiante,
     * 0.15 si es Maestro,
     * 0.0 para otros casos.
     */
    public double calcularDescuento(Usuario u) {

        if (u instanceof Usuario.Estudiante) {
            return 0.10;
        } else if (u instanceof Usuario.Maestro) {
            return 0.15;
        }
        return 0.0;
    }
}