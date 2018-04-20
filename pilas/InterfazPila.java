package pilas;

public interface InterfazPila<TipoDeDato> {
        
    public void apilar(TipoDeDato dato);
    
    public TipoDeDato desapilar();
    
    public TipoDeDato obtenerTope();
    
    public void anular();
    
    public int tamanoPila();
        
    public boolean esVacia();
    
}
