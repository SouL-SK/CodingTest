package algorithm_java;
/*
    problem : baekjoon NO.1145
    task : 다섯 개의 자연수가 있다. 이 수의 적어도 대부분의 배수는 위의 수 중 적어도 세 개로 나누어 지는 가장 작은 자연수이다.
    서로 다른 다섯 개의 자연수가 주어질 때, 적어도 대부분의 배수를 출력하는 프로그램을 작성하시오.
    point :
        - 첫째 줄에 다섯 개의 자연수가 주어진다. 100보다 작거나 같은 자연수이고, 서로 다른 수이다.
        - 첫째 줄에 적어도 대부분의 배수를 출력한다.
        - 최소 3개의 자연수로 나누어지는 값.
        100이하의 서로 다른 자연수이기 때문에, 아무리 커봐야 세 개 자연수의 최소 공배수는 100 * 99 * 98 = 970,200이다.
        - 1부터 탐색을 시작할 수도 있지만, 다섯 개 자연수 중 최소값부터 시작할 수 있다.
        - while문의 종료는 최소 공배수의 최대값인 970,200을 지정하지 않고,
        적어도 세 개의 자연수로 나누어지는 경우를 탈출 조건으로 사용
 */
import java.util.Scanner;

public class BK1145 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int SIZE = 5;
        // 5개의 자연수
        int[] arr = new int[SIZE];
        int min = 100;

        // 자연수 입력. 100보다 작거나 같은 서로 다른 자연수
        for (int i = 0; i < SIZE; i++) {
            arr[i] = sc.nextInt();
            if (min > arr[i]) {
                min = arr[i];
            }
        }

        int cnt = 0;
        while (true) {  // 나올 수 있는 가장 큰 값은 100 * 99 * 98 = 970,200
            for (int i = 0; i < SIZE; i++) {
                if (min % arr[i] == 0) cnt++;
            }
            // 적어도 세 개의 자연수로 나누어지는 경우 반복문 탈출
            if (cnt >= 3) break;
            cnt = 0;
            min++;
        }
        System.out.println(min);
    }
}