package main;

public class InsertionSort extends GenerateArray {

	public static void sort(int[] vec) {
		int n = vec.length;
		for (int i = 1; i < n; ++i) {
			int key = vec[i];
			int j = i - 1;
			while (j >= 0 && vec[j] > key) {
				vec[j + 1] = vec[j];
				j = j - 1;
			}
			vec[j + 1] = key;
		}
	}
}
