
public class NodoLista<Tipo> {
	Tipo dato;
	NodoLista<Tipo> next;
	
	public NodoLista() {
		dato = null;
		next = null;
	}
	public NodoLista(Tipo d, NodoLista n) {
		dato = d;
		next = n;
	}
}
