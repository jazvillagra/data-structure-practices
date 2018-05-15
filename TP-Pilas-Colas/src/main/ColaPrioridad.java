package main;

import java.time.LocalDate;

public class ColaPrioridad<TipoDeDato> implements InterfazColaPrioridad {
	private NodoColaPrioridad initColaPrioridad;
	private NodoColaPrioridad finColaPrioridad;
	
	public ColaPrioridad(){
		initColaPrioridad=null;
		finColaPrioridad=null;
	}
	
	@Override
	public void agregarCliente(String nombre, int antig, String motivo, LocalDate ld, char prioridad) {
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
			System.out.println("Motivo no reconocido. Favor intente registrar al cliente nuevamente");
			break;
		}
	}

	@Override
	public String atenderCliente() {
		// TODO Auto-generated method stub
		return null;
	}

}
