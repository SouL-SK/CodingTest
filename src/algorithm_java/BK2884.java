package algorithm_java;
/*
    problem : baekjoon NO.2884 알람시계
    task : set alarm 45 minute early
    check point :
        - don't print unnecessary 0s.
        - print 24 hour (0:0 to 23:59)
        - print time of 45 min early
 */

import java.util.Scanner;

public class BK2884 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int hour = sc.nextInt();
        int min = sc.nextInt();
        int[] time = new int[2];
        time[0] = hour;
        time[1] = min - 45;
        if (time[1] < 0) {
            int temp = time[1];
            time[0]--;
            if (time[0] < 0) {
                time[0] = 23;
            }
            time[1] = 60 + temp;
        }
        for (int j : time) {
            System.out.print(j + " ");
        }
        sc.close();
    }
}
