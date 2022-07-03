package algorithm_java;
/*
    problem : baekjoon NO.1439
    task : 다솜이는 0과 1로만 이루어진 문자열 S를 가지고 있다.
    다솜이는 이 문자열 S에 있는 모든 숫자를 전부 같게 만들려고 한다.
    다솜이가 할 수 있는 행동은 S에서 연속된 하나 이상의 숫자를 잡고 모두 뒤집는 것이다.
    뒤집는 것은 1을 0으로, 0을 1로 바꾸는 것을 의미한다.
    point :
        - 문자열 S가 주어졌을 때, 다솜이가 해야하는 행동의 최소 횟수를 출력하시오.
        - 범위를 지정해서 뒤집을 수도 있다.
        - 아래 이미지에서 첫줄 '11'을 바꿈으로써 그 양옆 '00'들을 한꺼번에 바꿀 수 있는 것 처럼 중간에 있는 무언가를 바꾼다면,
        그 다음 더 넓은 지역을 바꾸는데 도움이 된다고 생각할 수 있다. 그래서 어떻게 생각할 지 어렵게 여겨질 수 있다.
        하지만 이러한 경우에 어떻게 하든 결국 중간중간 바꾼 것과,
        모든 연속된 1 토큰을 0으로 바꾸거나 모든 연속된 0 토큰을 1로 바꾸는 것 중 작은쪽은 횟수가 똑같다.
        무슨 말이냐면 그냥 아래와 같이 연속된 1로 구성된 토큰의 개수와,
        연속된 0으로 구성된 토큰의 개수 중 작은쪽을 출력하면 끝나는 아주 간단한 문제라는 얘기이다.
        (만약 '11111' 이런식이었다면 0으로 된 토큰이 0일 것이므로 0이 답)
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BK1439 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringTokenizer st_1 = new StringTokenizer(S, "1");
        StringTokenizer st_0 = new StringTokenizer(S, "0");
        System.out.print(Math.min(st_1.countTokens(), st_0.countTokens()));

    }
}
