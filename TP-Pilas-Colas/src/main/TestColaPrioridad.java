package main;

import java.time.LocalDateTime;
/**
 * 
 * @author jvillagra, mfare, jheisecke
 *
 */
public class TestColaPrioridad {

	public static void main(String[] args) {
		ColaPrioridad<String> cola= new ColaPrioridad<>();
		  try {
				LocalDateTime ld = LocalDateTime.now();
				cola.agregarCliente("Juan Gomez", 2, "Defecto de fábrica", ld, 'A'); 
				LocalDateTime ld2 = LocalDateTime.now();
				cola.agregarCliente("Maria Gonzalez",3, "Defecto de fábrica", ld2, 'A'); 
				LocalDateTime ld3 = LocalDateTime.now();
				cola.agregarCliente("Carmen Lopez", 5, "Queja por trato de personal", ld3, 'A'); 
				LocalDateTime ld4 = LocalDateTime.now();
				cola.agregarCliente("José Perez", 1, "Compra de insumos de oficina", ld4, 'M'); 
				LocalDateTime ld5 = LocalDateTime.now();
				cola.agregarCliente("Pancracio Gutierrez", 1, "Compra de carpetas", ld5, 'M'); 
				LocalDateTime ld6 = LocalDateTime.now();
				cola.agregarCliente("Filomeno Santacruz", 7, "Compra de resma de hojas", ld6, 'M');
				LocalDateTime ld7 = LocalDateTime.now();
				cola.agregarCliente("Braulio Cabañas", 3, "Consulta de precios de insumos de oficina", ld7, 'B');
				LocalDateTime ld8 = LocalDateTime.now();
				cola.agregarCliente("Joaquin Aguirre", 4, "Consulta de precios de pizarra", ld8, 'B');
	            
				int n= cola.nodoCola.getQueja().tamCola;
	            if(n>0){
					System.out.println("Atendiendo clientes de prioridad Alta");
		            for (int i=0; i<n; i++) {
		                System.out.println("Cliente " + i + ": " + cola.atenderCliente('A'));
		            }
	            }
	            n= cola.nodoCola.getCompra().tamCola;
	            if(n>0){
		            System.out.println("\nAtendiendo clientes de prioridad Media");
		            for (int i=0; i<n; i++) {
		                System.out.println("Cliente " + i + ": " + cola.atenderCliente('M'));
		            }
	            }
	            n = cola.nodoCola.consulta.tamCola;
	            if(n>0){
		            System.out.println("\nAtendiendo clientes de prioridad Alta");
		            for (int i=0; i<n; i++) {
		                System.out.println("Cliente " + i + ": " + cola.atenderCliente('B'));
		            }
	            }
		  }catch (Exception e) {
			  System.err.println(e.getMessage());
		}
	}
}
