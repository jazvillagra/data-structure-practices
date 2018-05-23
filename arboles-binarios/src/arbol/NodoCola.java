package arbol;

public class NodoCola<Tipo> {
    
    Tipo dato;
    NodoCola<Tipo> siguiente;

    /**
     * @return the dato
     */
    public Tipo getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(Tipo dato) {
        this.dato = dato;
    }

    /**
     * @return the siguiente
     */
    public NodoCola<Tipo> getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoCola<Tipo> siguiente) {
        this.siguiente = siguiente;
    }
    
}
