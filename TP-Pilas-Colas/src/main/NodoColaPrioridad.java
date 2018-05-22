package main;
/**
 * 
 * @author jvillagra, mfare, jheisecke
 *
 */
public class NodoColaPrioridad<TipoDeDato> {
	ColaSimple<TipoDeDato> compra = new ColaSimple<>();
	ColaSimple<TipoDeDato> consulta = new ColaSimple<>();
	ColaSimple<TipoDeDato> queja = new ColaSimple<>();
	NodoColaPrioridad<TipoDeDato> nodoSiguiente;
	
	/**
	 * @return the compra
	 */
	public ColaSimple<TipoDeDato> getCompra() {
		return compra;
	}
	
	/**
	 * @param compra the compra to set
	 */
	public void setCompra(ColaSimple<TipoDeDato> compra) {
		this.compra = compra;
	}
	
	/**
	 * @return the consulta
	 */
	public ColaSimple<TipoDeDato> getConsulta() {
		return consulta;
	}
	
	/**
	 * @param consulta the consulta to set
	 */
	public void setConsulta(ColaSimple<TipoDeDato> consulta) {
		this.consulta = consulta;
	}
	
	/**
	 * @return the queja
	 */
	public ColaSimple<TipoDeDato> getQueja() {
		return queja;
	}
	
	/**
	 * @param queja the queja to set
	 */
	public void setQueja(ColaSimple<TipoDeDato> queja) {
		this.queja = queja;
	}

	/**
	 * @return the nodoSiguiente
	 */
	public NodoColaPrioridad<TipoDeDato> getNodoSiguiente() {
		return nodoSiguiente;
	}

	/**
	 * @param nodoSiguiente the nodoSiguiente to set
	 */
	public void setNodoSiguiente(NodoColaPrioridad<TipoDeDato> nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}
	
}
