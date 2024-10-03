public class MaxScoringCliente {

    public static Cliente buscarClienteConScoringMaximo(Cliente[] clientes, int inicio, int fin) {
        if (inicio == fin) {
            return clientes[inicio];
        }

        int mitad = (inicio + fin) / 2;
        Cliente ladoIzquierdo = buscarClienteConScoringMaximo(clientes, inicio, mitad);
        Cliente ladoDerecho = buscarClienteConScoringMaximo(clientes, mitad + 1, fin);

        if (ladoIzquierdo.getScoring() > ladoDerecho.getScoring()) {
            return ladoIzquierdo;
        } else {
            return ladoDerecho;
        }
    }
}
