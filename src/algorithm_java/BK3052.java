package algorithm_java;
/*
    problem : baekjoon NO.3052
    task : 두 자연수 A와 B가 있을 때, A%B는 A를 B로 나눈 나머지 이다.
    예를 들어, 7, 14, 27, 38을 3으로 나눈 나머지는 1, 2, 0, 2이다.
    수 10개를 입력받은 뒤, 이를 42로 나눈 나머지를 구한다.
    그 다음 서로 다른 값이 몇 개 있는지 출력하는 프로그램을 작성하시오.
    point :
        - 첫째 줄부터 열번째 줄 까지 숫자가 한 줄에 하나씩 주어진다. 이 숫자는 1,000보다 작거나 같고, 음이 아닌 정수이다.
        - 첫째 줄에, 42로 나누었을 때, 서로 다른 나머지가 몇 개 있는지 출력한다.
        - HashSet 을 사용하면 빠르고 간편하게 풀 수 있다. ( 중복을 허용하지 않는다, 순서 개념이 없다.)
        HashSet 원소에 이미 저장되어있어 중복일 경우 저장이 되지 않고 HashSet 에 없으면 저장한다.
        즉, HashSet 에 저장하면서 들어간 원소의 개수가 HashSet 의 사이즈가 되는 것이고,
        이는 결국 "서로 다른 나머지"가 되는 것이다.

 */

import java.util.Scanner;
import java.util.HashSet;

public class BK3052 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashSet<Integer> h = new HashSet<Integer>();

        for (int i = 0; i < 10; i++) {
            h.add(in.nextInt() % 42);
            //입력받은 값의 나머지 값을 add메소드를 통해 HashSet에 저장
        }

        in.close();
        System.out.print(h.size());
    }
}


