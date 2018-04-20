//Author: Jazmin Villagra
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
		//Se crea el contenedor de la clave y el valor a insertar en el elemento de la lista
		Contenedor n = new Contenedor(clave, valor);
		
		if(cabecera != null) {	
			if(buscarElemento(n.getClave()) == -1L) {
		        //se crea el nodo "nuevo" en la lista
		        NodoListaEnlazada nuevo = new NodoListaEnlazada(n, cabecera.getSiguienteElemento());
		        //seteamos el elemento al que apuntara la cabecera
		        cabecera.setSiguienteElemento(nuevo);
		        //aumenta el tamaño de la lista cada vez que se ingresa un nuevo elemento
			}else{
				n.setValor(n.getValor()+valor);
				cabecera.setDato(n);
				//System.out.println(n.getClave()+" "+n.getValor());
			}
		}
	}
	
	/**
	 * Funcion que recupera y retorna el valor numerico asociado a una clave almacenada en la lista enlazada
	 * Si no existe la clave, retorna un objeto null
	 * @param clave cuyo valor se busca
	 * @return el valor asociado a la clave o NULL si no existe dicha clave en la lista
	 */
	public Long recuperarElemento(String clave) {
		//se inicializa la posicion a utilizar
		Long pos = -1L;
		NodoListaEnlazada act = cabecera;
		int i = 0;
		
		while (act.getSiguienteElemento() != null && pos == -1L) {
			i++;
			act = act.getSiguienteElemento();
			if (act.getDato().getClave().equals(clave)) {
				pos = act.getDato().getValor();
			}
		}
		if(pos != -1){
			return pos;
		}else{
			return null;
		}
	}
	
	public Long buscarElemento(String clave) {
		//se inicializa la posicion a utilizar
		Long pos = -1L;
		NodoListaEnlazada act = cabecera;
		int i = 0;
		
		while (act.getSiguienteElemento() != null && pos == -1L) {
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
