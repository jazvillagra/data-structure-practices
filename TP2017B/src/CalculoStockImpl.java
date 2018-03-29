import java.lang.annotation.Inherited;

public class CalculoStockImpl implements CalculoStock {
	
	/**
	 * Funcion que calcula el resumen de stock de la libreria
	 * @param listaLibros es la lista de stock de libros agrupados por categoria (lista L del ejemplo enunciado)
	 * @param listaPrimerasLetras es la lista de las categorias cuyo stock se quiere calcular (lista M del ejemplo enunciado)
	 * @return retorna una lista de codigos de libros junto con la cantidad de libros existentes o 
	 *         una cadena vacia en caso que alguno de sus parametros sea null o vacio.
	 */
	@Override
	public String resumenStockLibreria(String[] listaLibros, String[] listaPrimerasLetras) {
		ListaEnlazada aux = new ListaEnlazada();
		NodoListaEnlazada cabecera = new NodoListaEnlazada(null, null);
		//TODO: implementar solucion en este metodo.
		//debe usar una instancia de ListaEnlazada.java
		NodoListaEnlazada act = cabecera;
		int i = 0;
		while(act.getSiguienteElemento() != null){
			while (act.getSiguienteElemento() != null) {
				i++;
				act = act.getSiguienteElemento();
				//if (act.getDato().getClave().equals(clave)) {
					
				//}
			}
			
		}
		return "";
	}

}
