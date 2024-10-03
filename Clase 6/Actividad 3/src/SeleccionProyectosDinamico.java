public class SeleccionProyectosDinamico {

    public static void main(String[] args) {
        int[] costos = {10, 15, 20, 25}; // Costos de los proyectos
        int[] beneficios = {100, 200, 150, 300}; // Beneficios esperados de los proyectos
        int presupuesto = 40; // Presupuesto disponible

        int numeroProyectos = costos.length;
        int[][] dp = new int[numeroProyectos + 1][presupuesto + 1];

        // Inicializar la tabla dp con ceros
        for (int i = 0; i <= numeroProyectos; i++) {
            for (int j = 0; j <= presupuesto; j++) {
                dp[i][j] = 0;
            }
        }

        // Llenar la tabla dp de forma iterativa
        for (int i = 1; i <= numeroProyectos; i++) {
            for (int j = 1; j <= presupuesto; j++) {
                if (costos[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j], beneficios[i - 1] + dp[i - 1][j - costos[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int beneficioMaximo = dp[numeroProyectos][presupuesto];
        System.out.println("Beneficio máximo obtenido: " + beneficioMaximo);
        System.out.print("Proyectos seleccionados: ");
        mostrarProyectosSeleccionados(dp, costos, numeroProyectos, presupuesto);
    }

    static void mostrarProyectosSeleccionados(int[][] dp, int[] costos, int n, int presupuesto) {
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
