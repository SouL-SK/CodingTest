package algorithm_java;
/*
    문제 : 백준 1001번 A-B
    설명 : 두 정수 A와 B를 입력받은 다음, A-B를 출력하는 프로그램을 작성하시오.
    풀이 :
        - int 형으로 선언
 */
import java.util.Scanner;

public class BK1001 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        System.out.print(A-B);
        sc.close();
    }
}
