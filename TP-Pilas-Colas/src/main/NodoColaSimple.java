package main;

import java.time.LocalDate;

public class NodoColaSimple<TipoDeDato> {
	String nombre;
	int antig;
	String motivo;
	LocalDate ld = LocalDate.now();
	NodoColaSimple<TipoDeDato> nodoSiguiente;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getAntig() {
		return antig;
	}
	public void setAntig(int antig) {
		this.antig = antig;
	}
	public String getMotivo() {
		return motivo;
	}
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	public LocalDate getLd() {
		return ld;
	}
	public void setLd(LocalDate ld) {
		this.ld = ld;
	}
	public NodoColaSimple<TipoDeDato> getNodoSiguiente() {
		return nodoSiguiente;
	}
	public void setNodoSiguiente(NodoColaSimple<TipoDeDato> nodoSiguiente) {
		this.nodoSiguiente = nodoSiguiente;
	}
	
}
