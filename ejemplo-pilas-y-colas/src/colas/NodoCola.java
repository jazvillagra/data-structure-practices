package colas;

public class NodoCola<TipoDeDato extends Comparable<TipoDeDato>> implements java.lang.Comparable<TipoDeDato>  {
    
    TipoDeDato dato;
    NodoCola<TipoDeDato> siguiente;

    /**
     * @return the dato
     */
    public TipoDeDato getDato() {
        return dato;
    }

    /**
     * @param dato the dato to set
     */
    public void setDato(TipoDeDato dato) {
        this.dato = dato;
    }

    /**
     * @return the siguiente
     */
    public NodoCola<TipoDeDato> getSiguiente() {
        return siguiente;
    }

    /**
     * @param siguiente the siguiente to set
     */
    public void setSiguiente(NodoCola<TipoDeDato> siguiente) {
        this.siguiente = siguiente;
    }

	public int compareTo(TipoDeDato o) {
		return dato.compareTo(o);
	}
}
