import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class ReadFile {
	//declaramos un objeto del tipo BufferedReader
	private BufferedReader bf;
	private BufferedReader bfCount;
	
	public void findTestsums(String dir){
		//el string text contiene las lineas leidas del archivo
		String text = "";
		/*el entero testsum contendra el valor ascii final del archivo.
		 * Si no existe, tendra el valor 0
		*/
		int testsum = 0;

		NumberFormat numberFormat =  NumberFormat.getNumberInstance(Locale.US);
		
		try {
			//instanciamos el objeto lector del archivo(escaner)
			bf = new BufferedReader(new FileReader(dir));
			bfCount = new BufferedReader(new FileReader(dir));
			int c = 0;
			int i = 0;
			//el string bfRead contendra cada linea leida del archivo
			String bfRead;
			//mientras no se llegue al final del archivo, se concatenan las lineas
			while ((bfRead = bfCount.readLine()) != null){
				c++;
			}
			int[] sumas = new int[c];
			while ((bfRead = bf.readLine()) != null){
				for (int j = 0; j < bfRead.length(); j++) {
		            testsum += (int) bfRead.charAt(j);
		        }
				sumas[i] = testsum;
				System.out.println(bfRead+", "+sumas[i]+"\n");
				i++;
				testsum = 0;
			}
			
			System.out.println("Archivo: "+dir+". Testsum final: "+numberFormat.format(testsumFinal(sumas)));
		} catch (Exception e) {
			//Mensaje de error generico
			System.out.println("Ha ocurrido un error. No se pudo realizar la comparacion."+"\n");
			//Excepcion recibida
			System.err.println(e);
		}
	}
	
	public int testsumFinal(int[] sumas){
		int testsumFinal = 0;
		for (int i = 0; i < sumas.length; i++) {
			testsumFinal+=sumas[i];
		}
		return testsumFinal;
		
	}
}
