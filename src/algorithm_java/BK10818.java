package algorithm_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    백준 10818번 최소, 최대

    문제 : n 개의 정수가 주어진다. 총 합을 구하시오

    풀이
        - 문자열을 받기 때문에 버퍼사용
        - 오답 판정을 어디서 찾을지 생각중 (채점이 오래 걸려서 오답 판정이 나오는 것을 보니 시간 초과 문제
        - minNum값과 maxNum값의 초기값을 변경해보자.
        -> 기존 정수 최대값과 최소값에서 배열의 1번째 인덱스 값으로 변경했더니 정답이 되었다.
 */
public class BK10818{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String str = br.readLine();
        String[] strList = str.split(" ");
        int[] array = new int[strList.length];
        for(int i = 0;i < strList.length;i++){
            array[i] = Integer.parseInt(strList[i]);
        }

        int minNum = array[0];
        int maxNum = array[0];
        for (int j : array) {
            if (j >= maxNum) {
                maxNum = j;
            } else if (j < minNum) {
                minNum = j;
            }
        }
        System.out.print(minNum+" "+maxNum);
    }
}
