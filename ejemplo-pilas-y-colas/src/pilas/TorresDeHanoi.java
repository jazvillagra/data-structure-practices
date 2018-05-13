package pilas;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 * @author jvillagra, jheisecke, matiasfare
 * 
 */
public class TorresDeHanoi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner sc = new Scanner(System.in);
		System.out.println("Inserte Cantidad de Discos");
		n = sc.nextInt();
		
		Pila <Integer>[] torres = new Pila[3];
		torres[0] = new Pila<Integer>();
		torres[1] = new Pila<Integer>();
		torres[2] = new Pila<Integer>();
		
		for (int i = n; i > 0 ; i--) {
			torres[0].apilar(i);	
		}
		torres[1].mover(n, torres[0], 0, torres[1], 1, torres[2],2);
		
		System.out.println("Se realizaron todos los movimientos, la torre final quedo asi: ");
		while(!torres[2].esVacia()){
			System.out.println("Disco " +torres[2].tamanoPila()+ ": " +torres[2].desapilar());
		}
		System.out.println("Cantidad de movimientos realizados: "+torres[1].getCantMovimientos());
	}
	

}
