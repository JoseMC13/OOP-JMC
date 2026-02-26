package edu.jose.mejia.act6.process;

public class ClaseHija extends ClasePadre {
    public static String mensaje = "Mensaje desde ClaseHija";

    public static void mostrarMensaje() {
        System.out.println("Metodo estatico en ClaseHija");
    }

    public void ejemploShadowing() {
        int numero = 10;
        System.out.println("Variable local numero: " + numero);
    }
}