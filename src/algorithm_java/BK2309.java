package algorithm_java;
/*
    problem : baekjoon NO.2309
    task : 아홉 난쟁이의 키가 주어졌을 때, 백설공주를 도와 일곱 난쟁이를 찾는 프로그램을 작성하시오.
    point :
        - 일곱 난쟁이의 키의 합이 100이 됨
        - 아홉 개의 줄에 걸쳐 난쟁이들의 키가 주어진다. 주어지는 키는 100을 넘지 않는 자연수이며,
        아홉 난쟁이의 키는 모두 다르며, 가능한 정답이 여러 가지인 경우에는 아무거나 출력한다.
        - 일곱 난쟁이의 키를 오름차순으로 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BK2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] N = new int[9];
        int sum = 0;
        int fake1 = 0, fake2 = 0;
        for (int i = 0; i < N.length; i++) {
            N[i] = Integer.parseInt(br.readLine());
            sum += N[i];
        }
        Arrays.sort(N);
        for(int i = 0; i <N.length;i++){
            for(int j = i + 1; j < N.length; j++){
                if(sum - N[i] - N[j] == 100){
                    fake1 = N[i];
                    fake2 = N[j];
                }
            }
        }
        for(int i = 0; i < N.length;i++){
            if(fake1 == N[i] || fake2 == N[i]) continue;
            System.out.println(N[i]);
        }
    }
}
