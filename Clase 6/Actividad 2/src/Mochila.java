public class Mochila {

    static int[] pesos = {2, 5, 6, 7}; 
    static int[] valores = {4, 2, 1, 6}; 
    static int capacidadMochila = 10; 
    static int[][] dp; 

    public static void main(String[] args) {
        int numeroObjetos = pesos.length;
        dp = new int[numeroObjetos + 1][capacidadMochila + 1];

        // Inicializa
        for (int i = 0; i <= numeroObjetos; i++) {
            for (int j = 0; j <= capacidadMochila; j++) {
                dp[i][j] = 0;
            }
        }

        // Llena la tabla DP 
        for (int i = 1; i <= numeroObjetos; i++) {
            for (int j = 1; j <= capacidadMochila; j++) {
                if (pesos[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], valores[i - 1] + dp[i - 1][j - pesos[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int valorMaximo = dp[numeroObjetos][capacidadMochila];
        System.out.println("Valor máximo obtenido (Programación Dinámica Iterativa): " + valorMaximo);
        System.out.print("Objetos seleccionados: ");
        mostrarObjetosSeleccionados(numeroObjetos, capacidadMochila);
        System.out.println();
    }

    static void mostrarObjetosSeleccionados(int i, int j) {
        int w = j;
        for (int n = i; n > 0; n--) {
            if (dp[n][w] != dp[n - 1][w]) {
                System.out.print(n + " ");
                w = w - pesos[n - 1];
            }
        }
    }
}
