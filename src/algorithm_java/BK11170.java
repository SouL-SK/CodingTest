package algorithm_java;
/*
    problem : baekjoon NO.11170
    task : N부터 M까지의 수들을 종이에 적었을 때 종이에 적힌 0들을 세는 프로그램을 작성하라.
    point :
        - N, M이 각각 0, 10일 때 0을 세면 0에 하나, 10에 하나가 있으므로 답은 2이다.
        - 첫 번째 줄에 테스트 케이스의 수 T가 주어진다.
        - 각각의 테스트 케이스마다 N부터 M까지의 0의 개수를 출력한다.
 */

import java.util.Scanner;

public class BK11170 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();

        for (int i = 0; i < T; i++) {
            int N = in.nextInt();
            int M = in.nextInt();

            int cnt = 0;
            for (int j = N; j <= M; j++) {
                int t = j;
                if (t == 0) {
                    cnt++;
                    continue;
                }
                while (t > 1) {
                    if (t % 10 == 0) {
                        cnt++;
                    }
                    t /= 10;
                }
            }
            System.out.println(cnt);
        }
        in.close();
    }
}
