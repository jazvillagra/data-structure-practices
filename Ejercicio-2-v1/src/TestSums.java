/**
 * 
 * @authors Paula Villagra, Javier Heisecke, Matias Fare
 *
 *	Fuentes:
 *		Ejemplo de uso de clase BufferedReader. http://www.cafeaulait.org/slides/sd2000east/javaio/56.html
 *		Ejemplo de Casting a Entero. https://stackoverflow.com/questions/16458564/convert-character-to-ascii-numeric-value-in-java
 *		Manejo de excepciones. http://lms.dz.com.py/pluginfile.php/344/mod_resource/content/1/extra-archivos-garbage-exceptions-java.pdf
 *		Uso de clase NumberFormat. https://docs.oracle.com/javase/7/docs/api/java/text/NumberFormat.html
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.NumberFormat;
import java.util.Locale;

public class TestSums {
	/*
	 * Declaramos dos objetos del tipo BufferedReader
	 * Con bf, leeremos las lineas
	 * Con bfCount, contaremos las lineas en un archivo
	 */
	private BufferedReader bf;
	private BufferedReader bfCount;
	
	public void findTestsums(String dir){
		/*
		 * El entero testsum contendra el valor ascii
		 * de cada elemento del archivo.		
		 */
		int testsum = 0;
		/*
		 * Number format es una clase que proporciona
		 * la interfaz para formatear y analizar nros.
		*/
		NumberFormat numberFormat =  NumberFormat.getNumberInstance(Locale.US);
		
		try {
			/*
			 * Instanciamos el objeto lector del archivo(escaner)
			 */
			bf = new BufferedReader(new FileReader(dir));
			/*
			 * Instanciamos el  objeto que nos ayudara a contar
			 * las lineas del archivo
			 */
			bfCount = new BufferedReader(new FileReader(dir));
			int c = 0;
			int i = 0;
			/*
			 * El string bfRead contendra cada linea leida del archivo
			 */
			String bfRead;
			/*
			 * Mientras no se llegue al final del archivo nuestro
			 * contador incrementa en uno
			 */
			while ((bfRead = bfCount.readLine()) != null){
				c++;
			}
			/*
			 * Declaramos un vector suma que tendra almacenado
			 * el testsum por linea del archivo que se ha leido
			 */
			int[] sumas = new int[c];
			/*
			 * Mientras no se llegue al final del archivo
			 * se convierten los caracteres en valor ascii
			 */
			while ((bfRead = bf.readLine()) != null){
				for (int j = 0; j < bfRead.length(); j++) {
		            testsum += (int) bfRead.charAt(j);
		        }
				/*
				 * Se almacena el testsum de cada linea en 
				 * la posicion correspondiente del vector suma
				 * (primera linea tiene su testsum en la posicion
				 * 0 del vector, y asi sucesivamente)
				 */
				sumas[i] = testsum;
				System.out.println(bfRead+", "+sumas[i]+"\n");
				i++;
				/*
				 * Formateamos testsum para usar en la siguiente linea
				 */
				testsum = 0;
			}
			/*
			 * Se imprime el valor ascii final del archivo
			 * usando el metodo finalTestsum
			 */
			System.out.println("Archivo: "+dir+". Testsum final: "
							+numberFormat.format(testsumFinal(sumas))+"\n");
		} catch (Exception e) {
			/*
			 * Mensaje de error generico
			 */
			System.out.println("Ha ocurrido un error. No se pudo "+
							"realizar la comparacion."+"\n");
			/*
			 * Excepcion recibida
			 */
			System.err.println(e);
		}
	}
	
	/*
	 * El siguiente metodo calcula el valor ascii final del archivo
	 */
	public int testsumFinal(int[] sumas){
		int testsumFinal = 0;
		for (int i = 0; i < sumas.length; i++) {
			testsumFinal+=sumas[i];
		}
		return testsumFinal;
		
	}
}
