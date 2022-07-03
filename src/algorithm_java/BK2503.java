package algorithm_java;
/*
    problem : baekjoon NO.2503
    task : 민혁이의 물음들과 각각의 물음에 대한 영수의 답이 입력으로 주어질 때 영수가 생각하고 있을 가능성이 있는 답의 총 개수를 출력하는 프로그램을 작성하시오.
    point :
        - 째 줄에는 민혁이가 영수에게 몇 번이나 질문을 했는지를 나타내는 1 이상 100 이하의 자연수 N이 주어진다. 이어지는 N개의 줄에는 각 줄마다 민혁이가 질문한 세 자리 수와 영수가 답한 스트라이크 개수를 나타내는 정수와 볼의 개수를 나타내는 정수, 이렇게 총 세 개의 정수가 빈칸을 사이에 두고 주어진다.
        - 첫 줄에 영수가 생각하고 있을 가능성이 있는 답의 총 개수를 출력한다.
        - 입력으로 주어진 숫자야구에 대한 스트라이크 / 볼 값을 모두 만족하는 경우의 수를 찾는 문제이다.
        - 122 와 0이 들어갈 수 없는 제한이 있다. 그러므로 123 ~ 987에 대해서 중복되는 경우와 0인 경우를 걸러 모두 반복문을 돌려주면 된다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BK2503 {
    static int n;
    static List<BaseBallData> inputData = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        n = Integer.parseInt(s);

        for (int i = 0; i < n; i++) {
            s = br.readLine();
            StringTokenizer st = new StringTokenizer(s, " ");
            int data = Integer.parseInt(st.nextToken());
            int strike = Integer.parseInt(st.nextToken());
            int ball = Integer.parseInt(st.nextToken());

            BaseBallData baseBallData = new BaseBallData(data, strike, ball);
            inputData.add(baseBallData);
        }

        System.out.println(calBaseBall());
    }

    static int calBaseBall() {
        int result = 0;

        for (int i = 123; i <= 987; i++) {
            if (!checkSameNum(i)) continue; // 중복숫자

            int allTestPass = 0;

            for (int j = 0; j < n; j++) {
                int strikeCount = 0;
                int ballCount = 0;

                BaseBallData current = inputData.get(j);
                String currentDataString = Integer.toString(current.data);
                String myDataString = Integer.toString(i);

                for (int k = 0; k < 3; k++) { // strike
                    if (currentDataString.charAt(k) == myDataString.charAt(k)) {
                        strikeCount++;
                    }
                }

                for (int h = 0; h < 3; h++) {
                    for (int u = 0; u < 3; u++) {
                        if (myDataString.charAt(h) == currentDataString.charAt(u)) { // ball
                            if (h != u)
                                ballCount++;
                        }
                    }
                }

                if (current.strike == strikeCount && current.ball == ballCount) {
                    allTestPass++;
                }
            }
            if (allTestPass == n) {
                result++;
            }
        }
        return result;
    }

    static boolean checkSameNum(int num) {

        String numString = Integer.toString(num);

        if (numString.charAt(0) == numString.charAt(1)) {
            return false;
        }

        if (numString.charAt(1) == numString.charAt(2)) {
            return false;
        }

        if (numString.charAt(0) == numString.charAt(2)) {
            return false;
        }

        if (numString.charAt(0) == '0' || numString.charAt(1) == '0' || numString.charAt(2) == '0')
            return false;

        return true;
    }

    static class BaseBallData {
        int data;
        int strike;
        int ball;

        public BaseBallData(int data, int strike, int ball) {
            this.data = data;
            this.strike = strike;
            this.ball = ball;
        }
    }
}