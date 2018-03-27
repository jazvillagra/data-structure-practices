
public class Lista<Tipo> {
	
	private NodoLista<Tipo> cabecera;
	private int tam;
	
	public Lista() {
		cabecera = new NodoLista<Tipo>();
		tam = 0;
	}
	public void insert(Tipo valor) {
		NodoLista<Tipo> nuevo = new NodoLista<Tipo>();
		nuevo.dato = valor;
		nuevo.next = cabecera.next;
		cabecera.next = nuevo;
		tam++;
	}
	
	public Iterador<Tipo> getIterador(){
		return new Iterador<Tipo>(cabecera);
	}
	
	public int search(Tipo x) {
		int pos = -1;
		
		NodoLista<Tipo> act = cabecera;
		int i = 0;
		while (act.next != null && pos == -1) {
			i++;
			act = act.next;
			if (act.dato.equals(x)) {
				pos = i;
			}
		}
		return pos;
	}
}