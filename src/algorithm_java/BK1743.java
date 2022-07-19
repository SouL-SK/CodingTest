package algorithm_java;
/*
    problem : baekjoon NO.1743
    task : 코레스코 콘도미니엄 8층은 학생들이 3끼의 식사를 해결하는 공간이다.
    그러나 몇몇 비양심적인 학생들의 만행으로 음식물이 통로 중간 중간에 떨어져 있다.
    이러한 음식물들은 근처에 있는 것끼리 뭉치게 돼서 큰 음식물 쓰레기가 된다.
    이 문제를 출제한 선생님은 개인적으로 이러한 음식물을 실내화에 묻히는 것을 정말 진정으로 싫어한다.
    참고로 우리가 구해야 할 답은 이 문제를 낸 조교를 맞추는 것이 아니다.
    통로에 떨어진 음식물을 피해가기란 쉬운 일이 아니다.
    따라서 선생님은 떨어진 음식물 중에 제일 큰 음식물만은 피해 가려고 한다.
    선생님을 도와 제일 큰 음식물의 크기를 구해서 “10ra"를 외치지 않게 도와주자.
    point :
        - 제일 큰 음식물의 크기를 구해야 한다. 인접한 상하좌우의 음식물만 서로 붙고, 대각선의 음식물은 붙지 않는다.
        - bfs를 돌려 해당 칸에 상하좌우에 있는 칸을 구한 뒤 해당 칸으로 이동할 때마다 이동 거리를 저장해둔다. 제일 큰 이동거리가 곧 제일 큰 음식물의 크기다.
        - 입력되는 좌표는 중복되지 않으니 따로 처리할 필요 없다.
        - 인접 행렬로 구현하면 된다.
        - dx, dy를 적극 이용하자.
        - 처음 시작 위치를 어떻게 잡아야 할지 몰라 구글링 시도. < 음식물의 위치를 먼저 찾은 뒤에, 사방 탐색 시행해야 한다.
    explain :
        - 내일 다시 도전하자. bfs가 제대로 전체를 다 돌지 못하는 것이 분명하다. << 전체는 다 돌지만 입력값 예외 처리에서 들어가야 할 값이 안들어간 상황 때문에 count가 너무 늘어났다.
        - dfs 를 사용하면 된다! bfs도 괜찮다. 둘 다 사용하는 데에 능숙해지자.
        - 1-base 와 0-base 두 가지 경우에서 bfs, dfs 사용에 능숙해지자
    conclusion :
        이틀이나 걸렸지만 dfs 에 대해서 좀 더 공부가 되었다.
        - elapsed time : 168 ms, memory : 16360 kb
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BK1743 {
    static int count, result;
    static int n, m;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> list = new ArrayList<>();
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        map = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
//            여기서 넣어야 할 값을 넣지 못해 빈 공간이 생겼다!! ==n 과 ==m 일 때를 넣으면 안된다..
//            예외 처리를 할 때는 확실히 하자! 아예 범위를 지정해 주고 그 안에서만 들어가게 하는 것도 방법이다.
            if (r > n || r < 0 || c > m || c < 0) {
                continue;
            }
            map[r][c] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    count = 0;
                    dfs(new int[]{i, j});
//                    count++;
                    result = Math.max(count, result);
                }
            }
        }
        System.out.print(result);
    }

//    public static int bfs(int[] vertex) {
//        Queue<int[]> q = new LinkedList<>();
//        q.add(vertex);
//        int x = vertex[0];
//        int y = vertex[1];
//        count++;
//        visited[x][y] = true;
//        for (int i = 0; i < 4; i++) {
//            int[] dx = {1, -1, 0, 0};
//            int[] dy = {0, 0, 1, -1};
//            int nx = x + dx[i];
//            int ny = y + dy[i];
//            if (nx <= n && nx >= 0 && ny <= m && ny >= 0) {
//                if (!visited[nx][ny] && map[nx][ny] == 1) {
//                    q.add(new int[]{nx, ny});
////                    visited[nx][ny] = true;
//                    bfs(new int[]{nx, ny});
////                    count++;
//                }
//            }
//        }
//        return count;
//    }

    public static void dfs(int[] vertex) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        int x = vertex[0];
        int y = vertex[1];
        visited[x][y] = true;
        count++;
        for (int k = 0; k < 4; k++) {
            int nowx = x + dx[k];
            int nowy = y + dy[k];
            if ((1 <= nowx && nowx < n + 1) && (1 <= nowy && nowy < m + 1) && (map[nowx][nowy] == 1) && (!visited[nowx][nowy])) {
                dfs(new int[] {nowx, nowy});
            }
        }
    }
}
