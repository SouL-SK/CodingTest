package algorithm_java;
/*
    problem : baekjoon NO.7568
    task : N명의 집단에서 각 사람의 덩치 등수는 자신보다 더 "큰 덩치"의 사람의 수로 정해진다.
    만일 자신보다 더 큰 덩치의 사람이 k명이라면 그 사람의 덩치 등수는 k+1이 된다.
    이렇게 등수를 결정하면 같은 덩치 등수를 가진 사람은 여러 명도 가능하다.
    point :
        - 키와 몸무게가 모두 클 때에만 '덩치가 크다' 라고 정의하고 있다.
        - 여러분은 입력에 나열된 사람의 덩치 등수를 구해서 그 순서대로 첫 줄에 출력해야 한다.
        단, 각 덩치 등수는 공백문자로 분리되어야 한다.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BK7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];
        String[] sp;
        for(int i = 0; i < N; i++) {
            sp = br.readLine().split(" ");			// 문자열 분리
            arr[i][0] = Integer.parseInt(sp[0]);	// [i][0] : 몸무게
            arr[i][1] = Integer.parseInt(sp[1]);	// [i][1] : 키
        }

        for(int i = 0; i < N; i++) {
            int rank = 1;
            for(int j = 0; j < N; j++) {
                if(i == j) continue;
                if (arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1]) {
                    rank++;
                }
            }
            System.out.print(rank + " ");
        }
    }
}