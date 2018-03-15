package lab.edd;

public class Test {

	public static void main(String[] args)
		throws Exception
		{
		Test test1=new Test();
		Medicamentos[] meds = new Medicamentos[5];
		
		String[] input = {"Paracetamol","Clorfenamina ","Pseudoefedrina"};
		meds[0]=new Medicamentos("A1223BC","Trio-Val","Lasca",input);
		
		String[] input1 = {"paracetamol"};		
		meds[1]=new Medicamentos("A523BC","Z-mol","Comfar",input1);	
		
		String[] input2 = {"Analgésico","Antiinflamatorio ","Antirreumático","ibuprofeno"};		
		meds[2]=new Medicamentos("Z23DH","Kitadol","Lasca",input2);
		
		String[] input3 = {"Analgésico","Paracetamol ","ibuprofeno"};		
		meds[3]=new Medicamentos("FG23GF","Actron","Bayern",input3);
		
		Lotes[] lotes= new Lotes[4];
		}

}
