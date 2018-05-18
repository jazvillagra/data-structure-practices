package main;

import java.time.LocalDateTime;
import java.util.Date;

public interface InterfazColaSimple<TipoDeDato> {
	
	public void encolar(String nombre, int antig, String motivo, LocalDateTime ld);
    
    public TipoDeDato desencolar();
}
