package grafos;

import colas.Cola;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa un grafo mediante matriz de adyacencia. Por simplicidad,
 * y para ejemplificar los algoritmos, se asume las siguientes restricciones: a)
 * El tamanho del grafo esta predefinido y no varia durante la ejecucion b) Los
 * nodos o vertices tienen etiquetas numericas enteras, que van desde 0 hasta
 * TamanhoGrafo-1 c) El peso de las aristas o arcos es un numero entero d) Se
 * asume el "infinito" como el maximo entero representable por la maquina
 *
 * @author DERLISZ
 */
public class GrafoMatriz {

    /**
     * Valor que representa el valor "infinito" en el grafo
     */
    public final int INFINITO = Integer.MAX_VALUE;
    private int TAMGRAFO;
    private int[][] grafo;
    private boolean[] visitados;

    /**
     * Constructor de la clase que inicializa el grafo
     *
     * @param tamanhoGrafo Tamano del grafo
     */
    public GrafoMatriz(int tamanhoGrafo) {
        TAMGRAFO = tamanhoGrafo;
        grafo = new int[TAMGRAFO][TAMGRAFO];
        for (int i = 0; i < TAMGRAFO; i++) {
            for (int j = 0; j < TAMGRAFO; j++) {
                grafo[i][j] = INFINITO;
            }
        }

        visitados = new boolean[TAMGRAFO];
        for (int i = 0; i < TAMGRAFO; i++) {
            visitados[i] = false;
        }
    }

    /**
     * Retorna la cantidad de vertices del grafo
     *
     * @return
     */
    public int getCantidadVertices() {
        return TAMGRAFO;
    }

    /**
     * Retorna la cantidad de arcos del grafo
     *
     * @return
     */
    public int getCantidadArcos() {
        int cant = 0;

        for (int i = 0; i < TAMGRAFO; i++) {
            for (int j = 0; j < TAMGRAFO; j++) {
                if (grafo[i][j] != INFINITO) {
                    cant = cant + 1;
                }
            }
        }

        return cant;
    }

    /**
     * Funcion que permite agregar un arco al grafo
     *
     * @param orig Nodo origen
     * @param dest Nodo destino
     * @param costo Costo del arco que va del origen al destino
     */
    public void agregarArco(int orig, int dest, int costo) {
        grafo[orig][dest] = costo;
    }

    /**
     * Elimina el arco del grafo cuyo origen es orig y destino es dest
     *
     * @param orig Nodo Origen
     * @param dest Nodo Destino
     */
    public void eliminarArco(int orig, int dest) {
        grafo[orig][dest] = INFINITO;
    }

    /**
     * Imprime en pantalla el grafo que esta almacenado en memoria
     */
    public void imprimirMatrizGrafo() {
        System.out.println("Estado actual del grafo en memoria: ");
        for (int i = 0; i < TAMGRAFO; i++) {
            System.out.print("\n");
            for (int j = 0; j < TAMGRAFO; j++) {
                if (grafo[i][j] == INFINITO) {
                    System.out.print("\too");
                } else {
                    System.out.print("\t" + grafo[i][j]);
                }
            }
        }
        System.out.print("\n\n");
    }

    /**
     * Calcula el grado de entrada de un nodo del grafo
     *
     * @param nodo Nodo cuyo grado de entrada desea calcularse
     * @return
     */
    public int getGradoEntrada(int nodo) {
        int grado = 0;
        for (int j = 0; j < getCantidadVertices(); j++) {
            if (grafo[j][nodo] != INFINITO) {
                grado = grado + 1;
            }
        }
        return grado;
    }
    
    /**
     * Calcula el grado de salida de un nodo del grafo
     *
     * @param nodo Nodo cuyo grado de salida desea calcularse
     * @return
     */
    public int getGradoSalida(int nodo) {
        int grado = 0;
        for (int j = 0; j < getCantidadVertices(); j++) {
            if (grafo[nodo][j] != INFINITO) {
                grado = grado + 1;
            }
        }
        return grado;
    }
    
    /**
     * Implementa recorrido en profundidad del grafo
     */
    public void recorridoEnProfundidad() {
        for (int i = 0; i < getCantidadVertices(); i++) {
            visitados[i] = false;
        }

        System.out.print("Recorrido en profundidad del grafo: \n\t");
        for (int i = 0; i < getCantidadVertices(); i++) {
            if (visitados[i] == false) {
                privRecorridoEnProfundidad(i);
            }
        }
        System.out.print("\n\n");
    }

