package algorithm_java;
/*
    problem : beakjoon NO.11022
    task : input A, B and print A + B
    check point :
        - there is many test cases for calculate
        - every test case is just one line
        - first input value is loop count
        - get A and B's inputs for loop count
        - print "Case #n: A + B = C" format, start from 1.
 */

import java.util.Scanner;

public class BK11022 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int loopCount = sc.nextInt();
        for(int i = 1; i <= loopCount;i++){
            int A = sc.nextInt();
            int B = sc.nextInt();
            System.out.println("Case #"+i+": "+A+" + "+B+" = "+(A+B));
        }
        sc.close();
    }
}
