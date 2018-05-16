package main;

import java.time.LocalDate;
import java.util.Date;

public interface InterfazColaSimple<TipoDeDato> {
	
	public void encolar(String nombre, Date antig, String motivo, LocalDate ld);
    
    public TipoDeDato desencolar();
}
