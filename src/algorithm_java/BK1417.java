package algorithm_java;
/*
    problem : baekjoon NO.1417
    task : 현재 형택구에 나온 국회의원 후보는 N명이다. 다솜이는 이 기계를 이용해서 그 마을의 주민 M명의 마음을 모두 읽었다.
    다솜이는 기호 1번이다. 다솜이는 사람들의 마음을 읽어서 자신을 찍지 않으려는 사람을 돈으로 매수해서 국회의원에 당선이 되게 하려고 한다.
    다른 모든 사람의 득표수 보다 많은 득표수를 가질 때, 그 사람이 국회의원에 당선된다.
    돈으로 매수한 사람은 반드시 다솜이를 찍는다고 가정한다. 다솜이가 매수해야하는 사람의 최솟값을 출력하는 프로그램을 작성하시오.
    point :
        - 첫째 줄에 후보의 수 N이 주어진다.
        둘째 줄부터 차례대로 기호 1번을 찍으려고 하는 사람의 수, 기호 2번을 찍으려고 하는 수, 이렇게 총 N개의 줄에 걸쳐 입력이 들어온다.
        N은 50보다 작거나 같은 자연수이고, 득표수는 100보다 작거나 같은 자연수이다.
        - 첫째 줄에 다솜이가 매수해야 하는 사람의 최솟값을 출력한다.
    explain :
        - 후보 당 지지자의 숫자를 입력할 자료구조가 필요하다. 숫자는 언제나 바뀔 수 있어야 하고 쉽게 접근이 가능해야 한다.
        후보는 index+1 값 혹은 key 값으로 표현하고, 지지자는 int[] 안에 원소 값 혹은 value 값으로 표현하면 된다.
        - 다솜이는 index 0번으로 넣는다. 다솜이가 돈으로 매수하면 array[0]++;, array[매수한 후보]--; 를 하면 된다.
        Map을 쓰는 경우에는 key 값을 기준으로 replace() 를 이용한다.
        - 매수할 후보는 무조건 지지자가 많은 사람 위주로 해야한다. 즉, 자동으로 sort가 되는 자료구조가 필요하다.
        결론 : treeMap 사용한다.

        - 하지만 큰 문제가 있었다. key 값을 기준으로 정렬되는 treeMap 을 사용하니 잘 돌아가지 않았다. 결국 Array를 사용하기로 결정.
        - time complexity : O(N^2 log N) , elapsed time : 136 ms, memory : 14288 kb
    conclusion :
        개인적으로 자료구조를 처음에 잘못 정해서 시간을 많이 잡아먹었다. 역시 자료구조를 어떤걸 쓸지 제대로 파악하고 문제를 풀어야겠다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.ArrayList;

public class BK1417 {
    static int N;
    static ArrayList<Integer> vote;
    static BufferedReader br;
    static int voted;
    static int cnt;

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        vote = new ArrayList<>();
        N = Integer.parseInt(br.readLine());
        voted = Integer.parseInt(br.readLine());
        cnt = 0;
        for (int i = 0; i < N - 1; i++) { // O(N)
            vote.add(i, Integer.parseInt(br.readLine())); // O(N)
        }
        if (N == 1) {
            System.out.print("0");
            return;
        }
        while (true) {
            Collections.sort(vote); // O(N log N)
            int lastIdx = vote.size() - 1;

            if (voted <= vote.get(lastIdx)) { // O(1)
                voted++;
                vote.set(lastIdx, vote.get(lastIdx) - 1); // O(N)
                cnt++;
            } else {
                break;
            }
        }
        System.out.print(cnt);
    }
}
