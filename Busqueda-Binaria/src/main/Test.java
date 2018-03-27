package main;

import java.util.Scanner;

public class Test extends InsertionSort{

	public static void main(String[] args) {
		System.out.println("N, Real, T(N), Relacion \n");
		for (int i = 0; i < args.length; i++) {
			long t1, t2;
			t1 = System.currentTimeMillis();
			// init
			int N = Integer.parseInt(args[i]);
			int[] vec = new int[N];
			vec = newRandomArray(N);
			sort(vec);
			// final
			t2 = System.currentTimeMillis();
			System.out.printf("%d,%d,%d,%f",N,(t2-t1),N*(Math.log(20)/Math.log(2.0)),(t2-t1)/N*(Math.log(N)/Math.log(2)));
		}
	}
}
