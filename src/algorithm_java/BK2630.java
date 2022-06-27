package algorithm_java;

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

//import java.util.Scanner;
//public class Main {
//	static int N;
//	static byte[][] A;
//	static boolean 같은수인가(int row, int col, int size) {
//		byte value = A[row][col]; // 첫 칸의 값 
//		for (int r = row; r < row + size; ++r) 
//			for (int c = col; c < col + size; ++c) 
//				if (A[r][c] != value) return false; // 불일치 
//		return true; 
//		} 
//	static void solution(int[] count, int row, int col, int size) {
//		if (같은수인가(row, col, size)) { // 영역 전체가 같은 수인가? 
//			count[A[row][col]] += 1; // 그렇다면, 해당 종이의 수에 1을 더하고 
//			return; // 리턴한다 
//			} 
//		int size2 = size / 2; // 자식 영역의 크기 
//		for (int r = 0; r < 2; ++r) // 4개의 자식 영역 각각에 대한 재귀호출 
//			for (int c = 0; c < 2; ++c) 
//				solution(count, row + r * size2, col + c * size2, size2); 
//		} 
//	public static void main(String[] args) {
//		try (Scanner scanner = new Scanner(System.in)) { 
//			N = scanner.nextInt();
//			A = new byte[N][N];
//			for (int r = 0; r < N; ++r) 
//				for (int c = 0; c < N; ++c) A[r][c] = scanner.nextByte();
//			int[] count = new int[2];
//			solution(count, 0, 0, N);
//			for (int i : count) System.out.println(i); 
//			} 
//		} 
//	}
