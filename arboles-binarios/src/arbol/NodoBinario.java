package arbol;

public class NodoBinario<TipoDeDato extends Comparable> {
	TipoDeDato dato;
	NodoBinario<TipoDeDato> izq;
	NodoBinario<TipoDeDato> der;
	
	public NodoBinario() {
        dato = null;
        izq = null;
        der= null;
    }
	public NodoBinario(TipoDeDato datoNuevo) {
		dato = datoNuevo;
        izq = null;
        der = null;
	}
	
	public NodoBinario(TipoDeDato datoNuevo, NodoBinario<TipoDeDato> i, NodoBinario<TipoDeDato> d) {
		dato = datoNuevo;
        izq = i;
        der = d;
	}

	public TipoDeDato getDato() {
		return dato;
	}

	public void setDato(TipoDeDato dato) {
		this.dato = dato;
	}

	public NodoBinario<TipoDeDato> getIzq() {
		return izq;
	}

	public void setIzq(NodoBinario<TipoDeDato> izq) {
		this.izq = izq;
	}

	public NodoBinario<TipoDeDato> getDer() {
		return der;
	}

	public void setDer(NodoBinario<TipoDeDato> der) {
		this.der = der;
	}
	public int compareTo(TipoDeDato otro) {
		return dato.compareTo(otro);
	}
}
