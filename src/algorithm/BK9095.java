package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 * 백준 9095번 
 * 1, 2, 3 더하기
 * @author shuai
 *
 */
public class BK9095 {
	static int[] n; // 11보다 작은 입력 값
	static int[] s; // 방법의 수

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String count = br.readLine();
		
		n = new int[Integer.parseInt(count)];
		s = new int[Integer.parseInt(count)];
		for (int i = 0; i < n.length; i++) {
			n[i] = Integer.parseInt(br.readLine());
		}

//		for (int li : n) {
//			System.out.println(li);
//		}

		int r = 1;
		while (r != 0) {
			for (int i = 0; i <= n.length; i++) {
				for (int j = 1; j <= 3; j++) {
					while (r != 0) {
						Solution(n[i], j);
					}
					s[i]++;
				}

			}
		}
		
		for (int i : s) {
			System.out.println(i);
		}
	}

	public static int Solution(int n, int s) {
		return n / s;
	}
}
