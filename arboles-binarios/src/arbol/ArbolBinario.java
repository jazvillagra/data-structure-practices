package arbol;


public class ArbolBinario<TipoDeDato extends Comparable<TipoDeDato>> {
	private NodoBinario<TipoDeDato> raiz;
	private int alturaNodo;
	
	public NodoBinario<TipoDeDato> getPadre(NodoBinario<TipoDeDato> nodoHijo){
		System.out.println("\nPadre del nodo "+nodoHijo.getDato());
        return privGetPadre(raiz, nodoHijo);
	}
	
    private NodoBinario<TipoDeDato> privGetPadre(NodoBinario<TipoDeDato> nodoActual, NodoBinario<TipoDeDato> nodoHijo) {
		if(nodoHijo.getDato().compareTo(nodoActual.getDato())== 0){
			nodoActual = null;
		}else if(nodoActual.getIzq()!= null && nodoHijo.getDato().compareTo(nodoActual.getIzq().getDato()) == 0){
			return nodoActual;
		}else if(nodoActual.getDer() != null && nodoHijo.getDato().compareTo(nodoActual.getDer().getDato())== 0){
			return nodoActual;
		}else if(nodoHijo.getDato().compareTo(nodoActual.getDato()) > 0){
			nodoActual=nodoActual.getDer();
			privGetPadre(nodoActual,nodoHijo);
		}else if(nodoHijo.getDato().compareTo(nodoActual.getDato()) < 0){
			nodoActual=nodoActual.getIzq();
			privGetPadre(nodoActual,nodoHijo);
		}
		return nodoActual;
	}

	public void insertar(TipoDeDato datoNuevo) {
        raiz= privInsertar(raiz, datoNuevo);
    }
	
	public NodoBinario<TipoDeDato> buscar(TipoDeDato dato) {
		return privBuscar(raiz, dato);
	}
	
	public void recorridoPreOrden() {
		System.out.println("\nImpresion del arbol pre-orden:");
        privImprimirEnOrden(raiz);
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
	
	public int getAltura(NodoBinario<TipoDeDato> nodo, TipoDeDato valor){
		System.out.println("Impresion de la altura del dato: ");
		return privGetAltura(nodo, valor);
	}
	
	public void eliminar(TipoDeDato elimin) {
        raiz = privEliminar(raiz, elimin);
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
   
    public void getGrado(TipoDeDato dato){
    	System.out.println("\nGrado de: "+dato);
    	privGetGrado(raiz,dato);  	
    }  
    public void privGetGrado(NodoBinario<TipoDeDato> actual,TipoDeDato dato){		
    	if(dato.compareTo(actual.getDato()) == 0) {
			if(actual.getDer()!=null && actual.getIzq()!=null){
				System.out.println(2);
				System.out.println("\nHijos: "+actual.getDer().getDato()+" y "+actual.getIzq().getDato());				
			}else if(actual.getDer()!=null || actual.getIzq()!=null){
				System.out.println(1);
				if(actual.getDer().getDato()==null) System.out.println("\nHijo: "+actual.getIzq().getDato());
				else System.out.println("\nHijo: "+actual.getDer().getDato());
			}else{
				System.out.println(0);
			}
		}else if(dato.compareTo(actual.getDato()) < 0){
			privGetGrado(actual.getIzq(), dato);
		}else{
			//aun no se encuentra el nodo, se busca recursivamente en cada
			//arbol hijo de izquierda a derecha
			privGetGrado(actual.getDer(), dato);
		
			//y si aun no se encontro, resta buscar en los hermanos del nodo
		}
    }  
    private int privGetAltura(NodoBinario<TipoDeDato> nodoActual, TipoDeDato valor){
		if(nodoActual!=null){
			// procesa subarbol izquierdo
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
    
	public int getTam(NodoBinario<TipoDeDato> nodoRaiz, TipoDeDato valor){
		System.out.println("Su tamanho es: ");
		return privGetTam(nodoRaiz, valor);
	}

	
	private int privGetTam(NodoBinario<TipoDeDato> nodoActual, TipoDeDato valor) {
		int cont=0;
		if (nodoActual != null) {
			// procesa subarbol izquierdo
			privGetTam(nodoActual.getIzq(), valor);
			// procesa subarbol derecho
			privGetTam(nodoActual.getDer(), valor);
			// procesa nodo
			if(nodoActual.getDato().compareTo(valor)!=0){
				cont++;
			}
		}
		return cont;
	}
    

    private int privcantidadNodosHoja(NodoBinario<TipoDeDato> nodoActual) {
    	int cant=0;
    	if (nodoActual != null) {
            if (nodoActual.izq == null && nodoActual.der == null) {
                cant++;
            }
            privcantidadNodosHoja(nodoActual.izq);
            privcantidadNodosHoja(nodoActual.der);
        }
		return cant;
    }

    public int cantidadNodosHoja() {
        int cant=privcantidadNodosHoja(raiz);
        return cant;
    }
    
    
}