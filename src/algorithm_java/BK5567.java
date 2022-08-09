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
    conclusion :
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BK5567 {
    static int n, m;

    static boolean[][] friendList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        friendList = new boolean[n+1][n+1];
        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            friendList[x][y] = true;
            friendList[y][x] = true;
        }
        System.out.print(solve());
    }

    public static int solve(){
        Queue<int[]> q = new ArrayDeque<>();
        int result = 0;
        for (int i = 0; i < n + 1; i++) {
            if (friendList[1][i]) {
                q.add(new int[]{1, i});
//                result++;
//                friendList[1][i] = false;
//                friendList[i][1] = false;
            }
        }
        while (q.isEmpty()) {
            int[] index = q.poll();
            result++;
            int x = index[0];
            int y = index[1];
            if (friendList[x][y]) {
                result++;
                friendList[x][y] = false;
                friendList[y][x] = false;
            }
        }
        return result;
    }
}
