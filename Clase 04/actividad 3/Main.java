//Una empresa distribuidora necesita cargar un camión con mercancía que se puede fraccionar. 
//Indicar con una lista los elementos a subir al camión para maximizar el valor total, 
//dado que el camión tiene una capacidad limitada.


package clase_4.actividad_3;

public class Main {
    public static void main(String[] args) {
        // Se crea un arreglo de mercancía con valores específicos
        double[] mercancia = {0.52,1, 5, 10, 25, 50, 100, 500, 1000, 5000, 10000, 50000};
        // Se crea un arreglo de mercancía con valores específicos
        double capacidad = 525.52;
        // Se imprime si es posible realizar la carga
        System.out.println("Es posible realizar la carga: " + realizarCarga(mercancia, capacidad));
    }

    public static boolean realizarCarga(double[] mercancia, double capacidad) {
        // Se ordena el arreglo de mercancía de mayor a menor
        for (int i = 0; i < mercancia.length; i++) {
            for (int j = i + 1; j < mercancia.length; j++) {
                if (mercancia[i] < mercancia[j]) {
                    double aux = mercancia[i];
                    mercancia[i] = mercancia[j];
                    mercancia[j] = aux;
                }
            }
        }
        // Se inicializa el índice en 0
        int i = 0;
        // Mientras la capacidad sea mayor a 0 y el índice sea menor al tamaño del arreglo de mercancía
        while (capacidad > 0 && i < mercancia.length) {
            // Si la mercancía en la posición i es menor o igual a la capacidad
            if (mercancia[i] <= capacidad) {
                // Se resta el valor de la mercancía a la capacidad
                capacidad -= mercancia[i];
            } else {
                // Se incrementa el índice
                i++;
            }
        }
        // Si la capacidad es igual a 0, se retorna verdadero
        return capacidad == 0;
    }
    
}
