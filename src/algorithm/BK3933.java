package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 3933번 라그랑주의 네 제곱수 정리
 * 
 * @author shuai
 *
 */
public class BK3933 {
	static int n;
	static int[][] result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());

//		p = a^2 + b^2 + c^2 + d^2
//		p에서 수를 빼가면서 구해야할지? 더하면서 구해야할지?

//		빼는 케이스
//		for (int i = 0; i < 4; i++) {
//			int result = 0;
//			result = Solution(n, i);
//		}

//			여기서부터 어떻게 해야 4개의 제곱수를 맞출 수 있을까?
//			애초에 생각을 잘못한것 같다. 점화식을 먼저 쓸 수 있어야 한다 << 포인트
//			참고할 내용
		/*
		 * Problem :: 3933 / 라그랑주의 네 제곱수 정리
		 *
		 * Kind :: Dynamic Programming
		 *
		 * Insight - 30 을 제곱수 3개로 만들 수 있는 방법이 x 가지라면, 31 을 제곱수 4개로 만들 수 있는 방법을 찾는데 도움이
		 * 되지 않을까? + YES <= 31 = (a^2 + b^2 + c^2) + 1^2 DP 로 풀자 # dp[i][j] = j 개의 제곱수의
		 * 합으로 i 를 표현할 수 있는 경우의 수
		 *
		 * Point - 3^2 + 4^2 와 4^2 + 3^2 가 같다 + 중복을 피하기 위해 1^2 를 사용해서 만들 수 있는 경우의 수,
		 * 1^2, 2^2 를 사용해서 만들 수 있는 경우의 수, 1^2, 2^2, 3^2 를 사용해서 만들 수 있는 경우의 수, ... # 위와
		 * 같은 방법으로 차례차례 구해나가자
		 */
		int com = 0;
		int count = 1;
		while (com != n) {
			com = Solution(count);
//			4개의 제곱수를 어떻게 설정하지?
		}
	}

	static int Solution(int val) {
		return val * val;
	}
}
