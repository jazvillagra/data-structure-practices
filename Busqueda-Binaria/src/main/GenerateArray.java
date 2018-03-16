package main;

public class GenerateArray {
	public static int[] newRandomArray(int N){
		int[] vec = new int [N];
		for (int i=0; i < vec.length; i++) {
			vec[i] = (int) (Math.random()*N);
		}
		return vec;
	}
	
}
