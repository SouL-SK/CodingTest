package algorithm_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
   백준 11720번

   문제 : N개의 숫자가 공백 없이 쓰여있다. 이 숫자를 모두 합해서 출력하라.

   풀이
    - 두번째 줄에서 받는 입력은 엔터 없이 받아들이기 때문에 readLine으로 받는다.
    - 아스키 코드로 변환해서 연산하기 떄문에 48을 빼주어야 한다.
 */
public class BK11720 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int temp = Integer.parseInt(br.readLine());
        int sum = 0;
        for (int i = 0; i < temp;i++){
            sum += br.read() - 48;
        }
        System.out.print(sum);
    }
}
