package ej1;

import java.util.ArrayList;
import java.util.List;

public class MochilaProgramacionDinamica {

    static int[] pesos = {3, 4, 2};
    static int[] valores = {4, 5, 3};
    static int capacidadMochila = 6;
    static int[][] dp;

    public static void main(String[] args) {
        int cantidadObjetos = pesos.length;
        dp = new int[cantidadObjetos + 1][capacidadMochila + 1];

        // Inicializar la tabla dp con -1 para distinguir valores no calculados
        for (int i = 0; i <= cantidadObjetos; i++) {
            for (int j = 0; j <= capacidadMochila; j++) {
                dp[i][j] = -1;
            }
        }

        // Llenar la tabla dp de forma iterativa
        for (int i = 0; i <= cantidadObjetos; i++) {
            for (int j = 0; j <= capacidadMochila; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0; // Caso base
                } else if (pesos[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j]; // No incluir el objeto
                } else {
                    int valorSinIncluir = dp[i - 1][j];
                    int valorIncluyendo = dp[i - 1][j - pesos[i - 1]] + valores[i - 1];
                    dp[i][j] = Math.max(valorSinIncluir, valorIncluyendo);
                }
            }
        }

        // Reconstruir la lista de objetos seleccionados
        List<Integer> objetosSeleccionados = new ArrayList<>();
        int res = dp[cantidadObjetos][capacidadMochila];
        int w = capacidadMochila;
        for (int i = cantidadObjetos; i > 0 && res > 0; i--) {
            if (res == dp[i - 1][w]) {
                // El objeto i-1 no fue incluido
                continue;
            } else {
                // El objeto i-1 fue incluido
                objetosSeleccionados.add(i - 1);
                res -= valores[i - 1];
                w -= pesos[i - 1];
            }
        }

        // Invertir la lista para mostrar en orden correcto
        List<Integer> seleccionInvertida = new ArrayList<>();
        for (int i = objetosSeleccionados.size() - 1; i >= 0; i--) {
            seleccionInvertida.add(objetosSeleccionados.get(i));
        }

        System.out.println("Valor máximo obtenido (Programación Dinámica Iterativa con Math.max): " + dp[cantidadObjetos][capacidadMochila]);
        System.out.print("Objetos seleccionados: ");
        for (int obj : seleccionInvertida) {
            System.out.print((obj + 1) + " ");
        }
    }
}
