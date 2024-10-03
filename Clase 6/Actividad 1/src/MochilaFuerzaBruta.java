import java.util.ArrayList;
import java.util.List;

public class MochilaFuerzaBruta {

    static int[] pesos = {3, 4, 2};
    static int[] valores = {4, 5, 3};
    static int capacidadMochila = 6;

    public static void main(String[] args) {
        int cantidadObjetos = pesos.length;
        List<Integer> objetosSeleccionados = new ArrayList<>();
        int valorMaximo = mochilaFuerzaBruta(cantidadObjetos, capacidadMochila, objetosSeleccionados);

        System.out.println("Valor máximo obtenido (Fuerza Bruta): " + valorMaximo);
        System.out.print("Objetos seleccionados: ");
        for (int obj : objetosSeleccionados) {
            System.out.print((obj + 1) + " "); 
        }
    }

    // prueba todas las combinaciones de objetos
    static int mochilaFuerzaBruta(int cantidadObjetos, int capacidad, List<Integer> objetosSeleccionados) {
        if (cantidadObjetos == 0 || capacidad == 0) {
            return 0;  // Caso base
        }

        if (pesos[cantidadObjetos - 1] > capacidad) {
            // Si no se puede incluir el último objeto, simplemente lo ignoramos
            return mochilaFuerzaBruta(cantidadObjetos - 1, capacidad, objetosSeleccionados);
        } else {
            // Crea dos listas temporales para rastrear las selecciones en ambas decisiones
            List<Integer> sinIncluir = new ArrayList<>(objetosSeleccionados);
            List<Integer> incluyendo = new ArrayList<>(objetosSeleccionados);

            // Opción 1: no incluir el último objeto
            int valorSinIncluir = mochilaFuerzaBruta(cantidadObjetos - 1, capacidad, sinIncluir);

            // Opción 2: incluir el último objeto
            int valorIncluyendo = valores[cantidadObjetos - 1] + mochilaFuerzaBruta(cantidadObjetos - 1, capacidad - pesos[cantidadObjetos - 1], incluyendo);
            incluyendo.add(cantidadObjetos - 1); // Añadimos el objeto actual a la lista

          
            if (valorIncluyendo > valorSinIncluir) {
                objetosSeleccionados.clear();
                objetosSeleccionados.addAll(incluyendo);
                return valorIncluyendo;
            } else {
                objetosSeleccionados.clear();
                objetosSeleccionados.addAll(sinIncluir);
                return valorSinIncluir;
            }
        }
    }
}
