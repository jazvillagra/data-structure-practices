
public class MainEjecutable {
	static String [] listaLibros = new String[] {"ABCDE 20", "CDFEG 50", "BXYZQ 25", "BTSQZ 89", "DFGHJ 60"};
	public static void main(String[] args){
		ListaEnlazada L = new ListaEnlazada();
		//cargar elementos de la linea de comandos a la lista
		cargarElementos(L, listaLibros);
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
	
	public static void cargarElementos(ListaEnlazada L, String[] listaLibros){
		System.out.println("Cargando Elementos");
		for(int i=0; i < listaLibros.length; i++){
			int index = listaLibros[i].indexOf(" ");
			String str = listaLibros[i].substring(0, index);
			L.agregarElemento(str,extraerCantidad(listaLibros[i]));
		}
	}
	public static Long extraerCantidad(String listaLibros){
		String cantidad = "";
		for (int j = 0; j < listaLibros.length(); j++) {
			Character character = listaLibros.charAt(j);
	        if (Character.isDigit(character)) {
	        	cantidad += character;
	        }
	    }
		Long num = Long.parseLong(cantidad);
		return num;
	}
}
