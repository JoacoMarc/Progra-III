package clase_4.actividad_4;

import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static int calcularCostoMinimo(int[] precios, int amigos) {
        // Convertir el arreglo de primitivos a Integer para poder ordenar en orden descendente
        Integer[] preciosOrdenados = Arrays.stream(precios).boxed().toArray(Integer[]::new);
        
        // Ordenar los precios de mayor a menor
        Arrays.sort(preciosOrdenados, Collections.reverseOrder());
        
        int costoTotal = 0;
        
        // Calcular el costo total usando el multiplicador
        for (int i = 0; i < preciosOrdenados.length; i++) {
            int multiplicador = (i / amigos) + 1;
            costoTotal += multiplicador * preciosOrdenados[i];
        }
        
        return costoTotal;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        int[] preciosFlores = {1, 2, 3, 4};
        int numeroAmigos = 4;
        
        int costoMinimo = calcularCostoMinimo(preciosFlores, numeroAmigos);
        System.out.println("El costo total mínimo es: " + costoMinimo);
        
    }
}

