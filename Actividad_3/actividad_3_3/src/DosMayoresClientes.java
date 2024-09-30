public class DosMayoresClientes {

    // Método que usa la técnica Divide y Vencerás para encontrar los dos clientes con mayor scoring
    public Cliente[] encontrarDosClientesConMayorScoring(Cliente[] clientes, int inicio, int fin) {
        if (inicio == fin) {
            return new Cliente[]{clientes[inicio], null};  // Un solo cliente
        }

        if (fin - inicio == 1) {  // Dos clientes
            if (clientes[inicio].getScoring() > clientes[fin].getScoring()) {
                return new Cliente[]{clientes[inicio], clientes[fin]};
            } else {
                return new Cliente[]{clientes[fin], clientes[inicio]};
            }
        }

        // Dividir en dos mitades
        int medio = (inicio + fin) / 2;
        Cliente[] izquierda = encontrarDosClientesConMayorScoring(clientes, inicio, medio);
        Cliente[] derecha = encontrarDosClientesConMayorScoring(clientes, medio + 1, fin);

        // Combinar los resultados
        Cliente mayor, segundoMayor;
        if (izquierda[0].getScoring() > derecha[0].getScoring()) {
            mayor = izquierda[0];
            segundoMayor = (izquierda[1] != null && izquierda[1].getScoring() > derecha[0].getScoring()) ? izquierda[1] : derecha[0];
        } else {
            mayor = derecha[0];
            segundoMayor = (derecha[1] != null && derecha[1].getScoring() > izquierda[0].getScoring()) ? derecha[1] : izquierda[0];
        }

        return new Cliente[]{mayor, segundoMayor};
    }
}
