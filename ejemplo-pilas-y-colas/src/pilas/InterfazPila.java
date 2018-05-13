package pilas;

public interface InterfazPila<TipoDeDato> {
        
    public void apilar(TipoDeDato dato);
    
    public TipoDeDato desapilar();
    
    public TipoDeDato obtenerTope();
    
    public void anular();
    
    public int tamanoPila();
        
    public boolean esVacia();
    
    /**
     * @author jvillagra, jheisecke, matiasfare
     * 
     */
    public void reemplazar(TipoDeDato valorViejo, TipoDeDato valorNuevo);

	void mover(int n, Pila<TipoDeDato> org, int origen, Pila<TipoDeDato> aux, int auxiliar,
			Pila<TipoDeDato> dest, int destino);
    
}
