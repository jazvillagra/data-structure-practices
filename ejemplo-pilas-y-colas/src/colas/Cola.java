package colas;

public class Cola<TipoDeDato extends Comparable<TipoDeDato>> implements java.lang.Comparable<TipoDeDato>, InterfazCola<TipoDeDato> {

    private NodoCola<TipoDeDato> iniCola;
    private NodoCola<TipoDeDato> finCola;
    private int tamanoCola;

    /**
     * Constructor de la clase, se inicializa la cola
     */
    public Cola() {
        tamanoCola = 0;
        iniCola = null;
        finCola = null;
    }

    @Override
    public void encolar(TipoDeDato nuevoDato) {
        NodoCola<TipoDeDato> nuevoNodo = new NodoCola<>();
        nuevoNodo.dato = nuevoDato;
        nuevoNodo.siguiente = null;

        if (esVacia()) {
            iniCola = nuevoNodo;
            finCola = nuevoNodo;
        } else {
            finCola.siguiente = nuevoNodo;
            finCola = nuevoNodo;
        }
        tamanoCola = tamanoCola + 1;

    }

    @Override
    public TipoDeDato desencolar() {
        TipoDeDato ret = null;
        if (!esVacia()) {
            ret = iniCola.dato;
            iniCola = iniCola.siguiente;
            tamanoCola = tamanoCola - 1;
        }
        return ret;
    }

    @Override
    public int tamanoCola() {
        return tamanoCola;
    }

    @Override
    public boolean esVacia() {
        if (tamanoCola == 0) {
            return true;
        } else {
            return false;
        }
    }
    @Override
    public void obtenerMayor(Cola<TipoDeDato> aux){
    	TipoDeDato mayor=null;
    	int pos=0;
    	int posMayor= 1;
    	TipoDeDato elem;
    	while(!aux.esVacia()){
			elem=aux.desencolar();
			pos++;
			if(mayor == null){
				mayor=elem;
			}else if(elem.compareTo(mayor)>0){
				mayor=elem;
				posMayor=pos;
			}
		}
    	System.out.println("El mayor elemento es "+mayor+" en la posicion "+posMayor);
    }

	@Override
	public int compareTo(TipoDeDato o) {
		return 0;
	}

}
