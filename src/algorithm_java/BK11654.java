package algorithm_java;
/*
    문제 : 백준 11654번 아스키 코드
    설명 : 알파벳 소문자, 대문자, 숫자 0-9중 하나가 주어졌을 때, 주어진 글자의 아스키 코드값을 출력하는 프로그램을 작성하시오.
    풀이 :
        - 알파벳 소문자, 대문자, 숫자 0-9 중 하나가 첫째 줄에 주어진다. char 사용
        - 입력으로 주어진 글자의 아스키 코드 값을 출력한다. char 을 int 로 변환하면 된다.
    다른 풀이 :
        - read 를 사용한다.
 */
import java.util.Scanner;

public class BK11654 {
    static public void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String target = sc.next();
        int result = target.charAt(0);
        System.out.print(result);
        sc.close();
    }
    //다른 풀이
//    public static void main(String[] args) throws Exception {
//
//        int a = System.in.read();
//        System.out.print(a);
//
//    }
}
