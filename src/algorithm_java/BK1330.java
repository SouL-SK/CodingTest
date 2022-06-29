package algorithm_java;
/*
    문제 : 백준 1330번 두 수 비교하기
    설명 : 두 정수 A와 B가 주어졌을 때, A와 B를 비교하는 프로그램을 작성하시오.
    풀이 :
        - A가 B보다 큰 경우에는 '>'를 출력한다.
        - A가 B보다 작은 경우에는 '<'를 출력한다.
        - A와 B가 같은 경우에는 '=='를 출력한다.
 */

import java.util.Scanner;

public class BK1330 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        if(A > B){
            System.out.print(">");
        }else if(A == B){
            System.out.print("==");
        }else{
            System.out.print("<");
        }
        sc.close();
    }
}
