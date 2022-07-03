package algorithm_java;
/*
    problem : baekjoon NO.1065
    task : 어떤 양의 정수 X의 각 자리가 등차수열을 이룬다면, 그 수를 한수라고 한다. 등차수열은 연속된 두 개의 수의 차이가 일정한 수열을 말한다. N이 주어졌을 때, 1보다 크거나 같고, N보다 작거나 같은 한수의 개수를 출력하는 프로그램을 작성하시오.
    point :
        - 1 보다 크고 입력받은 값보다 작거나 같은 한수의 개수를 출력한다.
        - 한수는 각 자리수가 등차수열을 이루는 수를 의미한다.
        - 등차수열(arithmetic sequence). 즉 연속하는 두 항의 차이가 모두 일정한 수열을 의미한다
        - 두 항의 차이를 d 라고 할 때, n 번째 항은 초항과 (n-1) * d 의 합과 같다는 것이다.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BK1065 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print(arithmetic_sequence(Integer.parseInt(br.readLine())));
    }
    public static int arithmetic_sequence(int num) {
        int cnt = 0; // 한수 카운팅
        if (num < 100) {
            return num;
        }
        else {
            cnt = 99;
            for (int i = 100; i <= num; i++) {
                int hun = i / 100; // 백의 자릿수
                int ten = (i / 10) % 10; // 십의 자릿수
                int one = i % 10;

                if ((hun - ten) == (ten - one)) { // 각 자릿수가 수열을 이루면
                    cnt++;
                }
            }
        }
        return cnt;
    }
}