package main;

import java.time.LocalDate;

public interface InterfazColaPrioridad {

	public void agregarCliente(String nombre, int antig, String motivo, LocalDate ld, char prioridad);
    
    public String atenderCliente(char prioridad);
}
