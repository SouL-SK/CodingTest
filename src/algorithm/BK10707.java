package algorithm;

import java.util.Scanner;

public class BK10707 {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int result = 0;
		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();
		int D = sc.nextInt();
		int P = sc.nextInt();
		if(P <= C) {
			result = B;
		}else {
			for(int i = 0; i <= P-C;i++ ) {
				result += D;
			}
		}
		if((P*A)<result){
			System.out.println(P*A);
		}else {
			System.out.println(result);
		}
	}
}

