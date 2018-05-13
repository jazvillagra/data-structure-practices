package pilas;

public class Pila<TipoDeDato> implements InterfazPila<TipoDeDato> {

    private NodoPila<TipoDeDato> cabecera;
    private int tamanoPila;
    private int cantMovimientos = 0;
    
    /**
     * Constructor de la clase, se inicializa la pila
     */
    public Pila() {
        tamanoPila = 0;
        cabecera = new NodoPila<>();
        cabecera.siguiente = null;
    }
    
    public int getCantMovimientos() {
		return cantMovimientos;
	}

	public void setCantMovimientos(int cantMovimientos) {
		this.cantMovimientos = cantMovimientos+1;
	}
	
	@Override
    public void apilar(TipoDeDato nuevoDato){
    	NodoPila<TipoDeDato> nuevoNodo = new NodoPila<>();
        nuevoNodo.dato = nuevoDato;
        nuevoNodo.siguiente = cabecera.siguiente;
        cabecera.siguiente = nuevoNodo;
        tamanoPila = tamanoPila + 1;
    }
    
    @Override
    //Si se intenta desapilar algo de una lista vacia, retorna null
    public TipoDeDato desapilar(){
    	TipoDeDato ret = null;
    	if (!esVacia()) {
    	    ret = cabecera.siguiente.dato;
            cabecera.siguiente = cabecera.siguiente.siguiente;
            tamanoPila = tamanoPila - 1;
        }
        return ret;
    }
    
    @Override
    //Si se intenta obtener algo de una lista vacia, retorna null
    public TipoDeDato obtenerTope(){
    	TipoDeDato ret = null;
    	if (!esVacia()) {
    	    ret = cabecera.siguiente.dato;            
        }
        return ret;
    }
    
    @Override
    public void anular(){
    	cabecera.siguiente = null;
    	tamanoPila = 0;
    }
    
    @Override
    public int tamanoPila() {
        return tamanoPila;
    }

    @Override
    public boolean esVacia() {
        if (tamanoPila == 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * @author jvillagra, jheisecke, matiasfare
     * 
     */
	@Override
	public void reemplazar(TipoDeDato valorViejo, TipoDeDato valorNuevo) {
		TipoDeDato act = null;
		Pila<TipoDeDato> aux = new Pila<TipoDeDato>();
		try {
           while (!this.esVacia()) {
                act = this.desapilar();
                if(act.equals(valorViejo)){
                	aux.apilar(valorNuevo);
                }else{
                	aux.apilar(act);
                }
            }
            while (!aux.esVacia()){
				this.apilar(aux.desapilar());
			}
		} catch (Exception e) {
			System.out.println("Error al reemplazar los valores. " + e.getMessage());
		}
	}  
	/**
	 * @author jvillagra, jheisecke, matiasfare
	 * 
	 */
	@Override
	public void mover(int n, Pila<TipoDeDato> org, int origen, Pila<TipoDeDato> aux, int auxiliar, Pila<TipoDeDato> dest, int destino){
		TipoDeDato disco;
		if (n > 0) {
			mover(n-1, org, origen, dest, destino, aux, auxiliar);
			disco = org.desapilar();
			dest.apilar(disco);
			setCantMovimientos(cantMovimientos);
			System.out.println("Moviendo "+ disco +" de "+origen+" a "+destino);
			mover(n-1, aux, auxiliar, org, origen, dest, destino);
		}
	}
        
}

