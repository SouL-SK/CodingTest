package algorithm;

import java.util.*;

/**
 * 프로그래머스
 * 2019 카카오 개발자 겨울 인턴쉽 - 크레인 인형 뽑기
 * @author shuai
 *
 */
public class Pro2019Kakao {
	public int solution(int[][] board, int[] moves) {
//		int[][] stack = new int[board.length][board[0].length];
//		for (int i = 0; i < board.length; i++) {
//			int inX = 0;
//			int inY = 0;
//			for (int j = 0; j < board[i].length; j++) {
//				if (board[i][j] != 0) {
//					stack[inX][inY] = board[i][j];
//					inX++;
//				}
//			}
//		}
		Stack<Integer> stack = new Stack<Integer>();
		int count = 0;
		
		for (int i = 0; i < moves.length; i++) {
			int index = moves[i];
			for (int j = 0; j < board[i].length; j++) {
				if (board[index][j] != 0) {
					if (stack.peek() == board[index][j]) {
						count += 2;
					} else {
						stack.push(board[index][j]);					

					}
				}
				board[index][j] = 0;
			}
			
		}
		return count;
		
	}
//		애초에 생각을 잘못함. 배열 그대로 사용하면서 배열의 값들을 비교해서 스택에 넣고 넣은 값이 스택에 있던 값이랑
//		같으면 삭제 후에 인형 개수 2개 올리면 된다.

}
