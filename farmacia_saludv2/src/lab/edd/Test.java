package lab.edd;

public class Test {

	public static void main(String[] args)
		throws Exception
		{
		Medicamentos[] meds = new Medicamentos[5];
		
		String[] input = {"Paracetamol","Clorfenamina ","Pseudoefedrina"};
		meds[0]=new Medicamentos("A1223BC","Trio-Val","Lasca",input);
		
		String[] input1 = {"paracetamol"};		
		meds[1]=new Medicamentos("A523BC","Z-mol","Comfar",input1);	
		
		String[] input2 = {"Analg�sico","Antiinflamatorio ","Antirreum�tico","ibuprofeno"};		
		meds[2]=new Medicamentos("Z23DH","Kitadol","Lasca",input2);
		
		String[] input3 = {"Analg�sico","Paracetamol ","ibuprofeno"};		
		meds[3]=new Medicamentos("FG23GF","Actron","Bayern",input3);
		
		Lotes[] lotes= new Lotes[4];
		lotes[0]= new Lotes("2018-02-10",25000,5000,input);
		lotes[1]= new Lotes("2016-03-23",35000,15000,input1);
		lotes[2]= new Lotes("2019-05-17",2000,1000,input2);
		lotes[3]= new Lotes("2022-12-15",123000,3000,input3);
		}

}
