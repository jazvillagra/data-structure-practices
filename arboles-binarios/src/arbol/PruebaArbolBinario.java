package arbol;

public class PruebaArbolBinario {
	public static void main(String [] args) {
		ArbolBinario <Integer> ab = new ArbolBinario();
		
		ab.insertar(6);
		ab.insertar(4);
		ab.insertar(8);
		ab.insertar(3);
		ab.insertar(1);
		ab.insertar(10);
		ab.insertar(5);
		/*NodoBinario<Integer> nodo = ab.buscar(6);
		if(nodo != null){
			System.out.println("Existe");
		}else{
			System.out.println("No existe");
		}*/
		
		ab.recorridoAmplitud();
		ab.recorridoPreOrden();
		ab.recorridoEnOrden();
		ab.recorridoPostOrden();
	}
}
