package algorithm_java;
/*
    problem : baekjoon NO.2667
    task : <그림 1>과 같이 정사각형 모양의 지도가 있다. 1은 집이 있는 곳을, 0은 집이 없는 곳을 나타낸다.
    철수는 이 지도를 가지고 연결된 집의 모임인 단지를 정의하고, 단지에 번호를 붙이려 한다.
    여기서 연결되었다는 것은 어떤 집이 좌우, 혹은 아래위로 다른 집이 있는 경우를 말한다.
    대각선상에 집이 있는 경우는 연결된 것이 아니다. <그림 2>는 <그림 1>을 단지별로 번호를 붙인 것이다.
    지도를 입력하여 단지수를 출력하고, 각 단지에 속하는 집의 수를 오름차순으로 정렬하여 출력하는 프로그램을 작성하시오.
    point :
        - 첫 번째 줄에는 지도의 크기 N(정사각형이므로 가로와 세로의 크기는 같으며 5≤N≤25)이 입력되고, 그 다음 N줄에는 각각 N개의 자료(0혹은 1)가 입력된다.
        - 첫 번째 줄에는 총 단지수를 출력하시오. 그리고 각 단지내 집의 수를 오름차순으로 정렬하여 한 줄에 하나씩 출력하시오.
        - 인접 행렬로 선언하여 문제 풀이가 가능하다.
    explain :
        - visited 배열을 선언해놨는데도 무한 루프에 빠졌다. << while(!q.isEmpty) 문 때문에 무한 루프에 걸렸었다. 이걸 삭제하고 bfs(new int[] {nx, ny})를 써주니
        잘 해결 되었다!!!
        - group 을 따로 빼내 단지를 설정한다. bfs가 돈다면 같은 단지니까 bfs 내에서 이 변수를 증가시켜서는 안된다!
        - bfs를 다 돌면 cntSector 변수를 초기화 시켜주는 것이 중요하다. 일단 bfs가 돌았다는 것은 1개라도 있다는 말이니 1부터 시작한다.
        - 단지 내에 있는 집의 개수는 오름차순으로 정렬해서 출력해야 하니 ArrayList로 선언하여 sort 를 진행한 후 출력해주었다.
    conclusion :
        이제야 좀 bfs 감이 오기 시작했다. while 문을 쓰기보다 재귀를 사용하도록 하자.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class BK2667 {
    static int N;
    static int cntSector = 1;
    static List<Integer> cntHouse;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N + 1][N + 1];
        visited = new boolean[N + 1][N + 1];
        cntHouse = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = Character.getNumericValue(str.charAt(j));
            }
        }
        int group = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    group++;
                    int house = bfs(new int[]{i, j});
                    cntHouse.add(house);
                    cntSector = 1;
                }
            }
        }
        System.out.println(group);
        Collections.sort(cntHouse);
        for (int i : cntHouse) {
            System.out.println(i);
        }
    }

    public static int bfs(int[] vertex) {
        Queue<int[]> q = new LinkedList<>();
        int[] dx = new int[]{1, -1, 0, 0};
        int[] dy = new int[]{0, 0, 1, -1};
        q.add(vertex);
        int x = vertex[0];
        int y = vertex[1];
        visited[x][y] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < N && nx >= 0 && ny < N && ny >= 0) {
                if (!visited[nx][ny] && map[nx][ny] == 1) {
                    q.add(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    bfs(new int[]{nx, ny});
                    cntSector++;
                }
            }
        }
        return cntSector;
    }
}
