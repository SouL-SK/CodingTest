package algorithm_java;

import java.util.*;

/**
 * 프로그래머스
 * 정렬 - 가장 큰 수
 * @author shuai
 *
 */
public class ProSort2 {
	class Solution {
		public String solution(int[] numbers) {
			String answer = "";
			String[] str = new String[numbers.length];

			for (int i = 0; i < numbers.length; i++) {
				str[i] = String.valueOf(numbers[i]);
			}

			Arrays.sort(str, Collections.reverseOrder());

			for (int i = 0; i < numbers.length; i++) {
				answer += str[i];
			}
			return answer;
		}
	}
}
