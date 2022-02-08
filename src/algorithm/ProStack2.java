package algorithm;

import java.util.ArrayDeque;

/**
 * 프로그래머스
 * 스택/큐 - 프린터
 * @author shuai
 *
 */
public class ProStack2 {
	class Solution {
	    public int solution(int[] priorities, int location) {
	        int answer = 0;
	        ArrayDeque<Integer> queue = new ArrayDeque<>();
	        for(int i = 0; i < location + 1;i++){
	            queue.add(priorities[i]);
	        }
	        int count = 0;
	        while(!queue.isEmpty()){
	            int temp = queue.poll();
	            boolean flag = false;
	            for(int i = 0; i < queue.size(); i++){
	                if(priorities[i] > temp){
	                    flag = true;
	                }
	            }
	            if(flag){
	                queue.add(temp);
	            }
	        }
	        return answer;
	    }
	}
}
