public class Main {

    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente(1, "Cliente A", 85),
                new Cliente(2, "Cliente B", 90),
                new Cliente(3, "Cliente C", 75),
                new Cliente(4, "Cliente D", 95),
                new Cliente(5, "Cliente E", 80)
        };

        Cliente clienteConMaxScoring = MaxScoringCliente.buscarClienteConScoringMaximo(clientes, 0, clientes.length - 1);
        System.out.println("Cliente con el scoring máximo: " + clienteConMaxScoring);
    }
}
