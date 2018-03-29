import java.lang.annotation.Inherited;

import javax.sound.midi.Soundbank;

public class CalculoStockImpl implements CalculoStock {
	ListaEnlazada l=new ListaEnlazada();
	/**
	 * Funcion que calcula el resumen de stock de la libreria
	 * @param listaLibros es la lista de stock de libros agrupados por categoria (lista L del ejemplo enunciado)
	 * @param listaPrimerasLetras es la lista de las categorias cuyo stock se quiere calcular (lista M del ejemplo enunciado)
	 * @return retorna una lista de codigos de libros junto con la cantidad de libros existentes o 
	 *         una cadena vacia en caso que alguno de sus parametros sea null o vacio.
	 */
	@Override
	public String resumenStockLibreria(String[] listaLibros, String[] listaPrimerasLetras) {
		ListaEnlazada listaResultado = new ListaEnlazada();
		int j = 0;
		//Debe verificar si los arrays son nulos o estan vacios
		if (listaLibros == null || listaPrimerasLetras == null || listaLibros.length == 0
				|| listaPrimerasLetras.length == 0) {
			return "";
		} else {
			Long[] valores = new Long[listaPrimerasLetras.length];
			//Debe inicializar el vector valores
			for (int i = 0; i < valores.length; i++) {
				valores[i] = 0L;
			}
			//Debe cargar los elementos del array listaLibros en una lista enlazada "l"
			cargarElementos(l, listaLibros);
			//Debe cargar la cantidad de stock de cada libro en cada categoria
			for (int k = 0; k < listaPrimerasLetras.length; k++) {
				do {
					if (listaPrimerasLetras[k].equals(listaLibros[j].substring(0, 1))) {
						valores[k] = l.recuperarElemento(listaLibros[j].substring(0,1));
					}
					j++;
				} while (j < listaLibros.length);
				j = 0;
				for(int i = 0; i<valores.length; i++){
					l.agregarElemento(listaPrimerasLetras[i],valores[i]);
				}
			}
			//Debería imprimir las categorias y su correspondiente stock
			String retorno = "";
			for (int k = 0; k < valores.length; k++) {
				retorno = retorno + "(" + listaPrimerasLetras[k] + " : " + valores[k] + ") - ";
			}
			return retorno.substring(0, retorno.length() - 2);
		}
	}
	//se corta el string recibido y se saca la cantidad (de PQRST 8, se extrae 8)
	public Long extraerCantidad(String ls){
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
	//se cargan los elementos a la lista
	public void cargarElementos(ListaEnlazada L, String[] ls){

		for(int i=0; i < ls.length; i++){
			int index = ls[i].indexOf(" ");
			String str = ls[i].substring(0, 1);
			if(index > -1){
				L.agregarElemento(str,extraerCantidad(ls[i]));
			}else{
				L.agregarElemento(str, 0L);
			}
		}
	}
}
