public class Main {

    public static void main(String[] args) {
        Cliente[] clientes = {
                new Cliente(1, "Carlos", 85),
                new Cliente(2, "Ana", 92),
                new Cliente(3, "Luis", 75),
                new Cliente(4, "María", 90),
                new Cliente(5, "Jorge", 78),
                new Cliente(6, "Sara", 88)
        };

        // Crear una instancia de la clase DosMayoresClientes
        DosMayoresClientes dm = new DosMayoresClientes();

        // Llamar al método encontrarDosClientesConMayorScoring
        Cliente[] resultado = dm.encontrarDosClientesConMayorScoring(clientes, 0, clientes.length - 1);

        // Imprimir los resultados
        System.out.println("Cliente con mayor scoring: " + resultado[0]);
        System.out.println("Cliente con segundo mayor scoring: " + resultado[1]);
    }
}
