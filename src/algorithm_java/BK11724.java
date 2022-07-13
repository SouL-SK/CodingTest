package algorithm_java;
/*
    problem : baekjoon NO.11724
    task : 방향 없는 그래프가 주어졌을 때, 연결 요소 (Connected Component)의 개수를 구하는 프로그램을 작성하시오.
    point :
        - 그래프를 사용한다. array로 선언해도 좋고, linkedList로 선언해도 좋다.
        - 여기서는 array를 사용해서 받는 값을 그대로 array index에 넣어 array 값만 true로 만들어준다. 무방향이기 때문에 반대 방향도 true로 바꿔야 한다.
        - 연결 요소는 어떤 특징을 가지고 있는지 생각한다.
        - 같은 간선은 한 번만 주어진다. <- 만약 같은 정점이나 간선이 또 들어오면 따로 처리를 해주어야 한다.
        - 방문하지 않았던 노드라도 간선이 있는지 확인 후에 dfs 돌리기
        - bfs는 간선이 있는지 확인하지 않아도 된다, 바로 인접 리스트에서 가지고 오기 때문에 연결되어 있다는 것을 보장한다.
    explain :
        - 인접 행렬을 쓰는 이유 : 왜냐하면 메모리 제한이 512mb인데 최대 1000까지 입력이 들어오니 행렬 선언을 해도 1000 * 1000 == 10 ^ 6 승이라 딱 1억 == 400~500mb 로 안전하게 들어간다.
        - DFS & BFS를 돌리면 시작점에서 시작해서 요소들을 방문한다.
        시작점부터 모든 정점들을 다 돌리기 시작하면 어떤 정점은 방문 배열에 들어가 있어 안돌아가는 정점이 있다.
        그러면 결국 DFS가 돌아간 정점만 세면 연결 요소의 개수를 구할 수 있다.
    conclusion :
        - 채점 중에 계속 틀렸습니다가 뜬다. 어디서 잘못되었는지 모르겠다. << 1-base 문제여서 dfs 를 돌 때 int i = 1 ; i <= N 인것을 잘 생각했으면 되는 문제였다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BK11724 {
    static int N, M;
    static boolean[] visited;
    static int[][] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N + 1][N + 1];
        visited = new boolean[N + 1];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            graph[x][y] = graph[y][x] = 1;
        }
        int result = 0;
        for (int i = 1; i <= N; i++) { // 지금 이 문제는 1-base 니까 index 구성을 잘 짜야 한다.
            if (!visited[i]) {
                dfs(i);
                result++;
            }
        }
        System.out.print(result);
    }

    public static void dfs(int index) {
        if (!visited[index]) {
            visited[index] = true;
            for (int i = 1; i <= N; i++) {
                if (graph[index][i] == 1) {
                    dfs(i);
                }
            }
        }
    }
}
