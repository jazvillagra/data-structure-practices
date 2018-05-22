package main;

import java.time.LocalDateTime;
/**
 * 
 * @author jvillagra, mfare, jheisecke
 *
 */
public interface InterfazColaPrioridad {

	public void agregarCliente(String nombre, int antig, String motivo, LocalDateTime ld, char prioridad);
    
    public String atenderCliente(char prioridad);
}
