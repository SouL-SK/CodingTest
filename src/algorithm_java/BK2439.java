package algorithm_java;
/*
    problem : beakjoon NO.2439
    task : print a star in first line, two stars in second line, ... , N stars in N'nd line.
        but, align-right
    check point :
        - print stars from right to left
        - use space and stars
 */

import java.util.Scanner;

public class BK2439 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            for (int j = N - i; j > 1; j--){
                System.out.print(" ");
            }
            for(int k = 0; k <= i; k++){
                System.out.print("*");
            }
                System.out.println();
        }
        sc.close();
    }
}
