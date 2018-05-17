package bst;

import java.awt.image.AreaAveragingScaleFilter;

public class MedicionTiempoABB {
	
    int max;
    BST <Integer> arbol = new BST<>();
    int[] numeros;
    
    public MedicionTiempoABB(String maximo) {
    	//al crear el objeto, le asigna un valor a max (obtenido de los argumentos del programa)
		max = Integer.parseInt(maximo);
		//declara el array con su extension (max0)
		numeros= new int[max];
		//genera los nros aleatorios
		for (int k = 0; k < max; k++) {
			numeros[k] = new Integer((int) (Math.random() * max));
		}
    }
    
    public void imprimirNros() {

        System.out.println("\n\tLos valores generados son:");
        
        for (int i = 0; i < numeros.length; i++) {
			System.out.print(numeros[i]+" ");
			arbol.insertar(numeros[i]);
		}
        
        arbol.imprimirEnOrden();
    }

}