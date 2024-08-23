package src;

import static src.BusquedaBinariaAct.busquedaBinaria;

public class Main {
    public static void main(String[] args) {
        int[] arreglo = {10, 18, 23, 34, 35, 42, 56};
        int objetivo = 34;
        int resultado = busquedaBinaria(arreglo, objetivo);

        if (resultado == -1) {
            System.out.println("Elemento " + objetivo + " no encontrado en el arreglo.");
        } else {
            System.out.println("Elemento " + objetivo + " encontrado en el índice: " + resultado);
        }

        int objetivo2 = 90;
        int resultado2 = busquedaBinaria(arreglo, objetivo2);

        if (resultado2 == -1) {
            System.out.println("Elemento " + objetivo2 + " no encontrado en el arreglo.");
        } else {
            System.out.println("Elemento encontrado en el índice: " + resultado2);
        }
    }
}
