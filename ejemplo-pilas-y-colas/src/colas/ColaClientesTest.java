package colas;

import java.util.Scanner;

import pilas.Pila;
/**
 * @author jvillagra, jheisecke, matiasfare
 * 
 */
public class ColaClientesTest {
	public static void main(String[] args) {
		 Cola<String> cola = new Cola<>();
		 Scanner sc = new Scanner(System.in);
		 
		 String nombre = null;
		 System.out.println("Ingrese los nombres que desea almacenar"
			 		+ "(doble enter para terminar el proceso de carga): ");
		 nombre = sc.nextLine();
		 do{
			 cola.encolar(nombre);;
			 System.out.println("Siguiente nombre: ");
			 nombre = sc.nextLine();
		 }while(!nombre.equals(""));
		 sc.close();
		 System.out.println("La lista completa es:\n");
		 while (!cola.esVacia()) {
             System.out.println("Valor : " + cola.desencolar());
         }
	}

}
