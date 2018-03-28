
public class MainEjecutable {
	
	public static void main(String[] args) {
		ListaEnlazada L = new ListaEnlazada();
		L.agregarElemento("ABCDE", 20L);
		L.agregarElemento("FGHIJ", 30L);
		L.agregarElemento("KLMNO", 2L);
		L.agregarElemento("KLMNO", 2L);
		L.agregarElemento("KLMNO", 2L);
		

		//imprimir lista completa
		System.out.print("\nContenido de la lista A: {");
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
}
