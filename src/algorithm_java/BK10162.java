package algorithm_java;
/*
    problem : baekjoon NO.10162
    category : math, implement, greedy algorithm
    task : 3개의 시간조절용 버튼 A B C가 달린 전자레인지가 있다.
    각 버튼마다 일정한 시간이 지정되어 있어 해당 버튼을 한번 누를 때마다 그 시간이 동작시간에 더해진다.
    버튼 A, B, C에 지정된 시간은 각각 5분, 1분, 10초이다.
    여러분은 주어진 요리시간 T초를 맞추기 위한 최소버튼 조작 방법을 구하는 프로그램을 작성해야 한다.
    point :
        - 첫 번째 줄에는 요리시간 T(초)가 정수로 주어져 있으며 그 범위는 1 ≤ T ≤ 10,000 이다.
        - 여러분은 T초를 위한 최소버튼 조작의 A B C 횟수를 첫 줄에 차례대로 출력해야 한다.
        각각의 횟수 사이에는 빈 칸을 둔다. 해당 버튼을 누르지 않는 경우에는 숫자 0을 출력해야한다.
        만일 제시된 3개의 버튼으로 T초를 맞출 수 없으면 음수 -1을 첫 줄에 출력해야 한다.
 */

import java.util.Scanner;

public class BK10162 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        int A = 0;
        int B = 0;
        int C = 0;

        if (T >= 300) {
            A = T / 300;
            T -= 300 * A;
        }
        if (T >= 60) {
            B = T / 60;
            T -= 60 * B;
        }
        if (T % 10 != 0) {
            System.out.print(-1);
        } else {
            C = T / 10;
            System.out.print(A + " " + B + " " + C);
        }
        in.close();
    }
}
