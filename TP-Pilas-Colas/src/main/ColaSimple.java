package main;

import java.time.LocalDateTime;

public class ColaSimple<TipoDeDato> implements InterfazColaSimple{
	
	private NodoColaSimple<TipoDeDato> initColaSimple;
    private NodoColaSimple<TipoDeDato> finColaSimple;
    int tamCola;
    
    public ColaSimple(){
    	initColaSimple= null;
    	finColaSimple= null;
    }

	@Override
	public void encolar(String nombre, int antig, String motivo, LocalDateTime ld) {

		NodoColaSimple<TipoDeDato> nuevoNodo = new NodoColaSimple<>();
		nuevoNodo.nombre=nombre;
		System.out.println("Nombre guardado: "+nuevoNodo.getNombre());
		nuevoNodo.antig=antig;
		System.out.println("Antigüedad en años: "+nuevoNodo.getAntig());
		nuevoNodo.motivo=motivo;
		System.out.println("Motivo de visita: "+nuevoNodo.getMotivo());
		nuevoNodo.ld=ld;
		nuevoNodo.setDate(ld);
		System.out.println("Fecha y Hora: "+nuevoNodo.getDate());
		
		if (esVacia()) {
			System.out.println("Entro al if");
            initColaSimple = nuevoNodo;
            finColaSimple = nuevoNodo;
        } else {
        	System.out.println("Entro al else");
            finColaSimple.nodoSiguiente = nuevoNodo;
            finColaSimple = nuevoNodo;
        }
        tamCola = tamCola + 1;
        System.out.println("Tamaño de cola: "+tamCola+"\n");
	}

	@Override
	public String desencolar() {
		String ret = null;
        if (!esVacia()) {
            ret = initColaSimple.getNombre();
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
