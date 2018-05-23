package arbol;

import bst.NodoBST;

public class ArbolBinario<TipoDeDato extends Comparable<TipoDeDato>> {
	private NodoBinario raiz;
	
	public ArbolBinario() {
		raiz=null;
	}
	
	public void insertar(TipoDeDato dato) {
		raiz=privInsertar(raiz,dato);
	}
	
	public NodoBinario<TipoDeDato> buscar(TipoDeDato dato) {
		return privBuscar(raiz, dato);
	}

	public void recorridoAmplitud() {
		System.out.println("\nImpresion del arbol en amplitud");
		privRecorridoAmplitud(raiz,0);
		System.out.println();
	}
	private void privRecorridoAmplitud(NodoBinario nodoActual, int nivelNodoActual) {
		if (nodoActual != null) {
            privRecorridoAmplitud(nodoActual.getDer(), nivelNodoActual + 1);

            for (int k = 0; k < nivelNodoActual; k++) {
                System.out.print("\t");
            }
            System.out.println(nodoActual.getDato());

            privRecorridoAmplitud(nodoActual.getIzq(), nivelNodoActual + 1);
        }
	}

	public void recorridoEnOrden() {
		System.out.println("\nImpresion del arbol en-orden:");
        privImprimirEnOrden(raiz);
        System.out.println();
	}
	private void privImprimirEnOrden(NodoBinario nodoActual) {
		if (nodoActual != null) {
			// procesa subarbol izquierdo
			privImprimirEnOrden(nodoActual.getIzq());
			// procesa nodo
			System.out.print(nodoActual.dato + " ");
			// procesa subarbol derecho
			privImprimirEnOrden(nodoActual.getDer());
		}
	}

	public void eliminar(TipoDeDato elimin) {
        raiz = privEliminar(raiz, elimin);
	}
	
	private NodoBinario<TipoDeDato> privEliminar(NodoBinario<TipoDeDato> nodoActual, TipoDeDato elimin) {
		if(nodoActual==null){
			return null;
		}else if(elimin.compareTo(nodoActual.getDato()) < 0){
			//aun no se encuentra dato elimin, y como es menor que el nodoActual vamos a buscar a la izquierda
            nodoActual.setIzq(privEliminar(nodoActual.getIzq(), elimin));
        } else if (elimin.compareTo(nodoActual.getDato()) > 0) {
            //aun no se encuentra datoAEliminar, y como es mayor que el nodoActual vamos a buscar a la derecha
            nodoActual.setDer(privEliminar(nodoActual.getDer(), elimin));

        } else {
            //nodoActual es igual a elimin
            //se hace la eliminacion
            if (nodoActual.getIzq() == null) {
                //tiene solo 1 hijo derecho, sube en el arbol
                nodoActual = nodoActual.getDer();
            } else if (nodoActual.getDer() == null) {
                //tiene solo 1 hijo izquierdo, sube en el arbol
                nodoActual = nodoActual.getIzq();
            } else {
                //tiene 2 hijos, se reemplaza el nodo por el minimo de sus mayores
                nodoActual.setDato(getMinimo(nodoActual.getIzq()));
                nodoActual.setIzq(eliminarMinimo(nodoActual.getDer()));
            }
		}
		return nodoActual;
		
	}
	
	private NodoBinario privInsertar(NodoBinario<TipoDeDato> actual, TipoDeDato dato) {
		NodoBinario<TipoDeDato> nuevoNodo;
		if(actual==null) {
			nuevoNodo = new NodoBinario<>(dato);
			nuevoNodo.setDato(dato);
			return nuevoNodo;
		}else if (dato.compareTo(actual.getDato()) < 0) {
			nuevoNodo = privInsertar(actual.getIzq(), dato);
			actual.setIzq(nuevoNodo);
		}else if (dato.compareTo(actual.getDato()) > 0) {
			nuevoNodo = privInsertar(actual.getDer(), dato);
			actual.setDer(nuevoNodo);
		}
		return actual;
	}

	private NodoBinario<TipoDeDato> privBuscar(NodoBinario<TipoDeDato> N, TipoDeDato x) {
		if(N==null) {
			return null;
		}
		if (N.getDato().compareTo(x) == 0) {
			return N;
		}else if (N.getDato().compareTo(x) > 0) {
			return privBuscar(N.getIzq(), x);
		}else {
			return privBuscar(N.getDer(), x);
		}
	}
	
	
	//Metodo que hace falta arreglar para poder implementar, retorna la profunidad del nodo
	public int maxDepth(NodoBinario<TipoDeDato> node){
		if (node == null) {
			return 0;
		} else {
			/* compute the depth of each subtree */
			int lDepth = maxDepth(node.getIzq());
			int rDepth = maxDepth(node.getDer());

			/* use the larger one */
			if (lDepth > rDepth) {
				return (lDepth + 1);
			} else {
				return (rDepth + 1);
			}
		}
	}

    public TipoDeDato getMinimo(NodoBinario<TipoDeDato> nodoActual) {
        if (nodoActual == null) {
            return null;

        } else if (nodoActual.getIzq() == null) {
            return nodoActual.getDato();

        } else {
            return getMinimo(nodoActual.getIzq());

        }
    }
    private NodoBinario<TipoDeDato> eliminarMinimo(NodoBinario<TipoDeDato> nodoActual) {
        if (nodoActual == null) {
            return null;

        } else if (nodoActual.getIzq() == null) {
            return nodoActual.getDer();

        } else {
            nodoActual.setIzq(eliminarMinimo(nodoActual.getIzq()));
            return nodoActual;

        }
    }
}