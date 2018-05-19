package main;

import java.time.LocalDateTime;
/**
 * 
 * @author jvillagra, mfare, jheisecke
 *
 */
public interface InterfazColaSimple<TipoDeDato> {
	
	public void encolar(String nombre, int antig, String motivo, LocalDateTime ld);
    
    public TipoDeDato desencolar();
}
