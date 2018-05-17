package arbol;

public class PruebaArbolBinario {
	public static void main(String [] args) {
		ArbolBinario <Integer> ab = new ArbolBinario();
		ab.insertar(6);
		ab.insertar(4);
		ab.insertar(8);
		ab.insertar(3);
		ab.insertar(1);
		NodoBinario<Integer> nodo = ab.buscar(9);
		if(nodo != null) System.out.println("Existe");
		
		ab.recorridoAmplitud();
		ab.recorridoEnOrden();
	}
}
