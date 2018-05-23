package arbol;

public interface InterfazCola<Tipo> {
        
    public void encolar(Tipo dato);
    
    public Tipo desencolar();
    
    public Tipo obtenerFrente();
    
    public void anular();
    
    public int tamanoCola();
        
    public boolean esVacia();
    
}
