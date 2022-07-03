package algorithm_java;
/*
    problem : baekjoon NO.2675
    task : 문자열 S를 입력받은 후에, 각 문자를 R번 반복해 새 문자열 P를 만든 후 출력하는 프로그램을 작성하시오.
    point :
        - 첫 번째 문자를 R번 반복하고, 두 번째 문자를 R번 반복하는 식으로 P를 만들면 된다.
        - 첫째 줄에 테스트 케이스의 개수 T(1 ≤ T ≤ 1,000)가 주어진다.
        각 테스트 케이스는 반복 횟수 R(1 ≤ R ≤ 8), 문자열 S가 공백으로 구분되어 주어진다.
        S의 길이는 적어도 1이며, 20글자를 넘지 않는다.
        - 각 테스트 케이스에 대해 P를 출력한다.
        - Scanner 를 사용할 때, next()는 공백을 읽어들이지 않는다, nextLine()은 공백을 읽어들인다.
        -
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BK2675 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 0; i < T; i++) {

            String[] str = br.readLine().split(" ");	// 공백 분리

            int R = Integer.parseInt(str[0]);	// String -> int
            String S = str[1];

            for(int j = 0; j < S.length(); j++) {
                for(int k = 0; k < R; k++) {
                    System.out.print(S.charAt(j));
                }
            }
            System.out.println();
        }
    }
}
