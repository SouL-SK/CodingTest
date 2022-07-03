package algorithm_java;
/*
    problem : beakjoon NO.1085
    task : 한수는 지금 (x, y)에 있다. 직사각형은 각 변이 좌표축에 평행하고, 왼쪽 아래 꼭짓점은 (0, 0), 오른쪽 위 꼭짓점은 (w, h)에 있다.
        직사각형의 경계선까지 가는 거리의 최솟값을 구하는 프로그램을 작성하시오.
    think :
        - 첫째 줄에 x, y, w, h가 주어진다.
        - 1 ≤ w, h ≤ 1,000
        - 1 ≤ x ≤ w-1
        - 1 ≤ y ≤ h-1
        - x, y, w, h는 정수
        - 왼쪽 아래 꼭짓점은 (0, 0)이고 오른쪽 위 꼭짓점은 (w, h)이다.
        - 왼쪽 위 꼭짓점은 (0, h) 이고 오른쪽 아래 꼭짓점은 (x, 0)이다.
        - x와 y는 무조건 w, h 보다 작기 때문에 w-x와 h-y 의 좌표에서 거리를 구하면 된다.
        - 둘 중에 더 작은 값을 출력하면 된다.
        - 시간 복잡도는 O(1)
 */

import java.util.Scanner;

public class BK1085 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int w = sc.nextInt();
        int h = sc.nextInt();
        int[] compareValueList = new int[4];
        compareValueList[0] = x;
        compareValueList[1] = y;
        compareValueList[2] = w-x;
        compareValueList[3] = h-y;
        int result = compareValueList[0];

        for(int i = 0; i < compareValueList.length; i++){
            if(result >= compareValueList[i]){
                result = compareValueList[i];
            }
        }
        System.out.print(result);
        sc.close();

    }
}
