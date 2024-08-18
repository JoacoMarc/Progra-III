package Actividad_1_1;

public class Actividad_1_1 {
    public static void main(String[] args) {
        int[] array = {1, 5, 9, 0, 4, 3, 6, 12}; // 1

        // variable max
        int max = 0; // 1

        // ciclo que se va quedando con el máximo y descartando los otros.
        for (int j = 0; j < array.length; j++) { // 1+2(n+1)+n
            if (array[j] > max) { //2n
                max = array[j]; //n
            }
        }
        // print resultado
        System.out.println("El mayor es el num: " + max); // 1

    }
}

//f(n)=1+1+1+2(n+1)+n+2n+n+1
//f(n)=6+6n
