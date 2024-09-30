public class Main {

    public static void main(String[] args) {
        int[] lista = {5, 8, 12, 1, 34, 22, 9, 15};

        // Crear una instancia de la clase DosMayores
        DosMayores dm = new DosMayores();

        // Llamar al método encontrarDosMayores
        int[] resultado = dm.encontrarDosMayores(lista, 0, lista.length - 1);

        // Imprimir los resultados
        System.out.println("El número más grande es: " + resultado[0]);
        System.out.println("El segundo número más grande es: " + resultado[1]);
    }
}