
public class QuickSort {

	public static int[] quicksort(int[] array, int first, int last){
		//Elegimos el pivote	
		int pivote=(array[first]+array[last])/2;
		int i=first;
		int j=last;
		//iteramos hasta que i no sea mayor que j
		while(i<j){
			while (array[i] < pivote){
	            //Incrementamos el índice
	            i++;
	        }
	            // iteramos mientras que el valor de array[j] sea mayor que pivote
	        while (array[j] > pivote){
	          	//decrementamos el índice
	          	j--;
	        }
	            	//si i es menor o igual que j significa que los índices se han cruzado
	        if(i <= j){
	      		//creamos una variable temporal para guardar el valor de array[j]
	        	int x = array[j];
	      		//intercambiamos los valores de array[j] y array[i]
	      		array[j] = array[i];
	      		array[i] = x;
	      		//incrementamos y decrementamos i y j respectivamente
	       		i++;
	       		j--;
	      	}
	       //si first es menor que j mantenemos la recursividad
	       if (first< j){
	    	   array = quicksort(array, first, j);
	       }
	       //si last es mayor que i mantenemos la recursividad
	       if(last > i){
	    	   array = quicksort(array, i, last);
	       }
	       //devolvemos la lista ordenada
		}
		System.out.println("\nCon pivote: "+pivote);
		for(int f=0;f<array.length;f++){
			System.out.print(array[f]+"\t");
		}	
	return array;	
	}
	
	
	
	public static void main(String[] args) {
		int[] Array={58,98,95,29,16,56,8,52,89,96,63};
		for(int i=0;i<Array.length;i++){
			System.out.print(Array[i]+"\t");
		}
		int first=0;
		int last=Array.length-1;
		Array=quicksort(Array,first,last);
	}

}
