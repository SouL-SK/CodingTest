package algorithm;

import java.util.*;
import java.io.*;

/**
 * 백준 
 * 5568번 카드 놓기
 * @author shuai 
 * 다시 풀이 필요 해쉬셋은 중복 값을 넣을 수 없다.
 */
public class BK5568 {
	public static int NUMBER_OF_CARD;
	public static int NUMBER_OF_SELECT;
	public static String card[];
	public static boolean visited[];
	public static HashSet<String> hs = new HashSet<String>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();

		NUMBER_OF_CARD = Integer.parseInt(br.readLine());
		NUMBER_OF_SELECT = Integer.parseInt(br.readLine());
		card = new String[NUMBER_OF_CARD];
		for (int i = 0; i < NUMBER_OF_CARD; i++) {
			card[i] = br.readLine();
		}
		visited = new boolean[NUMBER_OF_CARD];
		selectCard(NUMBER_OF_SELECT, "");

		sb.append(hs.size());
		sb.append("\n");

		bw.write(sb.toString());

		bw.flush();
		br.close();
		bw.close();

	}

	public static void selectCard(int remain, String k) {
		if (remain == 0) {
			hs.add(k);
			return;
		}
		for (int i = 0; i < NUMBER_OF_CARD; i++) {
			if (!visited[i]) {
				visited[i] = true;
				selectCard(remain - 1, k + card[i]);
				visited[i] = false;
			}
		}

	}

}
//import java.util.HashSet;
//import java.util.Scanner;
//
//public class Main {
//	static int N, K;
//	static HashSet<Integer> set = new HashSet<>();
//
//	static void 완전탐색(int[] A, int selectCount, boolean[] selected, String sum) {
//		if (selectCount == K) {
//			set.add(Integer.valueOf(sum));
//			return;
//		}

// 	이렇게 구현하는 문제는 K개를 뽑아야 하는 경우

//		for (int i = 0; i < A.length; ++i) {
//			if (selected[i] == false) {
//				selected[i] = true;
//				완전탐색(A, selectCount + 1, selected, sum + String.valueOf(A[i]));
//				selected[i] = false;
//			}
//		}
//	}
//
//	public static void main(String[] args) {
//		var scanner = new Scanner(System.in);
//		N = scanner.nextInt();
//		K = scanner.nextInt();
//		int[] A = new int[N];
//		for (int i = 0; i < N; ++i)
//			A[i] = scanner.nextInt();
//		완전탐색(A, 0, new boolean[N], "");
//		scanner.close();
//		System.out.println(set.size());
//	}
//}
