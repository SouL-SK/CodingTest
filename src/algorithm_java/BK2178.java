package algorithm_java;
/*
    problem : baekjoon NO.2178
    task : 미로에서 1은 이동할 수 있는 칸을 나타내고, 0은 이동할 수 없는 칸을 나타낸다.
        이러한 미로가 주어졌을 때, (1, 1)에서 출발하여 (N, M)의 위치로 이동할 때 지나야 하는 최소의 칸 수를 구하는 프로그램을 작성하시오.
        한 칸에서 다른 칸으로 이동할 때, 서로 인접한 칸으로만 이동할 수 있다.
    point :
        - 최소의 칸 수를 구할 떄는 BFS를 쓴다.
        - 인접 행렬로 배열을 선언하여 이동할 수 있는 간선을 나타낸다.
        - 칸을 셀 때는 시작 위치에서 부터 1이고 도착하면 1++ 이다.
        - 출발 위치 (1, 1) 에서 시작한다.
        - 범위, 벽, 방문 체크 해주면 된다. (항상 범위 체크는 먼저 해주어야 한다. Index Error를 방지하기 위함)
        - 시작 지점이 벽인지 체크해주면 좋다. 여기서는 그런 경우는 생기지 않는다.
        - 큐에 x, y를 넣어 좌표를 넣는다.
        - 큐에 시작 노드를 poll() 한다
        큐에서 노드를 poll()한다
        꺼낸 노드 상하좌우로 이동할 수 있는지 확인한다.
        이동이 가능하면 1. 노드를 추가한다. 2. 추가한 노드의 이동 거리 = 현재 노드의 이동거리 + 1(visited 배열의 값이 0 인 경우는 갈 수 없는 길이다.)
        큐에 값이 존재하지 않을 때까지 위의 poll -> 이동 확인 후 삽입 과정을 반복한다.
    explain :
        - 즉, 1인 칸만 지나갈 수 있고 0인 칸은 지나갈 수 없다.
        - 벽이 하나도 없을 때를 먼저 생각해보면, (순서는 동남서북 방향으로 진행한다.)
        DFS는 크게 한 바퀴를 돌면서 진행한다. 절반을 다 돌았으면 위로 ㄹ 모양으로 올라간다.
        BFS는 파동이 번지는 모양과 같다.
    conclusion :
        인덱스 에러 때문에 갈피를 못잡겠다. 나중에 다시 도전해보자
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BK2178 {
    static int N, M, cnt;
    static int[][] graph;
    static boolean[][] visited;
    //동 서 남 북
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static Queue<int[]> q;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) { // 0-base 인 것을 잊지 말자.
            String str = br.readLine();
            for (int j = 0; j < M; j++) {
                graph[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        cnt = 0;
        int result = 0;
//        for (int x = 0; x < N; x++) {
//            for (int y = 0; y < M; y++) {
        bfs(new int[]{0, 0});
        result = cnt;
//            }
//        }
        System.out.print(result);
    }

    public static void bfs(int[] index) {
        q = new ArrayDeque<>();
        q.offer(index);
        int x = index[0];
        int y = index[1];
        visited[x][y] = true;

        while (!q.isEmpty()) {
            int[] temp = q.poll();
            if ((x == N-1) && (y == M-1)) {
                visited[x][y] = true;
                cnt++;
                return;
            }
            for (int i = 0; i < 4; i++) {
                int nx = temp[0] + dx[i];
                int ny = temp[1] + dy[i];

                if ((0 <= nx && nx < N - 1) && (0 <= ny && ny < M - 1) && (!visited[nx][ny]) && (graph[nx][ny] == 1)) {
                    visited[nx][ny] = true;
                    cnt++;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }

}

