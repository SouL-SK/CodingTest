package algorithm_java;
/*
	problem : beakjoon NO.2438
	task : print a star in first line, two stars in second line, ... , N stars in N'nd line
	check point :
		- 1 <= N <= 100
		- use for sentence
 */

import java.util.Scanner;

public class BK2438 {
    public static void main(String[] agrs) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        for (int j = 1; j < N + 1; j++) {
            for (int i = 1; i < j + 1; i++) {
                System.out.printf("*");
            }
            System.out.println(" ");
        }
        sc.close();

    }
}
