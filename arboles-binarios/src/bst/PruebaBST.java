package bst;

import java.util.Scanner;

public class PruebaBST {

    /**
     * Metodo main de prueba del arbol general
     *
     * @param args
     */
    /*
     * Main para probar la clase.
     */
    public static void main(String[] argv) {
        //Tamano maximo del arbol de prueba
        int max_elem = 15;
        String resp;

        //generacion de valores aleatorios
        System.out.println("\nValores Generados");
        int[] nros = new int[max_elem];
        for (int k = 0; k < max_elem; k++) {
            nros[k] = new Integer((int) (Math.random() * 100));
            System.out.print(nros[k] + " ");
        }

        //creacion del arbol de enteros
        BST<Integer> t = new BST<>();

        System.out.println("\n\nInsertando Valores Generados...");
        for (int k = 0; k < max_elem; k++) {
            t.insertar(nros[k]);
        }

        //ordenamos el array solo para mostrar si el recorrido en orden es igual
        bubbleSort(nros);
        System.out.print("\n\nArray Ordenado\n");
        for (int k = 0; k < max_elem; k++) {
            System.out.print(nros[k] + " ");
        }

        //Imprimimos el arbol generado en orden
        System.out.print("\n");
        t.imprimirEnOrden();

        //Imprimimos el arbol generado por niveles
        System.out.print("\n");
        t.imprimirGraf();

        //buscamos algunos nros en el BST
        int abuscar = 0;
        Scanner s = new Scanner(System.in);
        while (abuscar >= 0) {
            System.out.print("\n\nIngrese valor a buscar (o nro negativo para parar): ");
            abuscar = s.nextInt();
            NodoBST<Integer> n = t.buscar(abuscar);
            if (n != null) {
                System.out.print("\n\tValor encontrado en el BST: " + n.getDato());
                System.out.println("\n\tDesea eliminar este valor del BST? (S o N): ");
                resp=s.next().toUpperCase();
                if(resp.equals("S")) {
                	t.eliminar(abuscar);
                	System.out.println("\n\tNodoEliminado. El Arbol queda de la siguiente manera:\n");
                	t.imprimirEnOrden();
                }
            } else {
                System.out.print("\n\tValor no encontrado en el BST");
            }
        }
        System.out.println("\n\nCantidad de argumentos: "+argv.length);
        
        for (int i = 0; i < argv.length; i++) {
			MedicionTiempoABB med = new MedicionTiempoABB(argv[i]);
			med.imprimirNros();
        }
    }

    public static void bubbleSort(int[] vector) {
        int i, j, t = 0;
        int n = vector.length;
        for (i = 0; i < n; i++) {
            for (j = 1; j < (n - i); j++) {
                if (vector[j - 1] > vector[j]) {
                    t = vector[j - 1];
                    vector[j - 1] = vector[j];
                    vector[j] = t;
                }
            }
        }
    }
}
