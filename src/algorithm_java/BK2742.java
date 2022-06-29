package algorithm_java;
/*
    problem : beakjonn NO.2742
    task : 자연수 N이 주어졌을 때, N부터 1까지 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
    check point :
        - use for sentence
        - just print number up to down
 */

import java.util.Scanner;

public class BK2742 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i = n; i > 0; i--){
            System.out.println(i);
        }
        sc.close();
    }
}
