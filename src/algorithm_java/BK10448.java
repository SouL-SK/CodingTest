package algorithm_java;
/*
    problem : baekjoon NO.10448
    task : 자연수가 주어졌을 때, 그 정수가 정확히 3개의 삼각수의 합으로 표현될 수 있는지 없는지를 판단해주는 프로그램을 만들어라.
    단, 3개의 삼각수가 모두 달라야 할 필요는 없다.
    point :
        - 프로그램은 표준입력을 사용한다. 테스트케이스의 개수는 입력의 첫 번째 줄에 주어진다.
        각 테스트케이스는 한 줄에 자연수 K (3 ≤ K ≤ 1,000)가 하나씩 포함되어있는 T개의 라인으로 구성되어있다.
        - 프로그램은 표준출력을 사용한다. 각 테스트케이스에대해 정확히 한 라인을 출력한다.
        만약 K가 정확히 3개의 삼각수의 합으로 표현될수 있다면 1을, 그렇지 않다면 0을 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BK10448 {
    static int countarr[];
    static int result[];

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int count = Integer.parseInt(st.nextToken());

        countarr = new int[count];
        result = new int[count];

        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            countarr[i] = Integer.parseInt(st.nextToken());
        }

        int math[] = new int[44];

        for (int i = 1; i < 44; i++) {
            math[i] = (i * (i + 1)) / 2;
        }


        for (int i = 1; i < 44; i++) {
            for (int j = 1; j < 44; j++) {
                for (int k = 1; k < 44; k++) {
                    int sum = 0;
                    sum += math[i] + math[j] + math[k];
                    matching(sum);
                }
            }
        }

        for (int i = 0; i < countarr.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static void matching(int sum) {
        for (int i = 0; i < countarr.length; i++) {

            if (result[i] != 1) {
                if (countarr[i] == sum) {
                    result[i] = 1;
                } else {
                    result[i] = 0;
                }
            }
        }
    }
}