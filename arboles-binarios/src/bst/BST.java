package bst;

/**
 * Implementa la clase BST (Arbol Binario de Busqueda o Binary Search Tree) El
 * dato cuya referencia se almacena en cada nodo es un Comparable o derivado.
 * Las rutinas privXXX son de apoyo, para simplificar la implementacion. En este
 * BST se asume que no se permiten elementos duplicados
 */
public class BST<TipoDeDato extends Comparable<TipoDeDato>> {

    private NodoBST<TipoDeDato> raiz;    

    /**
     * Metodo que permite agregar un elemento al BST.
     *
     * @param datoNuevo Dato a agregar al BST.
     */
    public void insertar(TipoDeDato datoNuevo) {
        raiz = privInsertar(raiz, datoNuevo);
    }

    private NodoBST<TipoDeDato> privInsertar(NodoBST<TipoDeDato> nodoActual, TipoDeDato datoNuevo) {

        NodoBST<TipoDeDato> nuevoNodo;

        if (nodoActual == null) {
            //ya llegamos a la hoja donde debe estar el nuevo valor
            //se crea el nuevo nodo y se retorna la referencia
            nuevoNodo = new NodoBST<>(datoNuevo);
            nodoActual = nuevoNodo;
            //return nuevoNodo;

        } else if (datoNuevo.compareTo(nodoActual.getDato()) < 0) {
            //dato a insertar es menor que el nodo actual
            //continua la insercion por la rama izquierda y se recibe
            //como resultado la referencia al nuevo subarbol izquierdo
            nuevoNodo = privInsertar(nodoActual.hijoIzquierdo, datoNuevo);
            nodoActual.hijoIzquierdo = nuevoNodo;

        } else if (datoNuevo.compareTo(nodoActual.getDato()) > 0) {
            //dato a insertar es mayor que el nodo actual
            //continua la insercion por la rama derecha y se recibe
            //como resultado la referencia al nuevo subarbol derecho
            nuevoNodo = privInsertar(nodoActual.hijoDerecho, datoNuevo);
            nodoActual.hijoDerecho = nuevoNodo;

        } else {
            //dato a insertar es igual a un nodo ya existente
            //no se hace nada, solo un warning
            System.out.println("\tAdvertencia: No se permiten repetidos en este BST! El valor " + datoNuevo + " ya existe.");
        }

        //se retorna la referencia al nodo actualmente visitado
        //esto se hace para actualizar las referencias hacia arriba 
        return nodoActual;
    }

    /**
     * Retorna el "nodo" donde se encuentra el primer datoBuscado que dice ser igual a
     * parametro dado.
     *
     * @param datoBuscado Dato a buscar en el BST
     * @return Retorna el NodoBST encontrado, o null si no existe en el BST el
     * elemento buscado
     */
    public NodoBST<TipoDeDato> buscar(TipoDeDato datoBuscado) {
        return (privBuscar(raiz, datoBuscado));
    }

    private NodoBST<TipoDeDato> privBuscar(NodoBST<TipoDeDato> nodoActual, TipoDeDato datoBuscado) {
        if (nodoActual == null) {
            return null;
        }

        if (datoBuscado.compareTo(nodoActual.getDato()) == 0) {
            //el datoBuscado es igual al almacenado en el nodo actual
            return nodoActual;

        } else if (datoBuscado.compareTo(nodoActual.getDato()) < 0) {
            //el datoBuscado es menor que el nodo actual, seguimos la busqueda a la izquierda
            return privBuscar(nodoActual.hijoIzquierdo, datoBuscado);

        } else {
            //el datoBuscado es mayor o igual que el nodo actual, seguimos la busqueda a la derecha
            return privBuscar(nodoActual.hijoDerecho, datoBuscado);
        }
    }
    
    /**
     * Metodo que permite eliminar un elemento al BST.
     */
    public void eliminar(TipoDeDato datoAEliminar) {
        raiz = privEliminar(raiz, datoAEliminar);
    }    

