package colas;

public class PruebaExamen {

    public static void main(String[] args) {
    	 
        Cola<Integer> cola = new Cola<>();
    	Cola<Integer> aux = new Cola<>();
    	
        
        try {
        	 //Tamano maximo de la cola
            int max_elem = 25;

            //generacion de valores aleatorios
            System.out.println("\nValores Generados");
            int[] nros = new int[max_elem];
            for (int k = 0; k < max_elem; k++) {
                nros[k] = new Integer((int) (Math.random() * 100));
                System.out.print(nros[k] + " ");
            }
            

            System.out.println("\n\nInsertando Valores Generados...");
            for (int k = 0; k < max_elem; k++) {
            	cola.encolar(nros[k]);
            	aux.encolar(nros[k]);
            }
            
            int n = cola.tamanoCola();
            
            for (int i=1; i<=n; i++) {
                System.out.println("Valor " + i + ": " + cola.desencolar());
            }
            cola.obtenerMayor(aux);
        } catch (Exception e) {
            System.out.println("Error al ejecutar el programa. " + e.getMessage());
        }
        
    }
}
