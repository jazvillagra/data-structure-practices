package main;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
/**
 * 
 * @author jvillagra, mfare, jheisecke
 *
 * @param <TipoDeDato>
 */
public class NodoColaSimple<TipoDeDato> {
	String nombre;
	int antig;
	String motivo;
	LocalDateTime ld;
	NodoColaSimple<TipoDeDato> nodoSiguiente;
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	String date;
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * @return the antig
	 */
	public int getAntig() {
		return antig;
	}
	
	/**
	 * @param antig the antig to set
	 */
	public void setAntig(int antig) {
		this.antig = antig;
	}
	
	/**
	 * @return the motivo
	 */
	public String getMotivo() {
		return motivo;
	}
	
	/**
	 * @param motivo the motivo to set
	 */
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	/**
	 * @return the ld
	 */
	public LocalDateTime getLd() {
		return ld;
	}
	
	/**
	 * @param ld the ld to set
	 */
	public void setLd(LocalDateTime ld) {
		this.ld = ld;
	}
	
	/**
	 * @return the nodoSiguiente
	 */
	public NodoColaSimple<TipoDeDato> getNodoSiguiente() {
		return nodoSiguiente;
	}
	
	/**
	 * @param nodoSiguiente the nodoSiguiente to set
	 */
	public void setNodoSiguiente(NodoColaSimple<TipoDeDato> nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}

	public String getDate() {
		return date;
	}

	public void setDate(LocalDateTime ld) {
		this.date = dtf.format(ld);;
	}
	
}
