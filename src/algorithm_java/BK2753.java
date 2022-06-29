package algorithm_java;
/*
    뮨재 : 백준 2753번 윤년
    설명 : 연도가 주어졌을 때, 윤년이면 1, 아니면 0을 출력하는 프로그램을 작성하시오.윤년은 연도가 4의 배수이면서, 100의 배수가 아닐 때 또는 400의 배수일 때이다.
    풀이 :
        - 연도가 4로 나누어 떨어지는지 확인 하고 100으로 나누어 떨어지지 않고 400으로는 나누어 떨어지는 경우만 뽑는다.
 */

import java.util.Scanner;

public class BK2753 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        if (((year % 4 == 0) && (year % 400 == 0)) || ((year % 4 == 0) && (year % 100 != 0))) {
            System.out.print(1);
        } else {
            System.out.print(0);
        }
        sc.close();
    }
}
