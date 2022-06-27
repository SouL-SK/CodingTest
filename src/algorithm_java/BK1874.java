package algorithm_java;

import java.util.*;

/**
 * 백준
 * 1874번 스택 수열
 * @author shuai
 *
 */
public class BK1874 {
	public static void Solution() {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int start = 1;
		Stack<Integer> stack = new Stack<Integer>();

		while (n-- != 0) {
			int value = sc.nextInt();
			if (value > start) {
				// start + 1부터 입력받은 value 까지 push를 한다.
				for (int i = start + 1; i <= value; i++) {
					stack.push(i);
					System.out.println("+");
				}
				start = value; // 다음 push 할 때의 오름차순을 유지하기 위한 변수 초기화
			}

			// top에 있는 원소가 입력받은 값과 같이 않은 경우
			else if (stack.peek() != value) {
				System.out.println("NO");

				stack.pop();
				System.out.println("-");
			}
		}


	}
	public static void main(String[] args) {
		Solution();
	}

}