    private void privRecorridoEnProfundidad(int vertice) {
        //Procesa el vertice visitado
        System.out.print(" " + vertice);
        visitados[vertice] = true;

        //Procesa recursivamente cada vertice adyacente que aun no fue visitado
        for (int i = 0; i < getCantidadVertices(); i++) {
            if (grafo[vertice][i] != INFINITO && visitados[i] == false) {
                privRecorridoEnProfundidad(i);
            }
        }
    }

    /**
     * Implementa recorrido en amplitud del grafo
     * Siempre comienza el recorrido desde el primer vertice 0
     * aunque puede extenderse la solucion para que reciba este inicio como parametro
     */
    public void recorridoEnAmplitud() {
        for (int i = 0; i < getCantidadVertices(); i++) {
            visitados[i] = false;
        }

        System.out.print("Recorrido en amplitud del grafo: \n\t");
        Cola<Integer> q = new Cola<>();
        int x, v = 0;
        visitados[v] = true;
        q.encolar(v);
        System.out.print(" " + v);
        while (!q.esVacia()) {
            x = q.desencolar();                   
            for (int y = 0; y < getCantidadVertices(); y++) {
                if (grafo[x][y] != INFINITO && visitados[y] == false) {
                    visitados[y] = true;
                    q.encolar(y);
                    System.out.print(" " + y);
                }
            }
        }
        System.out.print("\n\n");
    }    
    
    /**
     * Impresion de una ordenacion topologica del grafo. La ordenacion
     * topologica solo se puede aplicar sobre Grafos Dirigidos Aciclicos (GDAs)
     * Implementa el algoritmo revisado en clase, con un array auxiliar y una
     * cola auxiliar para el recorrido
     */
    public void ordenacionTopologica() {
        //En esta variable string se almacena el orden topologico
        String topSort = "";

        //Inicializacion de vector auxiliar, con el grado de entrada de cada nodo        
        Cola<Integer> colaAux = new Cola<>();
        int[] aux = new int[getCantidadVertices()];
        for (int i = 0; i < aux.length; i++) {
            aux[i] = getGradoEntrada(i);
            if (aux[i] == 0) {
                //Inicialmente se encolan todos los nodos con grado de entrada cero
                colaAux.encolar(i);
            }
        }

        //Recorrido del grafo, se procesan los nodos de la cola hasta que quede vacia
        Integer nodoVisitado;
        while ((nodoVisitado = colaAux.desencolar()) != null) {
            //Procesamiento del nodo
            topSort = topSort + " " + nodoVisitado;

            //Procesamiento de los vertices adyacentes al nodoVisitado actualmente
            for (int i = 0; i < getCantidadVertices(); i++) {
                if (grafo[nodoVisitado][i] != INFINITO) {
                    //i es un adyacente a nodoVisitado, porque hay un arco que sale
                    //del nodoVisitado y llega hasta el nodo i

                    //Se decrementa el grado de entrada del nodo adyacente y si 
                    //luego de decrementar queda en cero, se encola el adyacente.
                    if (aux[i] > 0) {
                        aux[i] = aux[i] - 1;
                        if (aux[i] == 0) {
                            colaAux.encolar(i);
                        }
                    }
                }
            }
        }

        //La ord. topologica solo funciona para GDAs        
        //Si en algun momento nos quedamos con la cola vacia (sale del while previo)
        //y no todos los nodos fueron procesados aun, es porque hay ciclos en el grafo
        //
        //Es decir, si el array aux tiene algun vertice con grado de entrada > 0, 
        //luego de que la cola se haya vaciado, entonces en el grafo hay ciclos
        boolean hayCiclo = false;
        for (int i = 0; (i < aux.length) && !hayCiclo; i++) {
            if (aux[i] != 0) {
                hayCiclo = true;
            }
        }

        if (hayCiclo) {
            System.out.println("Ordenacion topologica del grafo:\n\tNo puede obtenerse porque el grafo tiene ciclos");
        } else {
            System.out.println("Ordenacion topologica del grafo:\n\t" + topSort + "\n");
        }
    }

