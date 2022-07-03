package algorithm_java;
/*
    problem : baekjoon NO.8958
    task : "OOXXOXXOOO"와 같은 OX퀴즈의 결과가 있다. O는 문제를 맞은 것이고, X는 문제를 틀린 것이다.
    문제를 맞은 경우 그 문제의 점수는 그 문제까지 연속된 O의 개수가 된다. 예를 들어, 10번 문제의 점수는 3이 된다.
    "OOXXOXXOOO"의 점수는 1+2+0+0+1+0+0+1+2+3 = 10점이다. OX퀴즈의 결과가 주어졌을 때, 점수를 구하는 프로그램을 작성하시오.
    point :
        - 첫째 줄에 테스트 케이스의 개수가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있고, 길이가 0보다 크고 80보다 작은 문자열이 주어진다. 문자열은 O와 X만으로 이루어져 있다.
        - 각 테스트 케이스마다 점수를 출력한다.
        - O 의 연속 개수 만큼 점수를 누적하여 합산하고 X가 나오면 누적값은 0으로 초기화 된다.

 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BK8958 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int test_case = Integer.parseInt(br.readLine());    //테스트 케이스

//      배열을 사용하지 않은 방법
        for (int i = 0; i < test_case; i++) {

            int cnt = 0; // 연속횟수
            int sum = 0; // 누적 합산

            for (byte value : br.readLine().getBytes()) {

                if (value == 'O') {
                    cnt++;
                    sum += cnt;
                }
                else {
                    cnt = 0;
                }
            }

            sb.append(sum).append('\n');

        }
        System.out.println(sb);

//        배열을 사용한 방법
//        String arr[] = new String[test_case];
//
//        for (int i = 0; i < test_case; i++) {
//            arr[i] = br.readLine();
//        }
//        for (int i = 0; i < test_case; i++) {
//
//            int cnt = 0;    // 연속횟수
//            int sum = 0;    // 누적 합산
//
//            for (int j = 0; j < arr[i].length(); j++) {
//                if (arr[i].charAt(j) == 'O') {
//                    cnt++;
//                } else {
//                    cnt = 0;
//                }
//                sum += cnt;
//            }
//            sb.append(sum).append('\n');
//        }
//        System.out.print(sb);
    }
}