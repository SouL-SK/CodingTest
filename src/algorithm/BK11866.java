package algorithm;

import java.util.*;

/**
 * 백준
 * 11866번 요세푸스 문제 0
 * @author shuai
 *
 */
public class BK11866 {
	static ArrayDeque<Integer> mans = new ArrayDeque<Integer>();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		int n = sc.nextInt();
		int k = sc.nextInt();

		Yosep(n, k);
	}

	public static String Yosep(int n, int k) {
		String str = "< ";
		for (int i = 1; i <= n; i++) {
			mans.add(i);
		}
		for (int i = 1; i <= n; i++) {
			if (i * k > n) {
				int temp = n - (i * k);
				if (i == n) {
					str += mans.offer(temp);
				} else {
					str += mans.offer(temp) + ", ";
				}
			} else {
				if (i == n) {
					str += mans.offer(i * k);
				} else {
					str += mans.offer(i * k) + ", ";
				}
			}
		}
		System.out.println(str);
		return str;
	}
}
