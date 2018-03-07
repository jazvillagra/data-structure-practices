/**
 * 
 * @author Jazmin Villagra, Javier Heisecke, Matias Fare
 *
 *	Fuentes:
 *		https://docs.oracle.com/javase/7/docs/api/java/text/NumberFormat.html
 */
public class Main {

	public static void main(String[] args) {
		//Instanciamos un objeto de tipo ReadFile
		ReadFile file = new ReadFile();
		//uno a uno ingresamos los archivos por linea de comandos
		for (int i = 0; i < args.length; i++) {
			file.findTestsums(args[i]);
		}
	}

}