    /**
     * Dijkstra calcula el costo de los caminos mas cortos entre el
     * verticeOrigen y todos los demas vertices de un grafo dirigido.
     *
     * Esta version es la implementacion del algoritmo que aparece en la Fig
     * 6.8, pag 207 del libro Estructura de Datos y Algoritmos de Aho, Hopcroft
     * y Ullman.
     *
     * S es el conjunto de vertices cuya distancia mas corta al origen ya es
     * conocida. D es el array usado para registrar la longitud del camino mas
     * corto a cada vertice. P es el array usado para registrar la ref. al nodo
     * anterior en el camino minimo.
     *
     * Por simplicidad, los conjuntos se implementan como ArrayLists. El codigo
     * puede optimizarse para hacerlo mas eficiente, se implementa asi a efectos
     * didacticos, de manera que refleje el pseudocodigo mostrado en el libro.
     *
     * @param verticeOrigen
     */
    public void dijkstra(int verticeOrigen) {

        System.out.println("Costos de ir a cada destino desde el verticeOrigen " + verticeOrigen + " segun Dijkstra: ");

        List<Integer> S = new ArrayList<Integer>();
        int[] D = new int[getCantidadVertices()];
        int[] P = new int[getCantidadVertices()];

        //V-S es la diferencia entre el conjunto de Vertices (V) y 
        //el conjunto de vertices ya procesados, usaremos el array
        //booleano visitados para saber cuales aun no fueron procesados
        for (int i = 0; i < getCantidadVertices(); i++) {
            visitados[i] = false;
            P[i] = verticeOrigen;
        }

        //Se agrega el vertice origen al conjunto S 
        //y se inicializa D para que tenga el camino mas 
        //corto conocido inicialmente, segun la configuracion del grafo
        S.add(verticeOrigen);
        visitados[verticeOrigen] = true;
        for (int i = 0; i < getCantidadVertices(); i++) {
            D[i] = grafo[verticeOrigen][i];
        }
        D[verticeOrigen] = 0;

        //Ahora se itera el resto de los vertices
        for (int i = 0; i < getCantidadVertices(); i++) {
            //elige un vertice w en V-S tal que D[w] sea un minimo
            int Dw = INFINITO;
            int w = 0;
            for (int j = 0; j < getCantidadVertices(); j++) {
                if (visitados[j] == false) {
                    if (D[j] < Dw) {
                        w = j;
                        Dw = D[j];
                    }
                }
            }

            //agrega w a S
            S.add(w);
            visitados[w] = true;

            //Por cada vertice v en V-S...
            for (int v = 0; v < getCantidadVertices(); v++) {
                if (visitados[v] == false) {
                    int A = D[v];
                    int B = 0;
                    //Este Or debemos hacerlo porque si a INFINITO le sumamos algun nro, ocurre un overflow
                    if (D[w] == INFINITO || grafo[w][v] == INFINITO) {
                        B = INFINITO;
                    } else {
                        B = D[w] + grafo[w][v];
                    }

                    //Ahora debemos elegir entre A y B el menor de los 2
                    if (A < B) {
                        D[v] = A;
                    } else {
                        D[v] = B;
                        P[v] = w;
                    }
                }
            }

            //Termina la iteracion del algoritmo, se imprime el costo de ir del origen 
            //a cada vertice destino posible en este punto    		
            System.out.print("\n\nPaso " + i);
            for (int j = 0; j < TAMGRAFO; j++) {
                System.out.print("\tD[" + j + "]");
            }
            System.out.print("\n");

            for (int j = 0; j < TAMGRAFO; j++) {
                if (D[j] == INFINITO) {
                    System.out.print("\too");
                } else {
                    System.out.print("\t" + D[j]);
                }
            }
        }

        System.out.print("\n\nPadres ");
        for (int j = 0; j < TAMGRAFO; j++) {
            System.out.print("\tP[" + j + "]");
        }
        System.out.print("\n");

        for (int j = 0; j < TAMGRAFO; j++) {
            if (P[j] == INFINITO) {
                System.out.print("\too");
            } else {
                System.out.print("\t" + P[j]);
            }
        }
    }

