package algorithm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 백준 
 * 2630번 색종이 만들기
 * @author shuai
 * Nuberformat error
 */
public class BK2630 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int n;
	static int[][] list;
	static int[] count = new int[2];

	public static void main(String[] args) throws IOException, NumberFormatException {
		n = Integer.parseInt(br.readLine());
		list = new int[n][n];
		String line = "";
		while (true) {
			line = br.readLine();
			if (line == null) break;
			
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				list[i][j] = Integer.parseInt(br.readLine());
			}
		}
		Solution(n, 0, 0);
	}

	public static boolean Solution(int n, int x, int y) {
		String result = "";
		int val = list[x][y];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (list[i][j] != val) {
					Solution(n/2, x, y);
					Solution(n/2, x, y+n/2);
					Solution(n/2, x+n/2, y);
					Solution(n/2, x+n/2, y+n/2);
					return false;
				}
			}
		}
		count[list[x][y]]++;
		return true;
	}
}
