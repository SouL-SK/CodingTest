package algorithm_java;
/*
    problem : baekjoon NO.13410
    task : 단의 수 N과 항의 수 K가 주어질 때, 거꾸로 구구단의 가장 큰 값을 출력하는 프로그램을 작성하시오.
    point :
        -
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BK13410 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int max = Integer.MIN_VALUE;
        for (int i = 1; i <= K; i++) {
            int temp = N * i;
            String s = String.valueOf(temp);
            StringBuilder sb = new StringBuilder();
            for (int j = s.length() - 1; j >= 0; j--) {
                sb.append(s.charAt(j));
            }
            max = Math.max(max, Integer.parseInt(sb.toString()));
        }
        System.out.println(max);
    }
}