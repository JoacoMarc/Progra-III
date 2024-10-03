public class FuerzaBruta {

    static int[] pesos = {2, 5, 6, 7}; // Pesos de los objetos
    static int[] valores = {4, 2, 1, 6}; // Valores de los objetos
    static int capacidadMochila = 10; // Capacidad máxima de la mochila

    public static void main(String[] args) {
        int numeroObjetos = pesos.length;
        int valorMaximo = 0;
        String objetosSeleccionados = "";

        // Iterar sobre todas las posibles combinaciones de objetos
        for (int i = 0; i < (1 << numeroObjetos); i++) {
            int pesoTotal = 0;
            int valorTotal = 0;
            String objetosActual = "";

            for (int j = 0; j < numeroObjetos; j++) {
                if ((i & (1 << j)) != 0) {
                    pesoTotal += pesos[j];
                    valorTotal += valores[j];
                    objetosActual += (j + 1) + " ";
                }
            }

            // Verificar si la combinación actual es válida y mejora el valor máximo
            if (pesoTotal <= capacidadMochila && valorTotal > valorMaximo) {
                valorMaximo = valorTotal;
                objetosSeleccionados = objetosActual.trim();
            }
        }

        // Imprimir el resultado en el formato solicitado
        System.out.println("Valor máximo obtenido (Fuerza Bruta): " + valorMaximo);
        System.out.println("Objetos seleccionados: " + objetosSeleccionados);
    }
}
