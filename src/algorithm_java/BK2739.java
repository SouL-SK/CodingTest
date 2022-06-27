package algorithm_java;

import java.util.Scanner;

/*
    문제 : 백준 2739번 구구단

    설명: N을 입력받은 뒤, 구구단 N단을 출력하는 프로그램을 작성하라.

    풀이>
     - 출력 양식을 준수해야함.
     - 첫째 줄에 N이 주어진다. (1 <= N <= 9)
     - 1 단 부터 9 단 까지 출
 */
public class BK2739 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for(int i = 1; i < 10; i++){
            System.out.print(N + " * "+ i + " = "+ N*i + "\n");
        }
        sc.close();
    }
}
