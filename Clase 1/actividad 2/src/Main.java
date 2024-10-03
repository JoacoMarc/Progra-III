import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        // Ejemplo con 'long'
        long numeroLong = 9223372036854775807L; // Valor máximo para 'long'
        System.out.println("Valor de long: " + numeroLong);

        // Operaciones con 'long'
        long sumaLong = numeroLong + 10;
        System.out.println("Suma con long: " + sumaLong);

        // Ejemplo con 'BigInteger'
        BigInteger numeroBigInt = new BigInteger("9223372036854775808"); // Un número mayor que 'long'
        System.out.println("Valor de BigInteger: " + numeroBigInt);

        // Operaciones con 'BigInteger'
        BigInteger sumaBigInt = numeroBigInt.add(new BigInteger("10"));
        System.out.println("Suma con BigInteger: " + sumaBigInt);

        // Otras operaciones posibles con BigInteger
        BigInteger multiplicacion = numeroBigInt.multiply(new BigInteger("2"));
        System.out.println("Multiplicación con BigInteger: " + multiplicacion);
    }
}

