package pilas;

public class PruebaPilaReemplazar {

	public static void main(String[] args) {
		Pila<Integer> pila = new Pila<>();
        Pila<String> pilaStr = new Pila<>();
        
        try {
        	//test de metodo de reemplazo con pila de enteros
            pila.apilar(1);
            pila.apilar(2);
            pila.apilar(3);
            pila.reemplazar(1,4);
            System.out.println("\nLa lista con el valor reemplazado es: ");
            while (!pila.esVacia()) {
                System.out.println("Valor : " + pila.desapilar());
            }
            
        	//test de metodo de reemplazo con pila de strings
            pilaStr.apilar("a");
            pilaStr.apilar("b");
            pilaStr.apilar("c");
            pilaStr.reemplazar("a","d");
            System.out.println("\nLa lista con el valor reemplazado es: ");
            while (!pilaStr.esVacia()) {
                System.out.println("Valor : " + pilaStr.desapilar());
            }
        } catch (Exception e) {
            System.out.println("Error al ejecutar el programa. " + e.getMessage());
        }

	}

}
