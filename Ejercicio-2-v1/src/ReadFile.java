import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class ReadFile {
	//declaramos dos objetos del tipo BufferedReader uno para contar lineas y otro para leer
	private BufferedReader bf;
	private BufferedReader bfCount;
	
	public void findTestsums(String dir){
		//el entero testsum contendra el valor ascii de cada elemento del archivo.		
		int testsum = 0;
		//Number format es una clase, esta clase Esta clase proporciona la interfaz para formatear y analizar números
		NumberFormat numberFormat =  NumberFormat.getNumberInstance(Locale.US);
		
		try {
			//instanciamos el objeto lector del archivo(escaner)
			bf = new BufferedReader(new FileReader(dir));
			//instanciamos el  objeto que nos ayudara a contar las lineas del archivo
			bfCount = new BufferedReader(new FileReader(dir));
			int c = 0;
			int i = 0;
			//el string bfRead contendra cada linea leida del archivo
			String bfRead;
			//mientras no se llegue al final del archivo nuestro contador incrementara en uno
			while ((bfRead = bfCount.readLine()) != null){
				c++;
			}
			//declaramos un vector suma que tendra almacenado el testsum por linea
			int[] sumas = new int[c];
			//mientras no se llegue al final del archivo con se convierten los caracteres en valor ascii
			while ((bfRead = bf.readLine()) != null){
				for (int j = 0; j < bfRead.length(); j++) {
					//se almacenan los valores ascii en la variable testsum
		            testsum += (int) bfRead.charAt(j);
		        }
				//se almacena testsum en un vector suma
				sumas[i] = testsum;
				//imprime la linea junto con su valor ascii
				System.out.println(bfRead+", "+sumas[i]+"\n");
				//cambiamos la posicion del vector suma para almacenar el valor ascii de la siguiente linea en la siguiente posicion
				i++;
				//formateamos testsum para usar en la siguiente linea
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
	
	//En este metodo hallamos el valor ascii final del archivo
	public int testsumFinal(int[] sumas){
		int testsumFinal = 0;
		for (int i = 0; i < sumas.length; i++) {
			testsumFinal+=sumas[i];
		}
		return testsumFinal;
		
	}
}
