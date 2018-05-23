package arbol;

import bst.NodoBST;

public class ArbolBinario<TipoDeDato extends Comparable<TipoDeDato>> {
	private NodoBinario<TipoDeDato> raiz;
	private int alturaNodo;

    public void insertar(TipoDeDato datoNuevo) {
        raiz= privInsertar(raiz, datoNuevo);
    }
	
	public NodoBinario<TipoDeDato> buscar(TipoDeDato dato) {
		return privBuscar(raiz, dato);
	}
	
	public void recorridoPreOrden() {
		System.out.println("\nImpresion del arbol pre-orden:");
        privImprimirPreOrden(raiz);
        System.out.println();
	}

	public void recorridoEnOrden() {
		System.out.println("\nImpresion del arbol en-orden:");
        privImprimirEnOrden(raiz);
        System.out.println();
	}
	
	public void recorridoPostOrden() {
		System.out.println("\nImpresion del arbol post-orden:");
        privImprimirPostOrden(raiz);
        System.out.println();
	}

	public void recorridoAmplitud() {
		System.out.println("\nImpresion del arbol en amplitud");
		privRecorridoAmplitud(raiz,0);
		System.out.println();
	}

	public void eliminar(TipoDeDato elimin) {
        raiz = privEliminar(raiz, elimin);
	}
	
	public int getAltura(NodoBinario<TipoDeDato> nodo, TipoDeDato valor){
		System.out.println("Impresion del nivel del dato: ");
		return privGetAltura(nodo, valor);
	}
	
	public void getDescendientes(NodoBinario<TipoDeDato> nodoRaiz, TipoDeDato valor){
		System.out.println("Sus descendientes son: ");
		privGetDescendientes(nodoRaiz, valor);
	}
	private void privGetDescendientes(NodoBinario<TipoDeDato> nodoActual, TipoDeDato valor) {
		
		if (nodoActual != null) {
			// procesa subarbol izquierdo
			privGetDescendientes(nodoActual.getIzq(), valor);
			// procesa subarbol derecho
			privGetDescendientes(nodoActual.getDer(), valor);
			// procesa nodo
			if(nodoActual.getDato().compareTo(valor)!=0){
				System.out.print(nodoActual.dato + " ");
			}
		}
	}

	//recorre e imprime el arbol utilizando el recorrido pre-orden
	private void privImprimirPreOrden(NodoBinario nodoActual) {
		if (nodoActual != null) {
			// procesa nodo
			System.out.print(nodoActual.dato + " ");
			// procesa subarbol izquierdo
			privImprimirPreOrden(nodoActual.getIzq());
			// procesa subarbol derecho
			privImprimirPreOrden(nodoActual.getDer());
		}
	}
	
	//recorre e imprime el arbol en orden 
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
	
	//recorre e imprime el arbol utilizando el recorrido post-orden
	private void privImprimirPostOrden(NodoBinario nodoActual) {
		if (nodoActual != null) {
			// procesa subarbol izquierdo
			privImprimirPostOrden(nodoActual.getIzq());
			// procesa subarbol derecho
			privImprimirPostOrden(nodoActual.getDer());
			// procesa nodo
			System.out.print(nodoActual.dato + " ");
		}
	}

	// recorre e imprime el arbol por amplitud (por niveles)
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
	
	//elimina el nodo que contiene el dato ingresado por el usuario en PruebaArbolBinario
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
	//inserta un nuevo nodo al arbol binario
	private NodoBinario<TipoDeDato> privInsertar(NodoBinario<TipoDeDato> actual, TipoDeDato datoNuevo) {
		
		NodoBinario<TipoDeDato> nuevoNodo;

        if (actual == null) {
            //ya llegamos a la hoja donde debe estar el nuevo valor, entonces se crea el nuevo nodo y se retorna la referencia
            nuevoNodo = new NodoBinario<TipoDeDato>(datoNuevo);
            return nuevoNodo;

        } else if (datoNuevo.compareTo(actual.getDato()) < 0) {
            //dato a insertar es menor que el nodo actual. Continua la insercion por la rama izquierda y se recibe como resultado la referencia al nuevo subarbol izquierdo
            nuevoNodo = privInsertar(actual.getIzq(), datoNuevo);
            actual.setIzq(nuevoNodo);

        } else if (datoNuevo.compareTo(actual.getDato()) > 0) {
            //dato a insertar es mayor que el nodo actual. Continua la insercion por la rama derecha y se recibe como resultado la referencia al nuevo subarbol derecho
            nuevoNodo = privInsertar(actual.getDer(), datoNuevo);
            actual.setDer(nuevoNodo);

        } else {
            //dato a insertar es igual a un nodo ya existente no se hace nada, solo un warning
            System.out.println("\tAdvertencia: No se permiten repetidos en este BST! El valor " + datoNuevo + " ya existe.");
        }

        //se retorna la referencia al nodo actualmente visitado. Esto se hace para actualizar las referencias hacia arriba 
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
    
    public int getProfundidad(TipoDeDato dato){
    	System.out.println("\nImpresion del nivel del dato: "+dato);
    		return privgetProfundidad(raiz,dato,0);  	
    }   
    
    
    public int privgetProfundidad(NodoBinario<TipoDeDato> visitado,TipoDeDato dato,int nivel){
		int resp=0;
		
		if(visitado==null){
			return resp;
		}else if(dato.compareTo(visitado.getDato()) == 0) {
			//encontramos el nodo
			resp=nivel;
		}else if(dato.compareTo(visitado.getDato()) < 0){
			nivel=nivel+1;
			resp=privgetProfundidad(visitado.getIzq(), dato, nivel++);
		}else{
			//aun no se encuentra el nodo, se busca recursivamente en cada
			//arbol hijo de izquierda a derecha
			nivel=nivel+1;
			resp= privgetProfundidad(visitado.getDer(), dato, nivel++);
		
			//y si aun no se encontro, resta buscar en los hermanos del nodo
		}
		return resp;
    }    
    private int privGetAltura(NodoBinario<TipoDeDato> nodoActual, TipoDeDato valor){
		if(nodoActual!=null){// procesa subarbol izquierdo
			privGetAltura(nodoActual.getIzq(), valor);
			// procesa subarbol derecho
			privGetAltura(nodoActual.getDer(), valor);
			// procesa nodo
			if (nodoActual.getDato().compareTo(valor) != 0) {
				alturaNodo++;
			}
		}
		return alturaNodo;
    }
    
}