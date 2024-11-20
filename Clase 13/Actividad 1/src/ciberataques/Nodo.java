package ciberataques;

public class Nodo {
    private String descripcion;  // Descripción del ataque o decisión
    private int valor;           // Valor del nodo (nivel de severidad)
    private Nodo[] hijos;        // Hijos del nodo
    private int numHijos;        // Contador de hijos actuales
    private final int MAX_HIJOS = 10;  // Límite de hijos por nodo

    // Constructor para nodos internos
    public Nodo(String descripcion) {
        this.descripcion = descripcion;
        this.valor = 0;
        this.hijos = new Nodo[MAX_HIJOS];
        this.numHijos = 0;
    }

    // Constructor para nodos terminales
    public Nodo(String descripcion, int valor) {
        this.descripcion = descripcion;
        this.valor = valor;
        this.hijos = new Nodo[0];  // Sin hijos para nodos terminales
        this.numHijos = 0;
    }

    // Método que verifica si un nodo es terminal
    public boolean esNodoTerminal() {
        return numHijos == 0;
    }

    // Método que obtiene el valor del nodo (cuando es terminal)
    public int obtenerValor() {
        return valor;
    }

    // Método que devuelve los hijos de un nodo (solo los inicializados)
    public Nodo[] obtenerHijos() {
        Nodo[] hijosInicializados = new Nodo[numHijos];
        System.arraycopy(hijos, 0, hijosInicializados, 0, numHijos);
        return hijosInicializados;
    }

    // Método para agregar un hijo al nodo
    public void agregarHijo(Nodo hijo) {
        if (numHijos < MAX_HIJOS) {
            hijos[numHijos++] = hijo;
        }
    }

    @Override
    public String toString() {
        return descripcion + " (Severidad: " + valor + ")";
    }
}
