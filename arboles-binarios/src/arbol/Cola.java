package arbol;

public class Cola<Tipo> implements InterfazCola<Tipo>{

    private NodoCola<Tipo> iniCola;
    private NodoCola<Tipo> finCola;
    private int tamanoCola;

    /**
     * Constructor de la clase, se inicializa la cola
     */
    public Cola() {
        tamanoCola = 0;
        iniCola = null;
        finCola = null;
    }
    
    @Override
    public void encolar(Tipo nuevoDato) {
        NodoCola<Tipo> nuevoNodo = new NodoCola<>();
        nuevoNodo.dato = nuevoDato;
        nuevoNodo.siguiente = null;

        if (esVacia()) {
            iniCola = nuevoNodo;
            finCola = nuevoNodo;
        } else {
            finCola.siguiente = nuevoNodo;
            finCola = nuevoNodo;
        }
        tamanoCola = tamanoCola + 1;

        System.out.println("\n Tamaño de cola: "+tamanoCola);
    }

    @Override
    public Tipo desencolar() {
        Tipo ret = null;
        if (!esVacia()) {
            ret = iniCola.dato;
            iniCola = iniCola.siguiente;
            tamanoCola = tamanoCola - 1;
        }
        return ret;
    }

    @Override
    public Tipo obtenerFrente() {
        Tipo ret = null;
        if (!esVacia()) {
            ret = iniCola.dato;
        }
        return ret;
    }

    @Override
    public void anular() {
        tamanoCola = 0;
        iniCola = null;
        finCola = null;
    }

    @Override
    public int tamanoCola() {
        return tamanoCola;
    }

    @Override
    public boolean esVacia() {
        if (tamanoCola == 0) {
            return true;
        } else {
            return false;
        }
    }
}
