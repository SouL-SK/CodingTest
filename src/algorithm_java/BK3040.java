package algorithm_java;
/*
    문제 : 백준 3040번 백서 공주와 일곱 난쟁이

    설명 : 백설공주는 이런 일이 생길 것을 대비해서, 난쟁이가 쓰고 다니는 모자에 100보다 작은 양의 정수를 적어 놓았다.
        사실 백설 공주는 공주가 되기 전에 매우 유명한 수학자였다.
        따라서, 일곱 난쟁이의 모자에 쓰여 있는 숫자의 합이 100이 되도록 적어 놓았다.
        아홉 난쟁이의 모자에 쓰여 있는 수가 주어졌을 때, 일곱 난쟁이를 찾는 프로그램을 작성하시오. (아홉 개의 수 중 합이 100이 되는 일곱 개의 수를 찾으시오)

    풀이 : O(9C7) == O(1)
        - N (1 <= N <= 99), 모든 숫자는 서로 다르다.
        - 답이 유일한 경우만 정답
        - 100에서 각 입력 값을 한 개씩 빼면서 넣을 수 있는 입력 값을 점점 줄여나간다.
        - 중복 처리를 위헤 flag 사용하여 false, true 나눔(가짜 난쟁이가 1, 3번 과 3, 1번 인 경우를 1개의 케이스로 보기 위함)
     다른 풀이 : O(9C2) == O(1)
        - 7명을 찾을 게 아닌 2명을 찾아내는 방식
        - 전체 합에서 2 명만 뺴면 100이 된다는 점을 이용

     막힌 부분 :
        - 중복 처리를 해주어야 하는데 같은 값 (인덱스 6, 6) 이 들어가는 경우를 정답으로 뽑는 경우가 생겨 계속 틀렸었다.
            이를 위해 이중 for 문에서 i는 0~8까지, j는 1~9까지 움직이도록 해주었다.
 */

import java.util.Scanner;

public class BK3040 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int[] elfArray = new int[9];
        int sum = 0;
        int target1 = 0, target2 = 0;
        for(int i = 0;i < elfArray.length; i++){
            sum += elfArray[i] = sc.nextInt();
        }
        Loop1:
        for(int i = 0;i < 8;i++){
            for(int j = 1;j < 9;j++){
                int temp = elfArray[i] + elfArray[j];
                if(sum - temp == 100){
                    if(i != j){
                        target1 = i;
                        target2 = j;
                        break Loop1;
                    }
                }
            }
        }
        for(int i = 0;i < elfArray.length;i++){
            if(i != target1 && i != target2){
                System.out.println(elfArray[i]);
            }
        }
    }
}
