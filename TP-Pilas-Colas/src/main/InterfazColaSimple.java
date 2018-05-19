package main;

import java.time.LocalDateTime;

public interface InterfazColaSimple<TipoDeDato> {
	
	public void encolar(String nombre, int antig, String motivo, LocalDateTime ld);
    
    public TipoDeDato desencolar();
}
