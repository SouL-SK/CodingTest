package algorithm_java;
/*
    problem : baekjoon NO.5567 결혼식
    task : 상근이는 자신의 결혼식에 학교 동기 중 자신의 친구와 친구의 친구를 초대하기로 했다. 상근이의 동기는 모두 N명이고, 이 학생들의 학번은 모두 1부터 N까지이다.
        상근이의 학번은 1이다. 상근이는 동기들의 친구 관계를 모두 조사한 리스트를 가지고 있다. 이 리스트를 바탕으로 결혼식에 초대할 사람의 수를 구하는 프로그램을 작성하시오.
    point :
        - 첫째 줄에 상근이의 동기의 수 n (2 ≤ n ≤ 500)이 주어진다. 둘째 줄에는 리스트의 길이 m (1 ≤ m ≤ 10000)이 주어진다.
        다음 줄부터 m개 줄에는 친구 관계 ai bi가 주어진다. (1 ≤ ai < bi ≤ n) ai와 bi가 친구라는 뜻이며, bi와 ai도 친구관계이다.
        - 첫째 줄에 상근이의 결혼식에 초대하는 동기의 수를 출력한다.
    explain :
        - 인접리스트와 dfs 를 이용해서 할 수 있다.
        - 친구의 친구까지만 초대할 수 있기 때문에 depth 체크를 해야 한다.
        - 인접 리스트 구현 시 양방향 그래프로 구현해야 한다.
    conclusion :
        오랜만에 푸니까 완전 큰일 났다. 지금부터라도 3문제씩 좀 풀어보자. 백엔드 공부도 같이 하면서!
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BK5567 {
    static int n, m, answer = 0;
    static int[][] friendList;
    static boolean[] check;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        List<Integer> list[] = new ArrayList[n+1];
//        friendList = new int[n+1][n+1];
        for (int i = 1; i < list.length; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
//            friendList[x][y] = y;
//            friendList[y][x] = x;
            list[x].add(y);
            list[y].add(x);
        }
        check = new boolean[n + 1];
        check[1] = true;
        dfs(1, list, 0);
        for (int i = 2; i < check.length; i++) {
            if (check[i]) {
                answer++;
            }
        }
        System.out.print(answer);
    }

    public static void dfs(int x, List<Integer>[] list, int depth) {
        if (depth == 2) {
            return;
        }
        for (int i = 0; i < list[x].size(); i++) {
            int next = list[x].get(i);
            check[next] = true;
            dfs(next, list, depth + 1);
        }
    }
}
