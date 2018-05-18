package main;

import java.time.LocalDate;
import java.util.Date;

public class ColaPrioridad<TipoDeDato> implements InterfazColaPrioridad {
	private NodoColaPrioridad<TipoDeDato> initColaPrioridad;
	private NodoColaPrioridad<TipoDeDato> finColaPrioridad;
	//Este nodo es unico, no es necesario que al agregar un nuevo cliente se agregue un nuevo nodo
	NodoColaPrioridad <TipoDeDato> nodoCola= new NodoColaPrioridad<>();

	public ColaPrioridad(){
		initColaPrioridad=null;
		finColaPrioridad=null;
	}
	
	@Override
	public void agregarCliente(String nombre, int antig, String motivo, LocalDate ld, char prioridad) {
		// TODO Auto-generated method stub		
		switch (prioridad) {
		case 'A':
			nodoCola.queja.encolar(nombre, antig, motivo, ld);
			break;
		case 'M':
			nodoCola.compra.encolar(nombre, antig, motivo, ld);
			break;
		case 'B':
			nodoCola.consulta.encolar(nombre, antig, motivo, ld);
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
			ret = nodoCola.queja.desencolar();
			break;
		case 'M':
			ret = nodoCola.compra.desencolar();
			break;
		case 'B':
			ret = nodoCola.consulta.desencolar();
			break;
		default:
			System.out.println("No existen clientes con prioridad "+ prioridad);
			break;
		}
        return ret;
	}

}
