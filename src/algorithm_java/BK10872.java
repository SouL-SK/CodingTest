package algorithm_java;
/*
    problem : baekjoon NO.10872
    task : 0보다 크거나 같은 정수 N이 주어진다. 이때, N!을 출력하는 프로그램을 작성하시오.
    point :
        - 첫째 줄에 정수 N(0 ≤ N ≤ 12)이 주어진다.
 */
import java.util.Scanner;

public class BK10872 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        in.close();
        int sum = 1;
        for(int i = 1; i <= N; i++){
            sum *= i;
        }
        System.out.print(sum);
    }
}
