package algorithm;

import java.io.IOException;
import java.util.Scanner;

/**
 * 백준 
 * 2630번 색종이 만들기
 * @author shuai
 *
 */
public class BK2630 {
	static Scanner sc = new Scanner(System.in);
	static int n;
	static int[][] list = new int[n][n];

	public static void main(String[] args) throws IOException {
		n = sc.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				list[i][j] = sc.nextInt();
			}
		}
		Solution(n, 0, 0);
		Solution(n/2, );
	}

	public static boolean Solution(int n, int x, int y) {
		String result = "";
		int val = list[x][y];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (list[i][j] != val) {
					return false;
				}
			}
		}

		return true;
	}
}
