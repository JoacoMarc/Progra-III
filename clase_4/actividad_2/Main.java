//Descripción del Problema: Un sistema de tesorería tiene a disposición una variedad de comprobantes que incluyen monedas, cheques, bonos 
//y otros documentos financieros. Cada comprobante tiene un valor específico. El objetivo es realizar una compra de moneda extranjera minimizando 
//el número de comprobantes utilizados. Resolver mediante pseudocódigo e implementación java. Indicar la complejidad algorítmica.


package clase_4.actividad_2;

public class Main {
    public static void main(String[] args) {
        // Se crea un arreglo de comprobantes con valores específicos
        double[] comprobantes = {1, 5, 10, 25, 50, 100, 500, 1000, 5000, 10000, 50000};
        // Se crea un arreglo de comprobantes con valores específicos
        double compra = 100;
        // Se imprime si es posible realizar la compra
        System.out.println("Es posible realizar la compra: " + realizarCompra(comprobantes, compra));
    }

    public static boolean realizarCompra(double[] comprobantes, double compra) {
        // Se ordena el arreglo de comprobantes de mayor a menor
        for (int i = 0; i < comprobantes.length; i++) {
            for (int j = i + 1; j < comprobantes.length; j++) {
                if (comprobantes[i] < comprobantes[j]) {
                    double aux = comprobantes[i];
                    comprobantes[i] = comprobantes[j];
                    comprobantes[j] = aux;
                }
            }
        }
        // Se inicializa el índice en 0
        int i = 0;
        // Mientras la compra sea mayor a 0 y el índice sea menor al tamaño del arreglo de comprobantes
        while (compra > 0 && i < comprobantes.length) {
            // Si el comprobante en la posición i es menor o igual a la compra
            if (comprobantes[i] <= compra) {
                // Se resta el valor del comprobante a la compra
                compra -= comprobantes[i];
            } else {
                // Se incrementa el índice
                i++;
            }
        }
        // Si la compra es igual a 0, se retorna verdadero
        return compra == 0;
    }
    
}
