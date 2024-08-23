
public class Main {
    public static void main(String[] args) {
        int[] arreglo = {10, 7, 8, 9, 1, 5};
        int n = arreglo.length;

        System.out.println("Array desordenado:");
        Utils.imprimirArray(arreglo);

        QuickSort.quickSort(arreglo, 0, n - 1);

        System.out.println("\nArray ordenado:");
        Utils.imprimirArray(arreglo);
    }
}