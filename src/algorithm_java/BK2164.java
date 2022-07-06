package algorithm_java;
/*
    problem : baekjoon NO.2164
    task : N이 주어졌을 때, 제일 마지막에 남게 되는 카드를 구하는 프로그램을 작성하시오.
    point :
        - deque 를 이용하여 뒤의 카드는 버리고, 앞의 카드는 뒤로 보내는 작업을 구현한다. 혹은 queue를 이용해도 된다.
        - N장의 카드가 있다. 각각의 카드는 차례로 1부터 N까지의 번호가 붙어 있으며, 1번 카드가 제일 위에, N번 카드가 제일 아래인 상태로 순서대로 카드가 놓여 있다.
        - 여기서 나는 deque의 앞쪽(first)을 바닥으로, 뒤쪽(last)를 위로 간주하고 해당 과정을 진행하였다.
        - 1트 째, 6을 넣었더니 3이 나왔다. 결과는 4여야 한다. 디버깅을 진행하며 remove() 에서 queue의 변화를 재점검하였다.
        위를 first로, 바닥을 last로 진행해야 제대로 결과가 나온다!!
        - 시간 복잡도 : O(N), 소요 시간 : 316 ms, 메모리 : 39960 kb
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BK2164 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 1 ; i <= n ; i++){
            deque.add(i);
        }
        System.out.print(remove(deque));
    }

    public static int remove(Deque<Integer> queue) {
        while(queue.size() != 1){
            queue.removeFirst();
            int temp = queue.removeFirst();
            queue.addLast(temp);
        }
        return queue.remove();
    }
}
