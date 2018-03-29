import java.text.NumberFormat;
import java.text.ParseException;

import com.sun.tracing.dtrace.ArgsAttributes;

public class MainEjecutable {
	
	public static void main(String[] args) throws ParseException {
		ListaEnlazada L = new ListaEnlazada();
		//cargar elementos de la linea de comandos a la lista
		cargarElementos(L, args);
		//imprimir lista completa
		System.out.print("\nContenido de la lista A: {\n");
		Iterador it = L.getIterador();
		while (it.hasNext()) {
			Contenedor val = it.next();
			System.out.println(val.getClave() + " " + val.getValor());
		}
		//buscar elemento
		it = L.getIterador();
		while (it.hasNext()) {
			Contenedor X = it.next();
			//esto falta implementar todo
			if(L.recuperarElemento(X.getClave()) > 0){
				System.out.println();
			}
		}
		System.out.println("}\n");
		//TODO: Poner aqui la rutina que lea los valores de listaLibros, listaPrimerasLetras de los argumentos del programa
		//y luego ejecute el calculo e imprima la lista resultante en pantalla
		
	}
	
	public static void cargarElementos(ListaEnlazada L, String[] args) throws ParseException{
		System.out.println("Cargando Elementos");
		for(int i=0; i < args.length; i++){
			int index = args[i].indexOf(",");
			String str = args[i].substring(0, index);
			L.agregarElemento(str,extraerCantidad(args[i]));
		}
	}
	public static Long extraerCantidad(String args){
		String cantidad = "";
		for (int j = 0; j < args.length(); j++) {
			Character character = args.charAt(j);
	        if (Character.isDigit(character)) {
	        	cantidad += character;
	        }
	    }
		Long num = Long.parseLong(cantidad);
		return num;
	}
}
