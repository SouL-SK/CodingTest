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
    conclusion :
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BK1743 {
    static int result = 0;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n + 1][m + 1];
        boolean[][] visited = new boolean[n + 1][m + 1];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (r >= m || r < 0 || c >= n || c < 0) {
                continue;
            }
            map[c][r] = 1;
        }
        bfs(new int[]{0, 0}, map, visited); // 시작점이 1, 1 이기에 보지 않아도 되는 0, 0 부터는 백트래킹 기법을 적용. 가지치기 진행한다.
        System.out.print(result);
    }

//    public static void dfs(int[] vertex, int[][] map, boolean[][] visited) {
//        int x = vertex[0];
//        int y = vertex[1];
//        visited[x][y] = true;
//        result++;
//        for (int i = 0; i < map.length; i++) {
//            for (int j = 0; j < map[0].length; j++) {
//                if(map[i][j] == 1 && !visited[i][j]){
//                    dfs(new int[]{i, j}, map, visited);
//                    result++;
//                }
//            }
//        }
//    }

    public static void bfs(int[] vertex, int[][] map, boolean[][] visited) {
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<Integer> list = new ArrayList<>();
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j});
                    while (!queue.isEmpty()) {
                        vertex = queue.poll();
                        int x = vertex[0];
                        int y = vertex[1];
                        visited[x][y] = true;
                        for (int k = 0; k < 4; k++) {
                            int nx = x + dx[k];
                            int ny = y + dy[k];

                            if (!visited[nx][ny] && map[nx][ny] == 1) {
                                queue.add(new int[]{nx, ny});
                                visited[nx][ny] = true;
                                result++;
                            }
                        }
                    }
                    list.add(result);
                }
            }
        }
        Collections.sort(list);
        result = list.get(list.size()-1) + 1;
    }
}
