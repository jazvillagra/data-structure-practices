
public class ListaEnlazada {

	private NodoListaEnlazada cabecera;
	private int tam;
	public ListaEnlazada() {
		cabecera = new NodoListaEnlazada(null, null);
	}
	
	/**
	 * Funcion que recibe una clave y valor y con estos datos realiza lo siguiente
	 *    Si la clave ya existe en la lista enlazada, el valor se actualiza (no se agrega ningun nodo nuevo)
	 *    Si la clave aun no existe en la lista enlazada, la clave y valor se inserta en la lista
	 * @param clave a insertar/actualizar
	 * @param valor asociado a la clave
	 */
	
	public void agregarElemento(String clave, Long valor) {
		//TODO: pendiente de implementar
		//Se crea el contenedor de la clave y el valor a insertar en el elemento de la lista
		Contenedor n = new Contenedor(clave, valor);
		if(cabecera.getSiguienteElemento() == null) {
			
			cabecera.setDato(n);
			cabecera.setSiguienteElemento(cabecera);
			tam++;
		}else {
			NodoListaEnlazada nuevo = new NodoListaEnlazada(n, cabecera.getSiguienteElemento());
			cabecera.setSiguienteElemento(nuevo);
			cabecera = nuevo;
		}
	}
	
	/**
	 * Funcion que recupera y retorna el valor numerico asociado a una clave almacenada en la lista enlazada
	 * Si no existe la clave, retorna un objeto null
	 * @param clave cuyo valor se busca
	 * @return el valor asociado a la clave o NULL si no existe dicha clave en la lista
	 */
	public Long recuperarElemento(String clave) {
		//TODO: pendiente de implementacion
		
		Long pos = -1L;
		
		NodoListaEnlazada act = cabecera;
		int i = 0;
		while (act.getSiguienteElemento() != null && pos == -1) {
			i++;
			act = act.getSiguienteElemento();
			if (act.getDato().getClave().equals(clave)) {
				pos = (long) i;
			}
		}
		return pos;
	}

	public Iterador getIterador() {
		return new Iterador(cabecera);
	}
	
}
