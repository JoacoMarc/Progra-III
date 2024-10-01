import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Sistema_Facturacion {
    ArrayList<Cliente> lista_clientes = new ArrayList<>();
    ArrayList<Factura> lista_Facturas = new ArrayList<>();


    public boolean existeCliente(int idCliente) {
        for (Cliente cliente : lista_clientes) {
            if (cliente.id_Cliente == idCliente) {
                return true;
            }
        }
        return false;
    }

    public void crear_cliente(){
        Scanner sc=new Scanner(System.in);
        Cliente cliente=new Cliente();

        int id_Cliente;
        do {
            System.out.println("Ingrese ID Cliente: ");
            id_Cliente = sc.nextInt();
            sc.nextLine();
            if (existeCliente(id_Cliente)) {
                System.out.println("Ya existe ese ID, intentelo nuevamente");
            } else {
                cliente.id_Cliente = id_Cliente;
            }
        }while(existeCliente(id_Cliente));


        System.out.println("Ingrese Nombre: ");
        cliente.nombre=sc.nextLine();
        lista_clientes.add(cliente);
    }

    public void mostrar_clientes(){
        for (Cliente cliente:lista_clientes){
            System.out.println("ID: "+cliente.id_Cliente+" "+"Nombre: "+cliente.nombre);
        }
    }



    public void crear_Factura(){
        Scanner sc = new Scanner(System.in);
        Factura factura = new Factura();
        System.out.println("Ingrese ID Factura: ");
        factura.id_Factura = sc.nextInt();
        sc.nextLine();

        int idCliente;
        do {
            System.out.println("Ingrese ID Cliente: ");
            idCliente = sc.nextInt();
            sc.nextLine();

            if (!existeCliente(idCliente)) {
                System.out.println("El ID Cliente no existe. Intente nuevamente.");
            } else {
                factura.id_Cliente = idCliente;
            }
        } while (!existeCliente(idCliente));

        System.out.println("Ingrese Importe: ");
        factura.importe = sc.nextDouble();

        lista_Facturas.add(factura);
    }


    public ArrayList<Object[]> suma_Importes(){
        ArrayList<Object[]> lista_Clientes_Importe=new ArrayList<>();
        for (Cliente cliente:lista_clientes){
            double suma_importe=0.0;
            for (Factura factura:lista_Facturas){
                if (factura.id_Cliente == cliente.id_Cliente){
                    suma_importe+=factura.importe;
                }
            }
            lista_Clientes_Importe.add(new Object[]{cliente.id_Cliente,cliente.nombre,suma_importe});

        }
        return lista_Clientes_Importe;
    }
    public void imprimir_factura_cliente(){
        ArrayList<Object[]> lista = suma_Importes();
        for (Object[] datos : lista) {
            System.out.println("ID Cliente: " + datos[0] + ", Nombre: " + datos[1] + ", Suma de Importes: " + datos[2]);
        }
    }

    //Parte con Maps
    public Map<Integer, Double> sumaImportesConMap() {
        Map<Integer, Double> mapaImportes = new HashMap<>();

        // Sumar importes por cliente
        for (Factura factura : lista_Facturas) {
            int idCliente = factura.id_Cliente;
            double importe = factura.importe;

            mapaImportes.put(idCliente, mapaImportes.getOrDefault(idCliente, 0.0) + importe);
        }

        return mapaImportes;
    }

    public void imprimirFacturaClienteConMap() {
        Map<Integer, Double> mapaImportes = sumaImportesConMap();

        for (Cliente cliente : lista_clientes) {
            double sumaImporte = mapaImportes.getOrDefault(cliente.id_Cliente, 0.0);
            System.out.println("ID Cliente: " + cliente.id_Cliente + ", Nombre: " + cliente.nombre + ", Suma de Importes: " + sumaImporte);
        }
    }

    /*
    Implementación sin Maps: Tiene una complejidad de O(C×F)O(C×F), ya que por cada cliente recorres todas las facturas.

    Implementación con Maps: Reduce la complejidad a O(F+C)O(F+C), ya que recorres las facturas una sola vez para sumar los importes y luego recorres los clientes una vez para imprimir los resultados.
     */
}
