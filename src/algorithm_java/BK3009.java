package algorithm_java;
/*
    problem : beakjoon NO.3009
    task : 세 점이 주어졌을 때, 축에 평행한 직사각형을 만들기 위해서 필요한 네 번째 점을 찾는 프로그램을 작성하시오
    think :
        - 세 점의 좌표가 한 줄에 하나씩 주어진다. 좌표는 1보다 크거나 같고, 1000보다 작거나 같은 정수이다.
        - 직사각형의 네 번째 점의 좌표를 출력한다
        - x좌표, y좌표를 받아 위치를 저장하고 비어있는 공간을 찾아 수평 위치에 해당하는 x, y 자표를 가져온다.
        - 세 점의 좌표를 받았을 때 네번째 점의 위치를 어떻게 공식화하는가?
        - 어렵게 생각할 필요 없이 쌍을 이루지 않는 각각의 좌표만 찾으면 된다!!!
        - 시간 복잡도는 O(1)
 */

import java.util.Scanner;

public class BK3009 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        int[] addList = new int[6];
//        for (int i = 0; i < addList.length; i += 2) {
//            int x = sc.nextInt();
//            int y = sc.nextInt();
//            addList[i] = x;
//            addList[i + 1] = y;
//        } 이 식을 밑에 식처럼 배열 안에 바로 집어넣을 수 있다.
        int[] add_1 = {sc.nextInt(), sc.nextInt()};
        int[] add_2 = {sc.nextInt(), sc.nextInt()};
        int[] add_3 = {sc.nextInt(), sc.nextInt()};
        int x = 0;
        int y = 0;
        if (add_1[0] == add_2[0]) {
            x = add_3[0];
        }
        // 1번 x좌표와 3번 x좌표 비교
        else if (add_1[0] == add_3[0]) {
            x = add_2[0];
        }
        // 2번 x좌표와 3번 x좌표 비교
        else {
            x = add_1[0];
        }

        // 1번 y좌표와 2번 y좌표 비교
        if (add_1[1] == add_2[1]) {
            y = add_3[1];
        }
        // 1번 y좌표와 3번 y좌표 비교
        else if (add_1[1] == add_3[1]) {
            y = add_2[1];
        }
        // 2번 y좌표와 3번 y좌표 비교
        else {
            y = add_1[1];
        }
//        for (int i = 0; i < addList.length; i += 2) {
//            for (int j = 2; j < addList.length; j += 2) {
//                if (addList[i] != addList[j]) {
//                    x = addList[i];
//                    break;
//                }
//            }
//        }
//        for (int i = 1; i <= addList.length; i += 2) {
//            for (int j = 3; j <= addList.length; j += 2) {
//                if (addList[i] != addList[j]) {
//                    x = addList[i];
//                    break;
//                }
//            }
        System.out.print(x + " " + y);
        sc.close();
    }
}

