package algorithm_java;
/*
    problem : baekjoon NO.1021
    task : 지민이는 N개의 원소를 포함하고 있는 양방향 순환 큐를 가지고 있다.
    지민이는 이 큐에서 몇 개의 원소를 뽑아내려고 한다.큐에 처음에 포함되어 있던 수 N이 주어진다. 그리고 지민이가 뽑아내려고 하는 원소의 위치가 주어진다.
    (이 위치는 가장 처음 큐에서의 위치이다.) 이때, 그 원소를 주어진 순서대로 뽑아내는데 드는 2번, 3번 연산의 최솟값을 출력하는 프로그램을 작성하시오.
    point :
        - 첫 번째 원소를 뽑아낸다. 이 연산을 수행하면, 원래 큐의 원소가 a1, ..., ak이었던 것이 a2, ..., ak와 같이 된다.
        왼쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 a2, ..., ak, a1이 된다.
        오른쪽으로 한 칸 이동시킨다. 이 연산을 수행하면, a1, ..., ak가 ak, a1, ..., ak-1이 된다.
        - 첫째 줄에 큐의 크기 N과 뽑아내려고 하는 수의 개수 M이 주어진다. N은 50보다 작거나 같은 자연수이고, M은 N보다 작거나 같은 자연수이다.
        둘째 줄에는 지민이가 뽑아내려고 하는 수의 위치가 순서대로 주어진다. 위치는 1보다 크거나 같고, N보다 작거나 같은 자연수이다.
        - 첫째 줄에 문제의 정답을 출력한다.
    explain :
        - 양방향 순환 큐는 순환 큐를 쓰거나 deque 를 쓰면 된다. 여기서는 deque를 사용한다.
        - 1부터 N까지 있는 순환 큐에서 M개의 원소를 빼낸다. 빼내는 순서에 맞춰서 뺴내야 한다.
        즉, 첫번째 숫자가 뒤에 있는 숫자보다 작다면 첫번째 숫자가 0번 인덱스에 올만큼 돌리면서 cnt++;
        숫자를 뺴낸 뒤에는 그 숫자는 없어진다.
        - 최솟값을 출력해야 한다. 위의 연산을 할 때 뒤에 있는 숫자가 왼쪽으로 갈 때 더 가까운지, 오른쪽으로 갈 때 더 가까운지 생각해야 한다.
        - 즉, 피벗을 설정하여 그 중간값보다 빼야할 값이 큰 경우 removeLast를 하여 값들을 오른쪽으로 점점 민다. 그 반대는 이와 반대 과정을 밟는다.
        - 위의 과정을 한 번 진행할 떄마다 cnt++;
        - 문제점이 있었다. 양 옆으로 빼기만 하면 되는 것이었는데 나는 앞으로만 보내곤 했던 것이다. 양방향으로 나갈 수 있다는 사실을 잊지 말자!
        - 문제점이 하나 더 있었다. ArrayDeque 로는 pivot을 제대로 다루기 어려웠고, target 값이 어디 있는지 찾기 어려웠다.
        결국 LinkedList를 사용해야 한다는 점을 참고하고 다시 진행했다.
 */

//import java.util.ArrayDeque;

import java.util.LinkedList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BK1021_ing {
    static BufferedReader br;
    static StringTokenizer st;
    static int N;
    static int M;
    static LinkedList<Integer> deque;
    static int cnt;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        deque = new LinkedList<>();
        st = new StringTokenizer(br.readLine(), " ");
        int[] temp = new int[M];
        for (int i = 0; i < M; i++) {
            temp[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 1; i <= N; i++) {
            deque.add(i);
        }
//        int pivot = 0;
        cnt = 0;
        for (int i = 0; i < M; i++) {
            if (check(temp[i])) {
                while (temp[i] != deque.get(0)) {
                    deque.addLast(deque.pollFirst());
                    cnt++;
                }
            } else {
                while (temp[i] != deque.get(0)) {
                    deque.addFirst(deque.pollLast());
                    cnt++;
                }
            }
            deque.poll();
//            while (true) {
//                if (temp > pivot) {
//                    while (true) {
//                        if (deque.peekLast() == temp) {
//                            deque.removeLast();
//                            break;
//                        }
//                        deque.addFirst(deque.pollLast());
//                        cnt++;
//                        pivot--;
//                        if (pivot <= 0) {
//                            pivot = deque.size() - 1;
//                        }
//                    }
//                } else {
//                    while (true) {
//                        if (deque.peekFirst() == temp) {
//                            deque.removeFirst();
//                            break;
//                        }
//                        deque.addLast(deque.pollFirst());
//                        cnt++;
//                        pivot++;
//                        if (pivot >= deque.size()) {
//                            pivot = 0;
//                        }
//                    }
//                }
//            }
        }
        System.out.print(cnt);
    }

    public static boolean check(int a) {
        for (int i = 0; i <= deque.size() / 2; i++) {
            if (a == deque.get(i)) {
                return true;
            }
        }
        return false;
    }
}
