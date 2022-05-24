package algorithm;

import java.util.Scanner;

public class BK1267 {
	public static void main(String[] agrs) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		// N의 개수 만큼 입력을 받아야 하기 때문에 for문에 넣어야 함.
		int M = 0;
		int Y = 0;
		for (int i = 0; i < N; i++) {
			int callTime = sc.nextInt();
			// +1 을 해줘야 한다. << 왜냐면 기본 요금부터 시작되니까
			M += (callTime / 60 +1) * 15;
			Y += (callTime / 30 +1) * 10;
		}

		if (M > Y) {
			System.out.println("Y " + Y);
		} else if (M == Y) {
			System.out.println("Y M " + M);
		} else {
			System.out.println("M " + M);

		}

	}
}
