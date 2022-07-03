package algorithm_java;
/*
    problem : baekjoon NO.2231
    task : 자연수 N이 주어졌을 때, N의 가장 작은 생성자를 구해내는 프로그램을 작성하시오.
    point :
        - 어떤 자연수 N이 있을 때, 그 자연수 N의 분해합은 N과 N을 이루는 각 자리수의 합을 의미한다.
        어떤 자연수 M의 분해합이 N인 경우, M을 N의 생성자라 한다.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BK2231 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int result = 0;

        for(int i = 0; i < N; i++) {
            int number = i;
            int sum = 0;	// 각 자릿수 합 변수

            while(number != 0) {
                sum += number % 10;	// 각 자릿수 더하기
                number /= 10;
            }

            // i 값과 각 자릿수 누적합이 같을 경우 (생성자를 찾았을 경우)
            if(sum + i == N) {
                result = i;
                break;
            }
        }
        System.out.println(result);
    }
}
