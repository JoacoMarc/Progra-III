public class Main {

    public static void main(String[] args) {
        // Lista de números de ejemplo
        int[] lista = {5, 12, 3, 19, 1, 8, 7, 11, 15, 2};

        // Número de elementos que queremos encontrar
        int n = 3;

        // Instancia de la clase MayoresElementos
        MayoresElementos mayoresElementos = new MayoresElementos();

        // Llamada al método para encontrar los "n" elementos más grandes
        int[] resultado = mayoresElementos.encontrarNMayores(lista, n);

        // Imprimir los resultados
        System.out.println("Los " + n + " elementos más grandes son:");
        for (int num : resultado) {
            System.out.println(num);
        }
    }
}
