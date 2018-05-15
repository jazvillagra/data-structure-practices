package main;

import java.time.LocalDate;

public interface InterfazColaPrioridad {

	public void agregarCliente(String nombre, int antig, String motivo, LocalDate ld);
    
    public String atenderCliente();
}
