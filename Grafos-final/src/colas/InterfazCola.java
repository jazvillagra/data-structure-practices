package colas;

public interface InterfazCola<TipoDeDato> {
        
    public void encolar(TipoDeDato dato);
    
    public TipoDeDato desencolar();
    
    public TipoDeDato obtenerFrente();
    
    public void anular();
    
    public int tamanoCola();
        
    public boolean esVacia();
    
}
