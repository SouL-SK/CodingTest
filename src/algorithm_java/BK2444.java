package algorithm_java;
/*
    problem : baekjoon NO.2444
    task : 예제를 보고 규칙을 유추한 뒤에 별을 찍어 보세요.
    check point :
        - 별 찍기 전 시리즈를 다 합친 것과 같다.

 */

import java.util.Scanner;

public class BK2444 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int k = n - i; k > 1; k--) {
                System.out.print(" ");
            }
            for (int k = n; k >= n - i; k--) {
                System.out.print("*");
            }
            for (int k = n - i; k < n; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
        for (int i = 1; i < n; i++) {
            for (int k = n-i; k < n; k++) {
                System.out.print(" ");
            }
            for (int k = n-i; k > 0; k--) {
                System.out.print("*");
            }
            for (int k = n - i; k > 1; k--) {
                System.out.print("*");
            }
            System.out.println();
        }
        sc.close();
    }
}
