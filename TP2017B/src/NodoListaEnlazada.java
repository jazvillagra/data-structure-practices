
public class NodoListaEnlazada {

	private Contenedor dato;
	private NodoListaEnlazada siguienteElemento;
	
	public NodoListaEnlazada(Contenedor dato, NodoListaEnlazada siguienteElemento) {
		super();
		this.dato = dato;
		this.siguienteElemento = siguienteElemento;
	}

	public Contenedor getDato() {
		return dato;
	}

	public void setDato(Contenedor dato) {
		this.dato = dato;
	}

	public NodoListaEnlazada getSiguienteElemento() {
		return siguienteElemento;
	}

	public void setSiguienteElemento(NodoListaEnlazada siguienteElemento) {
		this.siguienteElemento = siguienteElemento;
	}
	
	
}
