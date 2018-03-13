package lab.edd;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Fecha vencimiento = new Fecha();
		Lotes [] lote = new Lotes[10];
		System.out.println("Ingrese el año: ");
		vencimiento.setAaaa(sc.nextInt());
		System.out.println("Ingrese el mes(1-12): ");
		vencimiento.setMm(sc.nextInt());
		System.out.println("Ingrese el año(1-31): ");
		vencimiento.setDd(sc.nextInt());
		String fechaVencimiento = String.valueOf(vencimiento.getAaaa())+"/"+
				String.valueOf(vencimiento.getMm())+"/"+
				String.valueOf(vencimiento.getDd());
		for (int i=0; i<10; i++){
			if(lote[i].fechaVencto.equals(fechaVencimiento)){
				System.out.println("Medicamento: * Codigo: "+lote[i].getCodigo()+"\n");
				System.out.println("\t"+"* Nombre: "+lote[i].getNombre()+"\n");
				System.out.println("\t"+"* Laboratorio: "+lote[i].getNombre()+"\n");
			}
		}
	}

}