    private NodoBST<TipoDeDato> privEliminar(NodoBST<TipoDeDato> nodoActual, TipoDeDato datoAEliminar) {

        if (nodoActual == null) {
            return null;

        } else if (datoAEliminar.compareTo(nodoActual.getDato()) < 0) {
            //aun no se encuentra datoAEliminar, y como es menor que el nodoActual vamos a buscar a la izquierda
            nodoActual.hijoIzquierdo = privEliminar(nodoActual.hijoIzquierdo, datoAEliminar);

        } else if (datoAEliminar.compareTo(nodoActual.getDato()) > 0) {
            //aun no se encuentra datoAEliminar, y como es mayor que el nodoActual vamos a buscar a la derecha
            nodoActual.hijoDerecho = privEliminar(nodoActual.hijoDerecho, datoAEliminar);

        } else {
            //nodoActual es igual a datoAEliminar
            //se hace la eliminacion
            if (nodoActual.hijoIzquierdo == null) {
                //tiene solo 1 hijo derecho, sube en el arbol
                nodoActual = nodoActual.hijoDerecho;
            } else if (nodoActual.hijoDerecho == null) {
                //tiene solo 1 hijo izquierdo, sube en el arbol
                nodoActual = nodoActual.hijoIzquierdo;
            } else {
                //tiene 2 hijos, se reemplaza el nodo por el minimo de sus mayores
                nodoActual.dato = getMinimo(nodoActual.hijoDerecho);
                nodoActual.hijoDerecho = eliminarMinimo(nodoActual.hijoDerecho);
            }

            return nodoActual;
        }

        //se retorna la referencia al nodo actualmente visitado
        //esto se hace para actualizar las referencias hacia arriba 
        return nodoActual;
    }
    
    /**
     * Retorna el valor del elemento minimo del arbol con raiz nodoActual
     *
     * @return
     */
    public TipoDeDato getMinimo(NodoBST<TipoDeDato> nodoActual) {
        if (nodoActual == null) {
            return null;

        } else if (nodoActual.hijoIzquierdo == null) {
            return nodoActual.dato;

        } else {
            return getMinimo(nodoActual.hijoIzquierdo);

        }
    }

    /**
     * Elimina el nodo que contiene el elemento minimo del arbol con raiz
     * nodoActual
     *
     * @return
     */
    private NodoBST<TipoDeDato> eliminarMinimo(NodoBST<TipoDeDato> nodoActual) {
        if (nodoActual == null) {
            return null;

        } else if (nodoActual.hijoIzquierdo == null) {
            return nodoActual.hijoDerecho;

        } else {
            nodoActual.hijoIzquierdo = eliminarMinimo(nodoActual.hijoIzquierdo);
            return nodoActual;

        }
    }

    /**
     * Imprime el arbol en recorrido enorden o infijo.
     */
    public void imprimirEnOrden() {
        System.out.println("\nImpresion del BST en-orden:");
        privImprimirEnOrden(raiz);
        System.out.println();
    }

    private void privImprimirEnOrden(NodoBST<TipoDeDato> nodoActual) {
        if (nodoActual != null) {
            //procesa subarbol izquierdo
            privImprimirEnOrden(nodoActual.hijoIzquierdo);

            //procesa nodo
            System.out.print(nodoActual.dato + " ");

            //procesa subarbol derecho
            privImprimirEnOrden(nodoActual.hijoDerecho);
        }
    }

    /**
     * Imprime el arbol "graficamente", dejando la raiz en la columna 1 (nivel
     * 0), el nivel 1 en la tercera columna, etc.
     */
    public void imprimirGraf() {
        System.out.println("\nImpresion del BST graficamente:");
        privImprimirGraf(raiz, 0);
        System.out.println();
    }

    private void privImprimirGraf(NodoBST<TipoDeDato> nodoActual, int nivelNodoActual) {
        if (nodoActual != null) {
            privImprimirGraf(nodoActual.hijoDerecho, nivelNodoActual + 1);

            for (int k = 0; k < nivelNodoActual; k++) {
                System.out.print("\t");
            }
            System.out.println(nodoActual.dato);

            privImprimirGraf(nodoActual.hijoIzquierdo, nivelNodoActual + 1);
        }
    }
}