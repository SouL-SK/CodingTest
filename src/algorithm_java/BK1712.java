package algorithm_java;
/*
    problem : baekjoon NO.1712 손익분기점
    task : 총 수입(판매비용)이 총 비용(=고정비용+가변비용)보다 많아지게 되는 지점을 찾는 프로그램을 작성하라.
        최초로 총 수입이 총 비용보다 많아져 이익이 발생하는 지점을 손익분기점(BREAK-EVEN POINT)이라고 한다.
    check point :
        - A(고정비용) + B(가변비용) * n <= C * n 일 때의 n(최초의 이익이 발생하는 판매 대수) 를 구하라
        - nC = A + nB -> nC - nB = A -> n(C-B) = A -> n = A/(C-B) 이 값은 총 수익이 같아지는 지점이다.
        - 이익이 나는 지점을 찾으려면 result += 1 을 해야 한다.
        - java.lang.ArithmeticException : / by zero가 발생하기 때문에 B 와 C 가 같아 분모가 0이 되는 경우를 방지한다.

 */

import java.util.Scanner;

public class BK1712 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();
        if (B != C) {
            int result = A / (C - B);
            if (result < 0) {
                System.out.print(-1);
            } else {
                result++;
                System.out.print(result);
            }
        } else {
            System.out.print(-1);
        }
        sc.close();
    }
}
