package arbol;

public class pruebaExamen {

	public static void main(String[] args) {ArbolBinario <Integer> ab = new ArbolBinario<Integer>();

		ab.insertar(6);
		ab.insertar(4);
		ab.insertar(8);
		ab.insertar(3);
		ab.insertar(1);
		ab.insertar(10);
		ab.insertar(5);
		ab.insertar(9);
		System.out.println("El arbol queda finalmente asi: ");
		ab.recorridoAmplitud();
		System.out.println("SE BUSCARA EL VALOR 10 EN EL ARBOL.");
		NodoBinario<Integer> nodo = ab.buscar(10);
		if (nodo != null) {
			System.out.println("Existe el valor " + nodo.getDato() + " en el arbol.\n");
			System.out.println(ab.getPadre(nodo).getDato());
		} else {
			System.out.println("No existe");
		}
	}
}
