package colas;

public class Cola<TipoDeDato> implements InterfazCola<TipoDeDato> {

    private NodoCola<TipoDeDato> iniCola;
    private NodoCola<TipoDeDato> finCola;
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
    public void encolar(TipoDeDato nuevoDato) {
        NodoCola<TipoDeDato> nuevoNodo = new NodoCola<>();
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
    }

    @Override
    public TipoDeDato desencolar() {
        TipoDeDato ret = null;
        if (!esVacia()) {
            ret = iniCola.dato;
            iniCola = iniCola.siguiente;
            tamanoCola = tamanoCola - 1;
        }
        return ret;
    }

    @Override
    public TipoDeDato obtenerFrente() {
        TipoDeDato ret = null;
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
