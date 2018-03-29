
/**
 * Interfaz a implementar para escribir el codigo de la solucion
 */
public interface CalculoStock {

	/**
	 * Funcion que calcula el resumen de stock de la libreria
	 * @param listaLibros es la lista de stock de libros agrupados por categoria (lista L del ejemplo enunciado)
	 * @param listaPrimerasLetras es la lista de las categorias cuyo stock se quiere calcular (lista M del ejemplo enunciado)
	 * @return retorna una lista de codigos de libros junto con la cantidad de libros existentes o 
	 *         una cadena vacia en caso que alguno de sus parametros sea null o vacio.
	 */
	public String resumenStockLibreria(String[] listaLibros, String[] listaPrimerasLetras);
	public Long extraerCantidad(String ls);
	
}
