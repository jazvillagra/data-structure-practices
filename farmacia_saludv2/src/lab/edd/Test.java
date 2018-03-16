
package lab.edd;
import java.util.Scanner;
/**
 * @authors jheisecke, jvillagra. Javier Heisecke, Paula Villagra
 */
public class Test {

	public static void main(String[] args)
		throws Exception
		{
		Medicamentos[] meds = new Medicamentos[5];
		
		String[] input = {"Paracetamol","Clorfenamina ","Pseudoefedrina"};
		meds[0]=new Medicamentos("A1223BC","Trio-Val","Lasca",input);
		
		String[] input1 = {"paracetamol"};		
		meds[1]=new Medicamentos("A523BC","Z-mol","Comfar",input1);	
		
		String[] input2 = {"Analgesico","Antiinflamatorio ","Antirreumatico","ibuprofeno"};		
		meds[2]=new Medicamentos("Z23DH","Kitadol","Lasca",input2);
		
		String[] input3 = {"Analgesico","Paracetamol ","ibuprofeno"};		
		meds[3]=new Medicamentos("FG23GF","Actron","Bayern",input3);
		
		Lotes[] lotes= new Lotes[4];
		lotes[0]= new Lotes("2018210",25000,5000,meds[0]);
		lotes[1]= new Lotes("2016323",35000,15000,meds[1]);
		lotes[2]= new Lotes("2019517",2000,1000,meds[2]);
		lotes[3]= new Lotes("2018815",123000,3000,meds[3]);
		
		Scanner sc = new Scanner(System.in);
		Fecha vencimiento = new Fecha();
		System.out.println("Ingrese el año: ");
		vencimiento.setAaaa(sc.nextInt());
		System.out.println("Ingrese el mes(1-12): ");
		vencimiento.setMm(sc.nextInt());
		System.out.println("Ingrese el dia(1-31): ");
		vencimiento.setDd(sc.nextInt());

		String fechaVencimiento = String.valueOf(vencimiento.getAaaa())+
				String.valueOf(vencimiento.getMm())+
				String.valueOf(vencimiento.getDd());
		for (int i=0; i<4; i++){
				if(Integer.parseInt(fechaVencimiento)>=Integer.parseInt(lotes[i].fechaVto)){
						System.out.println("Medicamento: * Codigo: "+meds[i].codigo+"\n");
						System.out.println("\t"+"* Nombre: "+meds[i].nombre+"\n");
						System.out.println("\t"+"* Laboratorio: "+meds[i].laboratorio+"\n");
				}
			}
	}
}


