package arbol;

public class NodoBinario<TipoDeDato extends Comparable> {
	TipoDeDato dato;
	NodoBinario izq;
	NodoBinario der;
	
	public NodoBinario(TipoDeDato dato) {
		// TODO Auto-generated constructor stub
	}
	
	public NodoBinario(TipoDeDato dato, NodoBinario i, NodoBinario d) {
		// TODO Auto-generated constructor stub
	}

	public TipoDeDato getDato() {
		return dato;
	}

	public void setDato(TipoDeDato dato) {
		this.dato = dato;
	}

	public NodoBinario getIzq() {
		return izq;
	}

	public void setIzq(NodoBinario izq) {
		this.izq = izq;
	}

	public NodoBinario getDer() {
		return der;
	}

	public void setDer(NodoBinario der) {
		this.der = der;
	}
	public int compareTo(TipoDeDato otro) {
		return dato.compareTo(otro);
	}
}
