/*
 * public class ArbolBinario {

    NodoArbol raiz;
    int cant;
    int altura;


    public ArbolBinario() {
        raiz = null;
    }

    public void Insertar(int d) {
        NodoArbol nuevo = new NodoArbol(d);
        if (raiz == null) {
            raiz = nuevo;
        } else {
            NodoArbol auxiliar = raiz;
            NodoArbol padre;
            while (true) {
                padre = auxiliar;
                if (d < auxiliar.dato) {
                    auxiliar = auxiliar.izq;

                    if (auxiliar == null) {
                        padre.izq = nuevo;

                        return;
                    }
                } else {
                    auxiliar = auxiliar.der;
                    if (auxiliar == null) {
                        padre.der = nuevo;
                        return;
                    }
                }
            }
        }

    }

    public boolean Vacio() {
        return raiz == null;
    }

    public void InOrden(NodoArbol r) {
    	int i=0;
        if (r != null) {
            InOrden(r.izq);
            System.out.print(r.dato + ",");
            InOrden(r.der);
            
        }
    }

    public void PreOrden(NodoArbol r) {
        if (r != null) {
            System.out.print(r.dato + ",");
            PreOrden(r.izq);
            PreOrden(r.der);
        }
    }

    public void PostOrden(NodoArbol r) {
        if (r != null) {
            PostOrden(r.izq);
            PostOrden(r.der);
            System.out.print(r.dato + ",");
        }
    }

    public NodoArbol BuscarNodo(int d) {
        NodoArbol aux = raiz;
        while (aux.dato != d) {
            if (d < aux.dato) {
                aux = aux.izq;
            } else {
                aux = aux.der;
            }
            if (aux == null) {
                return null;
            }
        }
        return aux;
    }

    public boolean existe(int info) {
        NodoArbol reco = raiz;
        while (reco != null) {
            if (info == reco.dato) {
                return true;
            } else if (info > reco.dato) {
                reco = reco.der;
            } else {
                reco = reco.izq;
            }
        }
        return false;
    }

    private void cantidadNodosHoja(NodoArbol reco) {
        if (reco != null) {
            if (reco.izq == null && reco.der == null) {
                cant++;
            }
            cantidadNodosHoja(reco.izq);
            cantidadNodosHoja(reco.der);
        }
    }

    public int cantidadNodosHoja() {
        cant = 0;
        cantidadNodosHoja(raiz);
        return cant;
    }

    public int retornarAltura() {
        altura = 0;
        retornarAltura(raiz, 1);
        return altura;
    }

    private void retornarAltura(NodoArbol reco, int nivel) {
        if (reco != null) {
            retornarAltura(reco.izq, nivel + 1);
            if (nivel > altura) {
                altura = nivel;
            }
            retornarAltura(reco.der, nivel + 1);
        }
    }
    
    public void menorValor() {
        if (raiz != null) {
            NodoArbol reco = raiz;
            while (reco.izq != null) {
                reco = reco.izq;
            }
            System.out.println("Menor valor del árbol:" + reco.dato);
        }
    }

    public void mayorValor() {
        if (raiz != null) {
            NodoArbol reco = raiz;
            while (reco.der != null) {
                reco = reco.der;
            }
            System.out.println("Mayor valor del árbol:" + reco.dato);
        }
    }

    int subizq = 0;
    int subder = 0;

    public void imprimirBalance() {
        subizq = 0;
        subder = 0;

        Balance(this.raiz, true, 0);
        System.out.println("lado Izquierdo " + subizq + " Lado Derecho " + subder);
        if (subizq - subder == 0) {
            System.out.println("El balance es: 0 ");
        } else if (subizq - subder == -1) {
            System.out.println("El balance es -1, derecha");
        } else if (subizq - subder == 1) {
            System.out.println("El balance 1, izquierda");

        } else {
            System.out.println("No es balanceado.."
                    + "porque es mas grande el lado "
                    + ((subizq > subder) ? "Izquierdo" : "Derecho"));
        }

    }

    public void Balance(NodoArbol reco, boolean lado, int i) {

        if (reco != null) {

            if (reco.der == null && reco.izq == null) {
                if (lado) {
                    subder = (i > subder) ? i : subder;
                } else {
                    subizq = (i > subizq) ? i : subizq;
                }
            }

            Balance(reco.der, lado, i + 1);
            if (i == 0) {
                lado = false;
            }
            Balance(reco.izq, lado, i + 1);
        }

    }

    //altura arbol
    String[] niveles;


    public void imprimirNivel() {
        niveles = new String[altura + 1];

        imprimirNivel(raiz, 0);
        for (int i = 0; i < niveles.length; i++) {
            System.out.println(niveles[i] + " En nivel: " + i);
        }
    }

    private void imprimirNivel(NodoArbol pivote, int nivel2) {
        if (pivote != null) {
            niveles[nivel2] = pivote.dato + ", " + ((niveles[nivel2] != null) ? niveles[nivel2] : "");
            imprimirNivel(pivote.der, nivel2 + 1);
            imprimirNivel(pivote.izq, nivel2 + 1);
        }
    }

    public void imprimirAlturaDeCadaNodo() {
        imprimirAlturaDeCadaNodo(raiz, 1);

    }

    private void imprimirAlturaDeCadaNodo(NodoArbol reco, int nivel) {
        if (reco != null) {
            System.out.println("Nodo contiene: " + reco.dato + " y su altura es: " + nivel);
            imprimirAlturaDeCadaNodo(reco.izq, nivel + 1);
            imprimirAlturaDeCadaNodo(reco.der, nivel + 1);
        }
    }
    
    

    public boolean Eliminar(int d) {
        NodoArbol auxiliar = raiz;
        NodoArbol padre = raiz;
        boolean hijoizq = true;
        while (auxiliar.dato != d) {
            padre = auxiliar;
            if (d < auxiliar.dato) {
                hijoizq = true;
                auxiliar = auxiliar.izq;
            } else {
                hijoizq = false;
                auxiliar = auxiliar.der;
            }
            if (auxiliar == null) {
                return false;
            }
        }//si es hoja 
        if (auxiliar.izq == null && auxiliar.der == null) {
            if (auxiliar == raiz) {
                raiz = null;
            } else if (hijoizq) {
                padre.izq = null;
            } else {
                padre.der = null;
            }
        } else if (auxiliar.der == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.izq;
            } else if (hijoizq) {
                padre.izq = auxiliar.izq;
            } else {
                padre.der = auxiliar.izq;
            }
        } else if (auxiliar.izq == null) {
            if (auxiliar == raiz) {
                raiz = auxiliar.der;
            } else if (hijoizq) {
                padre.izq = auxiliar.der;
            } else {
                padre.der = auxiliar.der;
            }// es la raiz
        } else {
            NodoArbol reemplazo = ObtenerReemplazo(auxiliar);
            if (auxiliar == raiz) {
                raiz = reemplazo;
            } else if (hijoizq) {
                padre.izq = reemplazo;
            } else {
                padre.der = reemplazo;
            }
            reemplazo.izq = auxiliar.izq;
        }
        return true;
    }

    public NodoArbol ObtenerReemplazo(NodoArbol nodoreemplazo) {
        NodoArbol reemplazarpadre = nodoreemplazo;
        NodoArbol reemplazo = nodoreemplazo;
        NodoArbol auxiliar = nodoreemplazo.der;
        while (auxiliar != null) {
            reemplazarpadre = reemplazo;
            reemplazo = auxiliar;
            auxiliar = auxiliar.izq;
        }
        if (reemplazo != nodoreemplazo.der) {
            reemplazarpadre.izq = reemplazo.der;
            reemplazo.der = nodoreemplazo.der;
        }
        System.out.println("El Nodo Reemplazo es:" + reemplazo);
        return reemplazo;
    }

    public int cantidadNodos() {
        cant = 0;
        cantidad(raiz);
        return cant;
    }

    private void cantidad(NodoArbol reco) {
        if (reco != null) {
            cant++;
            cantidad(reco.izq);
            cantidad(reco.der);
        }
    }

    public NodoArbol Raiz() {
        return raiz;
    }
    
    public boolean Soniguales(NodoArbol a, NodoArbol b) {
    	if(a!= null && b!=null) {
    	if(a.dato!=b.dato) {
    		return false;
    	} 		
    	}
   		return Soniguales(a.izq, b.izq)&& Soniguales(a.der, b.der);
    	
    }
*/ 