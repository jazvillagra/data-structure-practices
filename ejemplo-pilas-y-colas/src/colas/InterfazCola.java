package colas;

public interface InterfazCola<TipoDeDato extends Comparable<TipoDeDato>> {
        
    public void encolar(TipoDeDato dato);
    
    public TipoDeDato desencolar();
    
    public int tamanoCola();
        
    public boolean esVacia();
    
    public void obtenerMayor(Cola<TipoDeDato> aux);
    
}
