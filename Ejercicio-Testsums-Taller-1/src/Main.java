/**
 * 
 * @authors Paula Villagra, Javier Heisecke, Matias Fare
 *
 *	Fuentes:
 * Manejo de argumentos por linea de comandos.
 * https://docs.oracle.com/javase/tutorial/essential/environment/cmdLineArgs.html
 * http://www.learnjavaonline.org/en/Compiling_and_Running_with_Arguments
 */
public class Main {

	public static void main(String[] args) {
		/*
		 * Instanciamos un objeto de tipo TestSums
		 */
		TestSums file = new TestSums();
		/*
		 * Uno a uno ingresamos los archivos por linea de comandos
		 * y se calcula el testsum de las lineas y el archivo correspondiente
		 */
		for (int i = 0; i < args.length; i++) {
			file.findTestsums(args[i]);
		}
	}

}
