package algorithm_java;
/*
        문제 : 백준 1000번 A + B

        설명 : 두 정수 A와 B를 입력받은 다음, A+B를 출력하는 프로그램을 작성하시오.

        풀이 :
            - A > 0, B < 10
 */
import java.util.Scanner;

public class BK1000 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a, b;
        a = sc.nextInt();
        b = sc.nextInt();

        System.out.println(a + b);
    }
}