    /**
     * Calcula el MST (Minimum Spanning Tree) usando el algoritmo de Prim.
     *
     * Esta version es la implementacion del algoritmo que aparece en la Fig
     * 7.6, pag 235 del libro Estructura de Datos y Algoritmos de Aho, Hopcroft
     * y Ullman.
     *
     * El codigo puede optimizarse para hacerlo mas eficiente, se implementa asi
     * a efectos didacticos, de manera que refleje el pseudocodigo mostrado en
     * el libro.
     */
    public void calcularMSTPrim() {

        List<Integer> U = new ArrayList<Integer>();
        List<Integer> V = new ArrayList<Integer>();
        int verticeInicial = 0;
        int u, v, minU, minV;

        System.out.print("\n\nMST calculado con el Algoritmo de Prim:\n\t");

        //Para los conjuntos, usaremos ArrayLists
        for (int i = 0; i < getCantidadVertices(); i++) {
            V.add(new Integer(i));
        }

        //Se agrega el vertice inicial al conjunto U y se lo elimina de V               
        u = verticeInicial;
        U.add(new Integer(u));
        V.remove(new Integer(u));

        //Ahora debemos recorrer el conjunto V-U (vertices aun no agregados al MST)
        //y entre ellos, se busca la menor arista que interconete un elemento de U con un elemento de V
        u = 0;
        v = 0;
        minU = 0;
        minV = 0;
        while (V.size() > 0) {
            int minimaAristaActualConocida = INFINITO;

            for (int i = 0; i < U.size(); i++) {

                u = U.get(i);

                for (int j = 0; j < V.size(); j++) {

                    v = V.get(j);

                    //Se verifica si hay una arista que conecta i con j
                    //y si la hay, se chequea si es menor que la minimaAristaActualConocida
                    if (grafo[u][v] != INFINITO && grafo[u][v] < minimaAristaActualConocida) {
                        minU = u;
                        minV = v;
                        minimaAristaActualConocida = grafo[u][v];
                    }
                }
            }

            //En minV quedo el vertice destino a agregar al MST, la arista es u,v
            U.add(new Integer(minV));
            V.remove(new Integer(minV));
            System.out.print(" (" + minU + "," + minV + ")[" + minimaAristaActualConocida + "]");
        }

    }

    /**
     * Calcula el MST (Minimum Spanning Tree) usando el algoritmo de Kruskal.
     *
     * Esta version es la implementacion del algoritmo que aparece en la pag 237
     * del libro Estructura de Datos y Algoritmos de Aho, Hopcroft y Ullman.
     *
     * El codigo puede optimizarse para hacerlo mas eficiente, se implementa asi
     * a efectos didacticos, de manera que refleje el pseudocodigo explicado en
     * el libro.
     */
    public GrafoMatriz calcularMSTKruskal() {

        //Comienza con un nuevo grafo T, vacio de arcos, que contiene solo los vertices de V
        GrafoMatriz grafoT = new GrafoMatriz(getCantidadVertices());

        //En Kruskal, U almacenaria el conjunto de vertices ya conexos
        //y V almacenaria al conjunto de vertices aun no conexos con U
        List<Integer> U = new ArrayList<Integer>();
        List<Integer> V = new ArrayList<Integer>();
        int verticeInicial = 0;
        int u, v, minU, minV;

        //Para los conjuntos, usaremos ArrayLists
        for (int i = 0; i < getCantidadVertices(); i++) {
            V.add(new Integer(i));
        }

        //Se agrega el vertice inicial al conjunto U y se lo elimina de V               
        u = verticeInicial;
        U.add(new Integer(u));
        V.remove(new Integer(u));

        //Ahora debemos recorrer el conjunto de aristas que me interconecte un vertice de 
        //V-U (vertices aun no conexos con U) con un vertice de U (vertices del grafo ya conexo)
        //y entre ellos, se busca la menor arista para agregarla al nuevo grafo T
        //Obs: La mejor forma de hacer esto puede ser con un monticulo minimal, que almacene los arcos
        //     pero como no estudiamos esa estructura de datos ;) lo haremos en forma secuencial
        u = 0;
        v = 0;
        minU = 0;
        minV = 0;
        while (V.size() > 0) {
            int minimaAristaActualConocida = INFINITO;

            for (int i = 0; i < U.size(); i++) {

                u = U.get(i);

                for (int j = 0; j < V.size(); j++) {

                    v = V.get(j);

                    //Se verifica si hay una arista que conecta i con j
                    //y si la hay, se chequea si es menor que la minimaAristaActualConocida
                    if (grafo[u][v] != INFINITO && grafo[u][v] < minimaAristaActualConocida) {
                        minU = u;
                        minV = v;
                        minimaAristaActualConocida = grafo[u][v];
                    }
                }
            }

            //Se agrega la arista al grafo T, y el vertice V al componente de conexos
            U.add(new Integer(minV));
            V.remove(new Integer(minV));
            grafoT.agregarArco(minU, minV, minimaAristaActualConocida);
        }

        return grafoT;

    }
}