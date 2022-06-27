package algorithm_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 9184번
 * 신나는 함수 실행
 *
 * @author shuai
 */
public class BK9184 {

	static int[] abc = new int[3];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int i = 0; i < abc.length; i++) {
			abc[i] = br.read();
		}
//	input = 1, 1, 1 output = 49, 32, 49
//	input = 50, 50, 50 output = 53, 48, 32
//	왜 계속 여기서 삐꾸나는지 모르겠다.

		System.out.println("w(" + abc[0] + ", " + abc[1] + ", " + abc[2] + ") = " + Solution(abc[0], abc[1], abc[2]));
	}

	public static int Solution(int a, int b, int c) {
		int result = 0;
		if (a <= 0 || b <= 0 || c <= 0) {
			result = 1;
			return result;
		} else if (a > 20 || b > 20 || c > 20) {
			result = 20;
			return result;
		} else if (a < b && b < c) {
			result = Solution(a, b, c - 1) + Solution(a, b - 1, c - 1) - Solution(a - 1, b - 1, c - 1);
			return result;
		} else {
			result = Solution(a - 1, b, c) + Solution(a - 1, b - 1, c) + Solution(a - 1, b, c - 1)
					- Solution(a - 1, b - 1, c - 1);
			return result;
		}

	}
}

//if a <= 0 or b <= 0 or c <= 0, then w(a, b, c) returns:
//    1
//
//if a > 20 or b > 20 or c > 20, then w(a, b, c) returns:
//    w(20, 20, 20)
//
//if a < b and b < c, then w(a, b, c) returns:
//    w(a, b, c-1) + w(a, b-1, c-1) - w(a, b-1, c)
//
//otherwise it returns:
//    w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1)