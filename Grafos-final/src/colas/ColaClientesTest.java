package colas;

import java.util.Scanner;

public class ColaClientesTest {
	public static void main(String[] args) {
		 Cola<String> cola = new Cola<>();
		 Scanner sc = new Scanner(System.in);
		 
		 String nombre = null;
		 System.out.println("Ingrese los nombres que desea almacenar"
			 		+ "(doble enter para terminar el proceso de carga): ");
		 nombre = sc.next();
		 do{
			 cola.encolar(nombre);;
			 System.out.println("Siguiente nombre: ");
			 nombre = sc.next();
		 }while(!nombre.equals(null) || !nombre.equals("\n"));
		 sc.close();
		 System.out.println("La lista completa es:\n");
		 while (!cola.esVacia()) {
             System.out.println("Valor : " + cola.desencolar());
         }
	}

}
