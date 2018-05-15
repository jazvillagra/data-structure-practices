package main;

public class NodoColaPrioridad<TipoDeDato> {
	ColaSimple compra;
	ColaSimple consulta;
	ColaSimple queja;
	NodoColaPrioridad nodoSiguiente;
	
	/**
	 * @return the compra
	 */
	public ColaSimple getCompra() {
		return compra;
	}
	
	/**
	 * @param compra the compra to set
	 */
	public void setCompra(ColaSimple compra) {
		this.compra = compra;
	}
	
	/**
	 * @return the consulta
	 */
	public ColaSimple getConsulta() {
		return consulta;
	}
	
	/**
	 * @param consulta the consulta to set
	 */
	public void setConsulta(ColaSimple consulta) {
		this.consulta = consulta;
	}
	
	/**
	 * @return the queja
	 */
	public ColaSimple getQueja() {
		return queja;
	}
	
	/**
	 * @param queja the queja to set
	 */
	public void setQueja(ColaSimple queja) {
		this.queja = queja;
	}

	/**
	 * @return the nodoSiguiente
	 */
	public NodoColaPrioridad getNodoSiguiente() {
		return nodoSiguiente;
	}

	/**
	 * @param nodoSiguiente the nodoSiguiente to set
	 */
	public void setNodoSiguiente(NodoColaPrioridad nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}
	
}
