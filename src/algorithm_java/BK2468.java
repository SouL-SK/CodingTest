package algorithm_java;
/*
    baekjoon NO.2468
    task : 어떤 지역의 높이 정보가 주어졌을 때, 장마철에 물에 잠기지 않는 안전한 영역의 최대 개수를 계산하는 프로그램을 작성하시오.
    point :
        - 어떤 지역의 높이 정보는 행과 열의 크기가 각각 N인 2차원 배열 형태로 주어지며 배열의 각 원소는 해당 지점의 높이를 표시하는 자연수이다.
        - 물에 잠기지 않는 안전한 영역이라 함은 물에 잠기지 않는 지점들이 위, 아래, 오른쪽 혹은 왼쪽으로 인접해 있으며 그 크기가 최대인 영역을 말한다.
        - 내리는 비의 양에 따른 모든 경우를 다 조사한 뒤, 그 중에서 안전한 영역의 개수가 최대인 경우를 출력해야 한다.
    explain :
        - 먼저 가장 낮은 높이부터 가장 높은 높이까지 반복문을 진행해 dfs를 진행하고 각 group 값을 저장한다.
        - group 값 중에 가장 높은 값을 출력한다.
        - dfs 진행할 때 현재 높이보다 높은 높이들을 돌면 된다.
        - 76% 에서 틀렸습니다가 뜬다. 어디를 놓친 건지 코드 비교를 진행 중. << 아예 안잠길 수도 있다는 것을 check 해주었더니 풀렸다.
    conclusion :
        모든 상황을 가정하자. 글에서 언급하지 않는 부분에 대해서 세심하게 check 하는 습관을 들이자.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BK2468 {
    static int N, group;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        int maxHigh = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHigh = Math.max(map[i][j], maxHigh);
            }
        }
        int result = 0;
        for (int rain = 0; rain <= maxHigh; rain++) { // 아예 안잠길 수도 있다.
            group = 0;
            visited = new boolean[N][N]; // 방문 초기화를 해주어야 한다.
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < N; y++) {
                    if (!visited[x][y] && map[x][y] > rain) {
                        group++;
                        dfs(new int[]{x, y}, rain);
                    }
                }
            }
            result = Math.max(group, result);
        }
        System.out.print(result);
    }

    public static void dfs(int[] vertex, int rain) {
        int x = vertex[0];
        int y = vertex[1];
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ((0 <= nx && nx < N) && (0 <= ny && ny < N) && !visited[nx][ny] && map[nx][ny] > rain) {
                dfs(new int[]{nx, ny}, rain);
            }
        }
    }
}
