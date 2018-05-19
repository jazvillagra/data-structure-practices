package main;

import java.time.LocalDateTime;

public interface InterfazColaPrioridad {

	public void agregarCliente(String nombre, int antig, String motivo, LocalDateTime ld, char prioridad);
    
    public String atenderCliente(char prioridad);
}
