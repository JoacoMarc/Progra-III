import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Definir un array desordenado
        int[] arrayDesordenado = {38, 27, 43, 3, 9, 82, 10};

        // Mostrar el array antes de ordenar
        System.out.println("Array antes de ordenar: " + Arrays.toString(arrayDesordenado));

        // Llamar al método mergeSort para ordenar el array
        MergeSort.mergeSort(arrayDesordenado);

        // Mostrar el array después de ordenar
        System.out.println("Array después de ordenar: " + Arrays.toString(arrayDesordenado));
    }
}
