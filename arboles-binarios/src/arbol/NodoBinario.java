package arbol;

public class NodoBinario<TipoDeDato extends Comparable> {
	TipoDeDato dato;
	NodoBinario<TipoDeDato> izq;
	NodoBinario<TipoDeDato> der;
	
	public NodoBinario(TipoDeDato dato) {
		// TODO Auto-generated constructor stub
	}
	
	public NodoBinario(TipoDeDato dato, NodoBinario<TipoDeDato> i, NodoBinario<TipoDeDato> d) {
		// TODO Auto-generated constructor stub
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
