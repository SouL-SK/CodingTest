package algorithm_java;
/*
    problem : baekjoon NO.1316
    task : 그룹 단어란 단어에 존재하는 모든 문자에 대해서, 각 문자가 연속해서 나타나는 경우만을 말한다.
    예를 들면, ccazzzzbb는 c, a, z, b가 모두 연속해서 나타나고, kin도 k, i, n이 연속해서 나타나기 때문에 그룹 단어이지만,
    aabbbccb는 b가 떨어져서 나타나기 때문에 그룹 단어가 아니다.
    단어 N개를 입력으로 받아 그룹 단어의 개수를 출력하는 프로그램을 작성하시오.
    point :
        - 첫째 줄에 단어의 개수 N이 들어온다.
        N은 100보다 작거나 같은 자연수이다.
        둘째 줄부터 N개의 줄에 단어가 들어온다.
        단어는 알파벳 소문자로만 되어있고 중복되지 않으며, 길이는 최대 100이다.
        - 첫째 줄에 그룹 단어의 개수를 출력한다.
        - 문자열의 문자가 연속되지 않으면서 이미 앞서 해당 문자가 입력된 적이 있을 경우 그룹 단어가 아니다.
        - 그룹 단어의 개수를 출력해야한다.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BK1316 {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException{
        int count = 0;
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            if (check()) {
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean check() throws IOException {
        boolean[] check = new boolean[26];
        int prev = 0;
        String str = br.readLine();
        for(int i = 0; i < str.length(); i++) {
            int now = str.charAt(i);	// i 번째 문자 저장 (현재 문자)

            // 앞선 문자와 i 번째 문자가 같지 않다면?
            if (prev != now) {
                // 해당 문자가 처음 나오는 경우 (false 인 경우)
                if (!check[now - 'a']) {

                    check[now - 'a'] = true;		// true 로 바꿔준다

                    prev = now;					// 다음 턴을 위해 prev 도 바꿔준다
                }
                // 해당 문자가 이미 나온 적이 있는 경우 (그룹단어가 아니게 됨)
                else {
                    return false;	//함수 종료
                }
            }
            // 앞선 문자와 i 번째 문자가 같다면? (연속된 문자)
        }
        return true;
    }
}
