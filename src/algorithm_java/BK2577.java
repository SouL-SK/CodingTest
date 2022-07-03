package algorithm_java;
/*
    problem : baekjoon NO.2577
    task : 세 개의 자연수 A, B, C가 주어질 때 A × B × C를 계산한 결과에 0부터 9까지 각각의 숫자가 몇 번씩 쓰였는지를 구하는 프로그램을 작성하시오.
    point :
        - 예를 들어 A = 150, B = 266, C = 427 이라면 A × B × C = 150 × 266 × 427 = 17037300 이 되고, 계산한 결과 17037300 에는 0이 3번, 1이 1번, 3이 2번, 7이 2번 쓰였다
        - 첫째 줄에는 A × B × C의 결과에 0 이 몇 번 쓰였는지 출력한다. 마찬가지로 둘째 줄부터 열 번째 줄까지 A × B × C의 결과에 1부터 9까지의 숫자가 각각 몇 번 쓰였는지 차례로 한 줄에 하나씩 출력한다.
        - O(N)
        - Scanner 보다 BufferedReader가 성능이 좋다.
        - 먼저 0부터 9까지 체크할 길이 10의 int 배열을 생성한다. (기본 int배열 초기값은 모두 0이다.)
        그리고 val 에다가 br.readLine() 으로 읽은 값을 곱해서 저장한다.
        그리고 String str 에다가 val 의 Int 형을 String 형으로 변환해준 뒤
        for문을 통해 해당 문자열의 문자 값 - 48 (또는 -'0')을 추출해내 int 배열의 index 값을 1 증가시킨다.



마지막으로 배열 원소에 저장된 모든 원소를 출력한다.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class BK2577 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] numList = new int[10];

        int val = Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine()) * Integer.parseInt(br.readLine());
        br.close();
        String str = String.valueOf(val);

        for(int i = 0; i < str.length();i++){
            numList[(str.charAt(i) - 48)]++;
        }

        for(int i : numList){
            System.out.println(i);
        }
    }
}
