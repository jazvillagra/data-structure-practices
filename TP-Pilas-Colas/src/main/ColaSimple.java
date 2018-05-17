package main;

import java.time.LocalDate;
import java.util.Date;

public class ColaSimple<TipoDeDato> implements InterfazColaSimple{
	
	private NodoColaSimple<TipoDeDato> initColaSimple;
    private NodoColaSimple<TipoDeDato> finColaSimple;
    private int tamCola;
    
    public ColaSimple(){
    	initColaSimple= null;
    	finColaSimple= null;
    	tamCola=0;
    }

	@Override
	public void encolar(String nombre, int antig, String motivo, LocalDate ld) {
		NodoColaSimple<TipoDeDato> nuevoNodo = new NodoColaSimple<>();
		nuevoNodo.nombre=nombre;
		nuevoNodo.antig=antig;
		nuevoNodo.motivo=motivo;
		nuevoNodo.ld=ld;
		nuevoNodo.nodoSiguiente=null;
		if (esVacia()) {
            initColaSimple = nuevoNodo;
            finColaSimple = nuevoNodo;
        } else {
            finColaSimple.nodoSiguiente = nuevoNodo;
            finColaSimple = nuevoNodo;
        }

        tamCola = tamCola + 1;
	}

	@Override
	public String desencolar() {
		String ret = null;
        if (!esVacia()) {
            ret = initColaSimple.nombre;
            initColaSimple = initColaSimple.nodoSiguiente;
            tamCola = tamCola - 1;
        }
        return ret;
	}
	
	private boolean esVacia() {
		if (tamCola == 0) {
            return true;
        } else {
            return false;
        }
	}
}
