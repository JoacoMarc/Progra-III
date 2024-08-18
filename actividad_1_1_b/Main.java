import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Sistema_Facturacion facturacion= new Sistema_Facturacion();

        for(int i=0;i<3;i++){
            facturacion.crear_cliente();

        }

        facturacion.mostrar_clientes();


        for(int i=0;i<3;i++){
            facturacion.crear_Factura();

        }

        facturacion.imprimir_factura_cliente();



    }
}