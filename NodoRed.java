import java.util.*; 

public class NodoRed implements Comparable<NodoRed> {
    private int idNodo, capacidadProcesamiento, memoria, conexionesActivas;

    public NodoRed(int idNodo, int capacidadProcesamiento, int memoria, int conexionesActivas) {
        this.idNodo = idNodo;
        this.capacidadProcesamiento = capacidadProcesamiento;
        this.memoria = memoria;
        this.conexionesActivas = conexionesActivas;
    }

    @Override
    public int compareTo(NodoRed otro) {
        if (this.idNodo != otro.idNodo)
            return Integer.compare(this.idNodo, otro.idNodo);
        if (this.capacidadProcesamiento != otro.capacidadProcesamiento)
            return Integer.compare(this.capacidadProcesamiento, otro.capacidadProcesamiento);
        if (this.memoria != otro.memoria)
            return Integer.compare(this.memoria, otro.memoria);
        return Integer.compare(this.conexionesActivas, otro.conexionesActivas);
    }

    @Override
    public int hashCode() {
        int p = 128;
        long clave = (long) idNodo * p * p * p
                   + (long) capacidadProcesamiento * p * p
                   + (long) memoria * p
                   + (long) conexionesActivas;
        return (int) (clave ^ (clave >>> 32));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof NodoRed)) return false;
        NodoRed otro = (NodoRed) obj;
        return idNodo == otro.idNodo &&
               capacidadProcesamiento == otro.capacidadProcesamiento &&
               memoria == otro.memoria &&
               conexionesActivas == otro.conexionesActivas;
    }

    @Override
    public String toString() {
        return "NodoRed{" +
               "idNodo=" + idNodo +
               ", capacidadProcesamiento=" + capacidadProcesamiento +
               ", memoria=" + memoria +
               ", conexionesActivas=" + conexionesActivas +
               '}';
    }

    // Método main
    public static void main(String[] args) {
        NodoRed n1 = new NodoRed(2, 500, 1024, 10);
        NodoRed n2 = new NodoRed(1, 700, 2048, 5);
        NodoRed n3 = new NodoRed(2, 500, 1024, 8);

        List<NodoRed> lista = new ArrayList<>();
        lista.add(n1);
        lista.add(n2);
        lista.add(n3);

        System.out.println("Antes de ordenar:");
        for (NodoRed n : lista) {
            System.out.println(n);
        }

        Collections.sort(lista);

        System.out.println("\nDespués de ordenar (con compareTo):");
        for (NodoRed n : lista) {
            System.out.println(n);
        }
    }
}
