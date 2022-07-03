package algorithm_java;
/*
    problem : baekjoon NO.14914
    task : 아름이는 친구들과 사과와 바나나를 많이 가지고 있지만,
    과일을 좋아하지 않아서 자신의 분량을 남겨두지 않고 친구들에게 모두 나누어 준다.
    아름이는 항상 공평하게 사과와 바나나를 나누어 주며, 절대 잘라서 주지 않는다.
    아름이가 나누어 줄 수 있는 모든 경우를 출력하는 함수를 작성하시오.
    point :
        - 아름이가 나누어 줄 수 있는 경우를 모두 출력해야 하며,
        각 경우마다 친구의 수, 사과 개수, 바나나 개수 차례로 한 줄에 각각 빈칸으로 구분하여 출력한다.
        각 경우마다 중복없이 한 번만 출력되어야 하며, 경우의 순서는 친구의 수가 증가하는 순으로 한다.
 */

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BK14914 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        ArrayList<Integer> list = new ArrayList<>();
        if(A % B == 0){
            list.add(A);
            list.add(B);
        }
        //두 수중 큰 수까지만 반복하는 반복문
        for (int i = 1; i <= Math.max(A, B); i++) {
            if (A % i == 0 && B % i == 0) {
                list.add(i);
            }
        }
        for(int i : list){
            System.out.println(list.get(i)+ " " + (A / list.get(i) + " " + (B / list.get(i))));
        }
    }
}