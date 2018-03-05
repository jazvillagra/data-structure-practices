package main;

import java.util.Scanner;

public class FindSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string;
		String substring;
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese una cadena: ");
		string = sc.nextLine();
		System.out.println("Ingrese una cadena: ");
		substring = sc.nextLine();
		
		int result = indexOf(string.toLowerCase(), substring.toLowerCase());
		
		if (result == substring.toLowerCase().length()) {
			System.out.println("TRUE");
		}else {
			System.out.println("FALSE");
		}
	}

	private static final int indexOf(String string, String substring) {
	    outerloop: for (int i = 0; i < string.length() - substring.length(); i++) {
	        for (int j = 0; j < substring.length(); j++) {
	            if (substring.charAt(j) != string.charAt(i + j)) {
	                continue outerloop;
	            }
	        }
	        return i;
	    }
	    return -1;
	}

}
