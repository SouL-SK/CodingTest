package algorithm_java;
/*
    problem : beakjoon NO.8393
    task : n이 주어졌을 때, 1부터 n까지 합을 구하는 프로그램을 작성하시오.
    check point :
        - n (1 <= n <= 10,000)
        - print sum for 1 to n

 */
import java.util.Scanner;

public class BK8393 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum = 0;
        for(int i = 1; i <= n; i++){
            sum += i;
        }
        System.out.print(sum);
        sc.close();
    }
}
