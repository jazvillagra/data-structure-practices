
public class MainEjecutable {
	static String [] listaLibros = new String[] {"ABCDE 40","ABCDE 20", "CDFEG 50", "BXYZQ 25", "BTSQZ 89", "DFGHJ 60"};
	static String [] listaPrimerasLetras = new String[] {"A", "B", "C", "W"};
	public static void main(String[] args){
		ListaEnlazada ListaLibros = new ListaEnlazada();
		ListaEnlazada ListaPrimerasLetras = new ListaEnlazada();
		//cargar elementos a ListaLibros
		cargarElementos(ListaLibros, listaLibros);
		//cargar elementos a ListaPrimerasLetras
		//cargarElementos(ListaPrimerasLetras, listaPrimerasLetras);
		//imprimir lista completa de libros disponibles
		System.out.print("\nLibros disponibles (titulo y cantidad disponible): {\n");
		Iterador it = ListaLibros.getIterador();
		while (it.hasNext()) {
			Contenedor val = it.next();
			System.out.println(val.getClave() + " " + val.getValor());
		}
		System.out.println("}\n");
		//buscar elemento ingresado por linea de comandos y revisar si existe o no
		it = ListaLibros.getIterador();
		String libro = args[0].substring(0,args[0].indexOf(" "));
		System.out.println("Buscando elemento " + libro + " en la lista de libros: ");
		Long encontrar = ListaLibros.recuperarElemento(args[0]);
		if (encontrar > -1L) {
			System.out.println("\n El libro se encuentra disponible en stock.");
		}else{
			System.out.println("El libro que busca no se encuentra disponible.");
		}
		//TODO: Poner aqui la rutina que lea los valores de listaLibros, listaPrimerasLetras de los argumentos del programa
		//y luego ejecute el calculo e imprima la lista resultante en pantalla
		
	}
	//cargar elementos a ListaLibros y listaPrimerasLetras
	public static void cargarElementos(ListaEnlazada L, String[] ls){

		for(int i=0; i < ls.length; i++){
			int index = ls[i].indexOf(" ");
			String str = ls[i].substring(0, index);
			L.agregarElemento(str,extraerCantidad(ls[i]));
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
}
