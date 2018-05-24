package arbol;

public class PruebaArbolBinario {
	public static void main(String [] args) {
		ArbolBinario <Integer> ab = new ArbolBinario<Integer>();
		
		ab.insertar(6);
		ab.insertar(4);
		ab.insertar(8);
		ab.insertar(3);
		ab.insertar(1);
		ab.insertar(10);
		ab.insertar(5);
		ab.insertar(9);
		NodoBinario<Integer> nodo = ab.buscar(10);
		if(nodo != null){
			System.out.println("Existe el valor "+nodo.getDato()+" en el arbol.\n");
			ab.getDescendientes(nodo, nodo.getDato());
			System.out.println("\n"+ab.getProfundidad(nodo.getDato())); 
			//ab.getGrado(nodo.getDato()); 
			System.out.println("\n");
			System.out.println(ab.getAltura(nodo, 4));
			System.out.println(ab.getTam(nodo,4)); 
		}else{
			System.out.println("No existe");
		}
        //Imprimimos el nivel de un nodo ej el 8
        System.out.print("\n");
        
		
		ab.recorridoAmplitud();
		ab.recorridoPreOrden();
		ab.recorridoEnOrden();
		ab.recorridoPostOrden();
		System.out.println(ab.getPadre(nodo).getDato());
	}
}
