//Author: Jazmin Villagra

public class MainEjecutable {
	static String [] listaLibros = new String[] {"ABCDE 50","ABCDE 40","ABCDE 20", "CDFEG 50", "BXYZQ 25", "BTSQZ 89", "DFGHJ 60", "PQRST 8", "PQRST 11"};
	static String [] listaPrimerasLetras = new String[] {"A", "B", "C", "W","P"};
	static CalculoStockImpl cs = new CalculoStockImpl();
	
	public static void main(String[] args){
		ListaEnlazada ListaLibros = new ListaEnlazada();
		Iterador it = ListaLibros.getIterador();
		
		//cargar elementos a ListaLibros
		cargarElementos(ListaLibros, listaLibros);
		
		//ESTO ES SOLO PARA PRUEBAS
		//Buscar elemento ingresado por linea de comandos y revisar si existe o no
		/*it = ListaLibros.getIterador();
		String libro = args[0];
		System.out.println("Buscando elemento " + libro + " en la lista de libros: ");
		Long encontrar = ListaLibros.buscarElemento(args[0]);
		if (encontrar > -1L) {
			System.out.println("\n El libro se encuentra disponible en stock. Se tienen en stock "+ListaLibros.recuperarElemento(libro)+" unidades");
		}else{
			System.out.println("El libro que busca no se encuentra disponible.\n");
		}*/
		
		System.out.print("\nLibros disponibles (titulo y cantidad disponible): {\n");
		stockDisponible(ListaLibros, it);

		System.out.print("\nCategorias disponibles: \n");
		for (int i = 0; i < listaPrimerasLetras.length; i++) {
			System.out.println(listaPrimerasLetras[i]);
		}
		System.out.println("\nClasificacion Final: ");
		
		String stock = cs.resumenStockLibreria(listaLibros, listaPrimerasLetras);
		System.out.println(stock);
	}
	//cargar elementos a ListaLibros y ListaPrimerasLetras
	public static void cargarElementos(ListaEnlazada L, String[] ls){

		for(int i=0; i < ls.length; i++){
			int index = ls[i].indexOf(" ");
			if(index > -1){
				String str = ls[i].substring(0, index);
				L.agregarElemento(str,extraerCantidad(ls[i]));
			}else{
				L.agregarElemento(ls[i], 0L);
			}
		}
	}
	//se corta el string recibido y se saca la cantidad (de PQRST 8, se extrae 8)
	public static Long extraerCantidad(String ls){
		String cantidad = "";
		for (int j = 0; j < ls.length(); j++) {
			Character character = ls.charAt(j);
	        if (Character.isDigit(character)) {
	        	cantidad += character;
	        }
	    }
		Long num = Long.parseLong(cantidad);
		return num;
	}
	//imprimir stock disponible
	public static void stockDisponible(ListaEnlazada ListaLibros, Iterador it){
		while (it.hasNext()) {
			Contenedor val = it.next();
			System.out.println(val.getClave() + " " + val.getValor());
		}
		System.out.println("}\n");
	}
}
