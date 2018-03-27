
public class Iterador<Tipo> {
	
	private NodoLista<Tipo> cabLista;
	private NodoLista<Tipo> actual;
	
	public Iterador(NodoLista<Tipo> c) {
		cabLista = c;
		actual = c;
	}
	
	public boolean hasNext() {
		return (actual.next != null);
	}
	
	public Tipo next() {
		actual = actual.next;
		return actual.dato;
	}
}
