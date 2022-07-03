package algorithm_java;
/*
    problem : baekjoon NO.1526
    task : N이 주어졌을 때, N보다 작거나 같은 금민수 중 가장 큰 것을 출력하는 프로그램을 작성하시오.
    point :
        - 금민수는 어떤 수가 4와 7로만 이루어진 수를 말한다.
        - 첫째 줄에 N이 주어진다. N은 4보다 크거나 같고 1,000,000보다 작거나 같은 자연수이다.
        - 첫째 줄에 N보다 작거나 같은 금민수 중 가장 큰 것을 출력한다.
        - 반복문 두개로 4또는 7로 이루어진 값을 찾을때까지.
        그렇게 나온 값은 무조건 입력받은 값 이하에서 제일 큰 값일 것이다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BK1526 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String N = br.readLine();
        //-1을 몇번을 해야할지 모르기때문에 무한루프로 반복
        while (true) {
            //4와 7로만 이루어진 값인지 판단하기 위한 변수
            boolean check = true;
            //해당 인덱스에 4와 7 둘다 아니면 check에 false를 저장하고 반복문 종료
            for (int i = 0; i < N.length(); i++) {
                if (N.charAt(i) != '4' && N.charAt(i) != '7') {
                    check = false;
                    break;
                }
            }
            //해당 값이 4와 7이라면 check는 true일 것이고, true라면 반복문 종료
            //false라면 해당 값에 -1을 해준다. 입력받은건 String이기 때문에 형변환을 해줘서 빼주고, 다시 형변환
            if (check) break;
            else N = String.valueOf(Integer.parseInt(N) - 1);
        }
        System.out.println(N);
    }

}