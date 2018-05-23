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
		NodoBinario<Integer> nodo = ab.buscar(4);
		if(nodo != null){
			System.out.println("Existe el valor "+nodo.getDato()+" en el arbol.\n");
			ab.getDescendientes(nodo);
			System.out.println("\n"+ab.getProfundidad(nodo.getDato())); 
			ab.getGrado(nodo.getDato()); 
		}else{
			System.out.println("No existe");
		}
		
<<<<<<< HEAD
        

        
=======
        //Imprimimos el nivel de un nodo ej el 8
        System.out.print("\n");
        System.out.println(ab.getProfundidad(8)); 
		
>>>>>>> parent of ff42a10... Se halla la altura y los descendientes de un nodo
		ab.recorridoAmplitud();
		ab.recorridoPreOrden();
		ab.recorridoEnOrden();
		ab.recorridoPostOrden();

       
	}
}
