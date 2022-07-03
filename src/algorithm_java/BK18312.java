package algorithm_java;
/*
    problem : baekjoon NO.18312
    task : 정수 N과 K가 입력되었을 때 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 K가 하나라도 포함되는 모든 시각을 세는 프로그램을 작성하시오.
    point :
        -  첫째 줄에 정수 N과 K가 공백을 기준으로 구분되어 주어진다. (0≤N≤23, 0≤K≤9)
        - 00시 00분 00초부터 N시 59분 59초까지의 모든 시각 중에서 K가 하나라도 포함되는 시각들의 수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BK18312 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int h = 0, m = 0, s = 0, cnt = 0;
        while (true) {
            String time = ((h < 10) ? "0" + h : "" + h) + ((m < 10) ? "0" + m : "" + m) + ((s < 10) ? "0" + s : "" + s);
            if (time.indexOf("" + k) != -1) cnt++;
            if (h == n && m == 59 && s == 59) break;
            s++;
            if (s == 60) {
                s = 0;
                m++;
            }
            if (m == 60) {
                m = 0;
                h++;
            }
        }
        System.out.print(cnt);
    }
}
