package algorithm_java;

import java.util.Scanner;

/*
    두 정수 A와 B를 입력받은 다음, A/B를 출력하는 프로그램을 작성하시오.
    실제 정답과 출력값의 절대오차 또는 상대오차가 10-9 이하이면 정답이다.

    해결 : 오차를 줄이기 위해 크기가 더 큰 double을 이용하여 정확도를 높였다.
 */
public class BK1008 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        double A = sc.nextInt();
        double B = sc.nextInt();
        System.out.println(A/B);
        sc.close();
    }
}
