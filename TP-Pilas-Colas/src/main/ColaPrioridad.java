package main;

import java.time.LocalDate;
import java.util.Date;

public class ColaPrioridad<TipoDeDato> implements InterfazColaPrioridad {
	private NodoColaPrioridad initColaPrioridad;
	private NodoColaPrioridad finColaPrioridad;
	
	public ColaPrioridad(){
		initColaPrioridad=null;
		finColaPrioridad=null;
	}
	
	@Override
	public void agregarCliente(String nombre, Date antig, String motivo, LocalDate ld, char prioridad) {
		// TODO Auto-generated method stub
		NodoColaPrioridad <TipoDeDato> nuevoNodo= new NodoColaPrioridad<>();
		
		switch (prioridad) {
		case 'A':
			nuevoNodo.queja.encolar(nombre, antig, motivo, ld);
			break;
		case 'M':
			nuevoNodo.compra.encolar(nombre, antig, motivo, ld);
			break;
		case 'B':
			nuevoNodo.consulta.encolar(nombre, antig, motivo, ld);
			break;
		default:
			System.out.println("Prioridad no reconocida. Favor intente registrar al cliente nuevamente");
			break;
		}
	}

	@Override
	public String atenderCliente(char prioridad) {
		String ret = null;
        switch (prioridad) {
		case 'A':
			ret = initColaPrioridad.queja.desencolar();
            initColaPrioridad = initColaPrioridad.nodoSiguiente;
			break;
		case 'M':
			ret = initColaPrioridad.compra.desencolar();
            initColaPrioridad = initColaPrioridad.nodoSiguiente;
			break;
		case 'B':
			ret = initColaPrioridad.consulta.desencolar();
            initColaPrioridad = initColaPrioridad.nodoSiguiente;
			break;
		default:
			System.out.println("No existen clientes con prioridad "+ prioridad);
			break;
		}
        return ret;
	}

}
