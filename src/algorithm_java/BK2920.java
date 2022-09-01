package algorithm_java;
/*
    problem : 다장조는 c d e f g a b C, 총 8개 음으로 이루어져있다.
        이 문제에서 8개 음은 다음과 같이 숫자로 바꾸어 표현한다. c는 1로, d는 2로, ..., C를 8로 바꾼다.
        1부터 8까지 차례대로 연주한다면 ascending, 8부터 1까지 차례대로 연주한다면 descending, 둘 다 아니라면 mixed 이다.
        연주한 순서가 주어졌을 때, 이것이 ascending인지, descending인지, 아니면 mixed인지 판별하는 프로그램을 작성하시오.
    task : 첫째 줄에 8개 숫자가 주어진다. 이 숫자는 문제 설명에서 설명한 음이며, 1부터 8까지 숫자가 한 번씩 등장한다.
        첫째 줄에 ascending, descending, mixed 중 하나를 출력한다.
    point :
        - 조건문으로 케이스를 나눠야 한다.
        - 특수한 케이스를 잘 봐야 한다. 중간에 flag가 바뀌는 경우도 mixed로 처리하는 것을 잊지 말자.
        - 처음 시작 flag가 0인 점을 생각하고 loop의 두번째 사이클부터 flag 중복 체크를 해야 한다.
    explain :
    conclusion : 두 번 정도 반례에서 걸렸지만 그리 오래 걸리지 않고 풀 수 있었다. 다시 코테 준비에 열 좀 올리자.
        memory : 14188 kb, elapsed time : 124ms, time complexity : O(n)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class BK2920{
    static String[] result = new String[]{"ascending", "descending", "mixed"};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int flag = 0;
        for (int i = 0; i < 4; i++) {
            int now = Integer.parseInt(st.nextToken());
            int future = Integer.parseInt(st.nextToken());
            int temp = now - future;
            int tempFlag = flag;
            if ((temp != 1) && (temp != -1)) {
                flag = 2;
                break;
            }
            if (temp == -1) {
                flag = 0;
            }
            if (temp == 1) {
                flag = 1;
            }
            if((tempFlag != flag)&&(i >0)){
                flag = 2;
                break;
            }
        }
        System.out.print(result[flag]);
    }
}
