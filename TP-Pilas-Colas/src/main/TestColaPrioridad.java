package main;

import java.time.LocalDateTime;

public class TestColaPrioridad {

	public static void main(String[] args) {
		ColaPrioridad<String> cola= new ColaPrioridad<>();
		  try {
				LocalDateTime ld = LocalDateTime.now();
				cola.agregarCliente("Juan", 2, "Defecto", ld, 'A'); 
				LocalDateTime ld2 = LocalDateTime.now();
				cola.agregarCliente("Maria",3, "Defecto", ld2, 'A'); 
				LocalDateTime ld3 = LocalDateTime.now();
				cola.agregarCliente("Carmen", 5, "Defecto", ld3, 'A'); 
				
				cola.agregarCliente("BCD", 5, "Defecto", ld3, 'M'); 
				cola.agregarCliente("EFG", 5, "Defecto", ld3, 'M'); 

	            int n= cola.nodoCola.getQueja().tamCola;
	            System.out.println("Atendiendo clientes de prioridad Alta");
	            for (int i=0; i<n; i++) {
	                System.out.println("Cliente " + i + ": " + cola.atenderCliente('A'));
	            }
	            System.out.println("\nAtendiendo clientes de prioridad Media");
	            
	            n= cola.nodoCola.getCompra().tamCola;
	            for (int i=0; i<n; i++) {
	                System.out.println("Cliente " + i + ": " + cola.atenderCliente('M'));
	            }
		  }catch (Exception e) {
			  
		}
	}
}
