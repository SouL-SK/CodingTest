package algorithm_java;
/*
    problem : baekjoon NO.1835
    task : 1부터 N까지의 숫자가 적힌 카드가 있다.카드의 개수 N이 주어져 있을 때 위의 마술을 하기 위한 카드의 초기 순서를 구하는 프로그램을 작성하시오.
    point :
        - N번 카드가 남을 때까지, 먼저 마지막에 있는 카드 N을 뽑는다. 그리고 N번 만큼 마지막에 있는 카드를 앞으로 보낸다.
        - deque를 이용, 1부터 N까지 addFirst()로 내림차순으로 넣은 뒤에- 굳이 내림차순으로 저장할 필요 없이, 저 과정을 거꾸로 진행한다.
        - 여기서 문제가 생겼다. 거꾸로 진행하는 과정을 어떻게 구현하는가이다. 아예 대우 명제로 바꾸어 진행하는지 그저 거꾸로 n-- 하며 내림차순으로 진행하는지 모르겠다.
        결국 해보고 나서 결과를 보면 아는거겠지
        - 과정 중에 pop() 연산을 하지 않는다. 옮겨놓는다는 표현은 pop 연산을 말하는 것이다. 하지만 여기서는 하지 않아야 정답을 찾을 수 있다.
        - 먼저 N을 넣는다. 그리고 N번 만큼 마지막에 있는 카드를 위로 올린다!!
        이 과정을 N-- 하며 반복하며 넣어주면 끝
        - 시간 복잡도 : O(n^2), 소요 시간 : 224 ms, 메모리 : 14980 kb
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BK1835 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
//        for(int i = 1; i <= N ; i++){
//            queue.add(i);
//        }
        queue.add(N);
        for (int i = N - 1; i>0; i--) {
            queue.addFirst(i);

            for (int j=0;j<i;j++) {
                queue.addFirst(queue.pollLast());
            }
        }
        queue.forEach(i -> System.out.print(i + " "));
//        StringBuilder sb = new StringBuilder();
//        queue = shift(queue);
//        for(int i = 0;i < N ; i++){
//            sb.append(queue.removeFirst()).append(' ');
//        }
//        System.out.print(sb);
    }

//    public static Deque<Integer> shift(Deque<Integer> queue){
//        for(int i = 1; i <= queue.size() ; i++){
//            for(int j = 0; j < i ; j++){
//                queue.addLast(queue.pollFirst());
//            }
//            queue.removeFirst();
//            queue.addFirst(i);
//        }
//        queue.removeFirst();
//        queue.addFirst(queue.size());
//        return queue;
//    }
}
