import ciberataques.Nodo;

import static ciberataques.SistemaDeteccion.alfaBeta;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Crear el nodo raíz del árbol de decisiones para detectar ataques
        Nodo raiz = new Nodo("Inicio");

        // Agregar nodos hijos representando posibles ataques
        Nodo sqlInjection = new Nodo("SQL Injection", 5);
        Nodo bruteForce = new Nodo("Brute Force", 3);
        Nodo ddos = new Nodo("DDoS", 4);

        raiz.agregarHijo(sqlInjection);
        raiz.agregarHijo(bruteForce);
        raiz.agregarHijo(ddos);

        // Ejecutar la poda alfa-beta desde el nodo raíz con profundidad máxima 2
        int valor = alfaBeta(raiz, 2, Integer.MIN_VALUE, Integer.MAX_VALUE, true);

        System.out.println("El mejor valor para mitigar ataques es: " + valor);
    }
}