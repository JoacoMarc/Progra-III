import java.util.Arrays;
import java.util.PriorityQueue;

public class MayoresElementos {

    // Método para encontrar los "n" elementos más grandes en una lista usando Divide y Vencerás
    public int[] encontrarNMayores(int[] lista, int n) {
        // Si la lista tiene menos de n elementos, devolver todos los elementos ordenados
        if (lista.length <= n) {
            Arrays.sort(lista);
            int[] resultado = new int[lista.length];  // Devolver el tamaño real, no n
            for (int i = 0; i < lista.length; i++) {
                resultado[i] = lista[lista.length - 1 - i];  // Ordenar de mayor a menor
            }
            return resultado;
        }

        // Dividir la lista en dos mitades
        int mitad = lista.length / 2;
        int[] mitadIzquierda = Arrays.copyOfRange(lista, 0, mitad);
        int[] mitadDerecha = Arrays.copyOfRange(lista, mitad, lista.length);

        // Resolver recursivamente para cada mitad
        int[] mayoresIzquierda = encontrarNMayores(mitadIzquierda, n);
        int[] mayoresDerecha = encontrarNMayores(mitadDerecha, n);

        // Combinar los resultados y devolver los n mayores
        return combinarListas(mayoresIzquierda, mayoresDerecha, n);
    }

    // Método auxiliar para combinar dos listas y mantener solo los n mayores elementos
    private int[] combinarListas(int[] lista1, int[] lista2, int n) {
        // Usar un PriorityQueue (min heap) para mantener los n elementos más grandes
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        // Agregar los elementos de ambas listas al heap
        for (int num : lista1) {
            heap.offer(num);
            if (heap.size() > n) {
                heap.poll();  // Remover el elemento más pequeño si el heap tiene más de n elementos
            }
        }
        for (int num : lista2) {
            heap.offer(num);
            if (heap.size() > n) {
                heap.poll();  // Remover el elemento más pequeño si el heap tiene más de n elementos
            }
        }

        // Convertir el heap en un array y devolverlo
        int[] resultado = new int[heap.size()];  // Cambiado para evitar problemas de tamaño
        for (int i = resultado.length - 1; i >= 0; i--) {
            resultado[i] = heap.poll();  // El heap devuelve los más pequeños primero
        }

        return resultado;
    }
}
