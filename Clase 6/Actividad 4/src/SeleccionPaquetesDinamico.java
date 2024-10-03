public class SeleccionPaquetesDinamico {

    public static void main(String[] args) {
        int[] costos = {12, 20, 15, 25}; 
        int[] ganancias = {150, 200, 100, 300}; 
        int presupuesto = 35; 

        int numeroPaquetes = costos.length;
        int[][] dp = new int[numeroPaquetes + 1][presupuesto + 1];

        // Inicializar 
        for (int i = 0; i <= numeroPaquetes; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                dp[i][j] = 0;
            }
        }

        // Llena la tabla dp 
        for (int i = 1; i <= numeroPaquetes; i++) {
            for (int j = 1; j <= presupuesto; j++) {
                if (costos[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], ganancias[i - 1] + dp[i - 1][j - costos[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int gananciaMaxima = dp[numeroPaquetes][presupuesto];
        System.out.println("Ganancia máxima obtenida: " + gananciaMaxima);
        System.out.print("Paquetes seleccionados: ");
        mostrarPaquetesSeleccionados(dp, costos, numeroPaquetes, presupuesto);
    }

    static void mostrarPaquetesSeleccionados(int[][] dp, int[] costos, int n, int presupuesto) {
        int w = presupuesto;
        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.print(i + " ");
                w = w - costos[i - 1];
            }
        }
        System.out.println();
    }
}