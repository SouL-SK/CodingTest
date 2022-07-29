package algorithm_java;
/*
    problem : baekjoon NO.6603
    task : 집합 S와 k가 주어졌을 때, 수를 고르는 모든 방법을 구하는 프로그램을 작성하시오.
    point :
        - 입력은 여러 개의 테스트 케이스로 이루어져 있다. 각 테스트 케이스는 한 줄로 이루어져 있다. 첫 번째 수는 k (6 < k < 13)이고, 다음 k개 수는 집합 S에 포함되는 수이다.
        S의 원소는 오름차순으로 주어진다. 입력의 마지막 줄에는 0이 하나 주어진다.
        - 각 테스트 케이스마다 수를 고르는 모든 방법을 출력한다. 이때, 사전 순으로 출력한다. 각 테스트 케이스 사이에는 빈 줄을 하나 출력한다.
        - 부분 집합들을 구해야 한다.
        - 백트래킹을 활용한 dfs 이다.
    explain :
    conclusion :
        elapsed time : 376 ms, memory : 20512 kb
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BK6603 {

    static int K;
    static int[] S;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            K = Integer.parseInt(st.nextToken());
            if (K == 0) {
                break;
            }
            S = new int[K];
            visit = new boolean[K];
            for (int i = 0; i < K; i++) {
                S[i] = Integer.parseInt(st.nextToken());
            }
//            for (int i = 0; i < list.length; i++) {
//                System.out.print(list[i] + " ");
//            }
//            System.out.println();
            dfs(0, 0);
            System.out.println();
        }

    }

    public static void dfs(int start, int depth) {
        if (depth == 6) {
            for (int i = 0; i < K; i++) {
                if (visit[i]) {
                    System.out.print(S[i] + " ");
                }
            }
            System.out.println();
        }
        for (int i = start; i < K; i++) {
            visit[i] = true;
            dfs(i + 1, depth + 1);
            visit[i] = false;
        }
    }

}
