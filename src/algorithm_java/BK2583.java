package algorithm_java;
/*
	problem : baekjoon NO.2583
	task : M, N과 K 그리고 K개의 직사각형의 좌표가 주어질 때, K개의 직사각형 내부를 제외한 나머지 부분이 몇 개의 분리된 영역으로 나누어지는지,
		그리고 분리된 각 영역의 넓이가 얼마인지를 구하여 이를 출력하는 프로그램을 작성하시오.
	point :
		- 첫째 줄에 M과 N, 그리고 K가 빈칸을 사이에 두고 차례로 주어진다. M, N, K는 모두 100 이하의 자연수이다.
		둘째 줄부터 K개의 줄에는 한 줄에 하나씩 직사각형의 왼쪽 아래 꼭짓점의 x, y좌표값과 오른쪽 위 꼭짓점의 x, y좌표값이 빈칸을 사이에 두고 차례로 주어진다.
		모눈종이의 왼쪽 아래 꼭짓점의 좌표는 (0,0)이고, 오른쪽 위 꼭짓점의 좌표는(N,M)이다.
		입력되는 K개의 직사각형들이 모눈종이 전체를 채우는 경우는 없다.
		- 첫째 줄에 분리되어 나누어지는 영역의 개수를 출력한다. 둘째 줄에는 각 영역의 넓이를 오름차순으로 정렬하여 빈칸을 사이에 두고 출력한다.
	explain :
	    - dfs에서는 예외 값 처리를 잘 해줘야 한다. 특히 dfs 내에서 map 범위 내의 값만 돌게끔 하는 것이 point 이다.
	    - 오름차순 정렬을 위해 ArrayList를 만들어 넣어주지
	conclusion :
	    처음에는 dfs랑 bfs를 계속 구현하지 못했는데 하루 정도 시간을 쏟아부으니 이제는 어느정도 구현을 할 수 있게 되었다. 역시 포기하지 않는 것이 중요하다.
	    elapse time : 160 ms, memory : 17308 kb
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class BK2583 {
    static int M, N, K, cnt;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> result = new ArrayList<>();
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[M][N];
        visited = new boolean[M][N];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int[] leftDownVertex = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            int[] rightUpVertex = {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())};
            for (int x = leftDownVertex[1]; x < rightUpVertex[1]; x++) {
                for (int y = leftDownVertex[0]; y < rightUpVertex[0]; y++) {
                    map[x][y] = 1;
                }
            }
        }
        int group = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    group++;
                    cnt = 0;
                    dfs(new int[]{i, j});
                    result.add(cnt);
                    cnt = 0;
                }
            }
        }
        System.out.println(group);
        Collections.sort(result);
        for (int i : result) {
            System.out.print(i + " ");
        }
//      배열 값 확인용 코드
//        for(int i = 0 ; i < map.length ; i++){
//            for(int j = 0; j < map[0].length;j++){
//                System.out.print(map[i][j]);
//            }
//            System.out.println();
//        }
    }

    public static void dfs(int[] vertex) {
        int x = vertex[0];
        int y = vertex[1];
        cnt++;
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if ((0 <= nx && nx < M) && (0 <= ny && ny < N) && (!visited[nx][ny]) && (map[nx][ny] == 0)) {
                dfs(new int[]{nx, ny});
            }
        }
    }
}
