package algorithm_java;

import java.util.Scanner;

public class BK1009 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int T = sc.nextInt();
//		int a = sc.nextInt();
//		int b = sc.nextInt();
//		int data = 0;
//		for(int i = 1; i < b;i++) {
//			data += a*a;
//		}
//		
//		int result = data%10;
//		System.out.println(result);
//	}

	/**
	 * 답안 1 - A에 B제곱을 구한 뒤 뒷자리만 가져오는 로직, 자리수 제한 있어서 제곱 구할 때마다 10으로 나눈 나머지만 가지고 계산(오버헤드
	 * 줄음)
	 */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int T = s.nextInt();
		int a, b, r;
		for (int j = 0; j < T; j++) {
			a = s.nextInt();
			b = s.nextInt();
			r = 1;

			for (int i = 0; i < b; i++)
				r = (r * a) % 10;
			if (r == 0)
				r = 10;
			System.out.println(r);
		}
		s.close();
	}

}
