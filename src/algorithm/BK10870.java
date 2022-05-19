package algorithm;

import java.util.Scanner;

/**
 * 거꾸로 0까지 타고 들어가서 다시 처음부터 더한 값을 출력한다. 먼저 마지막 항까지 접근하는 것이 중요 그 다음에 항을 더하기 시작하여
 * 마지막 항을 구하면 된다.
 */
public class BK10870 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
//		int result = 0;	필요없는 줄
//		int[] temp = new int[n]; 필요없는 줄
//	저장 용량을 설정하지 않으면 생기는 오류 : Variable must provide either dimension expressions or an array initializer
		System.out.println(Solution(n));

		sc.close();

	}

	static int Solution(int n) {
//		if (n == 0) {
//			return 0;
//		}
//		if (n == 1) {
//			return 1;
//		}
		if (n <= 1) {
			return n;
		} else {
			return Solution(n - 1) + Solution(n - 2);
		}
	}

}