import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema_Facturacion facturacion = new Sistema_Facturacion();
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Crear Cliente");
            System.out.println("2. Mostrar Clientes");
            System.out.println("3. Crear Factura");
            System.out.println("4. Imprimir Factura por Cliente");
            System.out.println("5. Salir");
            System.out.print("Selecciona una opción: ");
            int opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    facturacion.crear_cliente();
                    break;
                case 2:
                    facturacion.mostrar_clientes();
                    break;
                case 3:
                    facturacion.crear_Factura();
                    break;
                case 4:
                    facturacion.imprimir_factura_cliente();
                    break;
                case 5:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
        sc.close();
    }
}
