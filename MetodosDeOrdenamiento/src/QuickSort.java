
public class QuickSort {

	public static int[] quicksort(int[] array, int first, int last){
		//Elegimos el pivote
		
		int pivote=(array[first]+array[last])/2;
		int i=first;
		int j=last;
		//iteramos hasta que i no sea mayor que j
		while(i<j){
	        while (array[i] < pivote){
	            //Incrementamos el �ndice
	            i++;
	        }
	            // iteramos mientras que el valor de array[j] sea mayor que pivote
	        while (array[j] > pivote){
	          	//decrementamos el �ndice
	          	j--;
	        }
	            	//si i es menor o igual que j significa que los �ndices se han cruzado
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
	       //si 0 es menor que j mantenemos la recursividad
	       if (first< j){
	    	   array = quicksort(array, first, j);
	       }
	       //si last es mayor que i mantenemos la recursividad
	       if(array.length-1 > i){
	    	   array = quicksort(array, i, last);
	       }
	       //devolvemos la lista ordenada
		}
		
	return array;	
	}
	
	
	
	public static void main(String[] args) {
		int[] Array={2,6,4,8,4,9,1,6,45,23,87,546,7,2,56,21,12,14,1,5,89,90};
		int first=0;
		int last=Array.length-1;
		Array=quicksort(Array,first,last);
		for(int i=0;i<Array.length;i++){
			System.out.println(Array[i]);
		}
	}

}