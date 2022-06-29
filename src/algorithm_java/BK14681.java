package algorithm_java;
/*
    문제 : 백준 14681번 사분면 고르기
    설명 : 주어진 점이 어느 사분면에 속하는지 알아내는 프로그램을 작성하시오.
    풀이 :
        - 첫 줄에는 정수 x가 주어진다. (−1000 ≤ x ≤ 1000; x ≠ 0) 다음 줄에는 정수 y가 주어진다. (−1000 ≤ y ≤ 1000; y ≠ 0)
        - 점 (x, y)의 사분면 번호(1, 2, 3, 4 중 하나)를 출력한다.
        - 사분면은 13시 방향부터 반시계방향으로 1, 2, 3, 4 분면이다.
 */
import java.util.Scanner;

public class BK14681 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();

        if(x > 0){
            if(y > 0){
                System.out.print(1);
            }else{
                System.out.print(4);
            }
        }else{
            if(y > 0){
                System.out.print(2);
            }else{
                System.out.print(3);
            }
        }
        sc.close();
    }
}
