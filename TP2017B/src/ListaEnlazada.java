
public class ListaEnlazada {

	private NodoListaEnlazada cabecera;
	
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
	}
	
	/**
	 * Funcion que recupera y retorna el valor numerico asociado a una clave almacenada en la lista enlazada
	 * Si no existe la clave, retorna un objeto null
	 * @param clave cuyo valor se busca
	 * @return el valor asociado a la clave o NULL si no existe dicha clave en la lista
	 */
	public Long recuperarElemento(String clave) {
		//TODO: pendiente de implementacion
		
		return 0L;
	}
	
}
