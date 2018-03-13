package lab.edd;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Fecha vencimiento = new Fecha();
		Lotes lote = new Lotes();
		System.out.println("Ingrese el año: ");
		vencimiento.setAaaa(sc.nextInt());
		System.out.println("Ingrese el mes(1-12): ");
		vencimiento.setMm(sc.nextInt());
		System.out.println("Ingrese el año(1-31): ");
		vencimiento.setDd(sc.nextInt());
		
		
	}

}
