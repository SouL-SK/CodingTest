package algorithm_java;
/*
    problem : baekjoon NO.4153
    task : 과거 이집트인들은 각 변들의 길이가 3, 4, 5인 삼각형이 직각 삼각형인것을 알아냈다. 주어진 세변의 길이로 삼각형이 직각인지 아닌지 구분하시오.
    point :
        - 삼각형은 제일 긴 변이 다른 두 변의 합보다 크다.
        - 직각 삼각형은 다른 두 변의 제곱의 합이 큰 변의 제곱과 같다.
        - 괜히 배열로 값을 입력 받았다.
        - 그냥 세가지 전부 다 조건문으로 계산하면 되는데 굳이 큰 값을 찾을 필요는 없다는 걸 몰랐다.
 */

import java.util.Scanner;

public class BK4153 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {

            int y = sc.nextInt();
            int z = sc.nextInt();
            int x = sc.nextInt();

            // 0 0 0 을 입력받으면 종료
            if (x == 0 && y == 0 && z == 0) break;


            if ((x * x + y * y) == z * z) {
                System.out.println("right");
            } else if (x * x == (y * y + z * z)) {
                System.out.println("right");
            } else if (y * y == (z * z + x * x)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }

        }

    }
//        int[] numList;
//        do {
//            numList = new int[]{sc.nextInt(), sc.nextInt(), sc.nextInt()};
//            int max = numList[0];
//            int sum = 0;
//            for (int i = 1; i < numList.length; i++) {
//                if (max < numList[i]) {
//                    max = (numList[i] * numList[i]);
//                } else {
//                    sum += (numList[i] * numList[i]);
//                }
//            }
//            if (max == sum) {
//                System.out.print("right");
//            } else {
//                System.out.print("wrong");
//            }
//            sc.close();
//        }
//        while (numList[0] == 0 && numList[1] == 0 && numList[2] == 0);
}

