package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * 알고스팟 
 * BOGGLE
 * @author shuai
 * 먼저 풀기 전에 완전탐색, 분할 정복 알고리즘을 먼저 하고 오자.
 */
public class BOGGLE {
	static ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; tc++) {
			for (int input = 0; input < 5; input++) {
				list.add(br.readLine());
			}
			int N = Integer.parseInt(br.readLine());
			if (N < 1 || N > 10) {
				bw.write("Error :: 1 <= N(number of word) <= 10");
				System.exit(0);
			}
			for (int now = 0; now < N; now++) {
				String word = br.readLine();
				boolean ret = false;
				for (int y = 0; y < 5; y++) {
					for (int x = 0; x < 5; x++) {
							//단어가 있는지 여기서 확인
						if (ret == true) break;
					}
					if (ret == true) break;
				}
				bw.write(String.format("%s %s\n", word, ret ? "YES" : "NO"));
			}
		}
		bw.close();
	}
}

// 시간 초과가 나지만 (10초) 기본적인 로직은 이렇게 (재귀만 사용)
//import java.util.Scanner;
//
//public class Main1 {
//	static boolean DFS(char[][] map, int row, int col, int index, String s) {
//		if (index == s.length())
//			return true;
//		if (row < 0 || col < 0 || row >= 5 || col >= 5)
//			return false;
//		if (map[row][col] != s.charAt(index))
//			return false;
//		for (int dr = -1; dr <= 1; ++dr)
//			for (int dc = -1; dc <= 1; ++dc)
//				if (dr != 0 || dc != 0)
//					if (DFS(map, row + dr, col + dc, index + 1, s))
//						return true;
//		return false;
//	}
//
//	static boolean 탐색(char[][] map, String s) {
//		for (int r = 0; r < 5; ++r)
//			for (int c = 0; c < 5; ++c)
//				if (DFS(map, r, c, 0, s))
//					return true;
//		return false;
//	}
//
//	public static void main(String[] args) {
//		Scanner scanner = new Scanner(System.in);
//		int T = scanner.nextInt();
//		char[][] map = new char[5][];
//		for (int t = 0; t < T; ++t) {
//			for (int r = 0; r < 5; ++r) {
//				String s = scanner.next();
//				map[r] = s.toCharArray();
//			}
//			int W = scanner.nextInt();
//			for (int w = 0; w < W; ++w) {
//				String s = scanner.next();
//				System.out.println(s + (탐색(map, s) ? " YES" : " NO"));
//			}
//		}
//		scanner.close();
//	}
//}