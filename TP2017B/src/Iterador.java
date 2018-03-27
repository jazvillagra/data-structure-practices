
public class Iterador {

	private NodoListaEnlazada cabLista;
	private NodoListaEnlazada actual;
	
	public Iterador(NodoListaEnlazada c) {
		cabLista = c;
		actual = c;
	}
	
	public boolean hasNext() {
		return (actual.getSiguienteElemento() != null);
	}
	
	public Contenedor next() {
		actual = actual.getSiguienteElemento();
		return actual.getDato();
	}
}
