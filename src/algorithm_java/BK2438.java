package algorithm_java;

import java.util.Scanner;

public class BK2438 {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int j = 1; j < N+1; j++) {
			for(int i = 1; i < j+1 ; i++) {
				System.out.printf("*");
			}
			System.out.println(" ");
		}
		sc.close();

	}
}
