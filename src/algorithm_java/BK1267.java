package algorithm_java; /**
 * 백준 1267번 휴대폰 요금
 * 
 * 조건
 * - 두 가지 요금제가 있다. 영식, 민식 요금제. 각 요금제는 30초마다 10원, 60초마 15원씩 청구된다.
 * - 영식 요금제 기준으로, 30초 보다 적은 시간 통화를 했으면 10원이 청구되고 30초를 넘기기만 하면 20원이 청구.
 * - 더 싼 요금제의 이름을 출력하고, 공백을 사이에 두고 요금을 출력한다. 두 요금제의 요금이 모두 같으면 영식을 먼저 쓰고 민식을 그 다음에 쓴다. 영식 = Y, 민식 = M
 * 
 * 헷갈린 부분
 * - N를 받으면 그 횟수 만큼 input을 받아야 하기 때문에 sc.nextInt()를 for문 안에 넣어 N번 반복해야 한다.
 * - 요금제는 기본 요금이 들어가 있기 때문에 (몇 초마다 몇 원인지는 상관 없다. 적은 시간을 통화했어도 처음 청구되는 금액이 있다) +1을 해줘야 한다.
 */
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
