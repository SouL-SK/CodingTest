package algorithm_java;
/*
    problem : 2851
    task : 마리오는 받은 점수의 합을 최대한 100에 가깝게 만들려고 한다.
    버섯의 점수가 주어졌을 때, 마리오가 받는 점수를 출력하는 프로그램을 작성하시오.
    point :
        - 총 10개의 줄에 각각의 버섯의 점수가 주어진다.
        이 값은 100보다 작거나 같은 양의 정수이다. 버섯이 나온 순서대로 점수가 주어진다.
        - 첫째 줄에 마리오가 받는 점수를 출력한다. 만약 100에 가까운 수가 2개라면 (예: 98, 102) 마리오는 큰 값을 선택한다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BK2851 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = 0;
        int result = 0;
        for (int i = 0; i < 10; i++) {
            int a = Integer.parseInt(br.readLine());
            if (s < 100) {
                s += a;
                if (Math.abs(result - 100) > Math.abs(s - 100)) {
                    result = s;
                } else if (Math.abs(result - 100) == Math.abs(s - 100)) {
                    result = Math.max(result, s);
                }
            }
        }
        System.out.println(result);
    }
}
