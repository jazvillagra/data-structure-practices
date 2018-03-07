
public class Main {

	public static void main(String[] args) {
		//Instanciamos un objeto de tipo ReadFile
		ReadFile file = new ReadFile();
		for (int i = 0; i < args.length; i++) {
			file.findTestsums(args[i]);
		}
	}

}
