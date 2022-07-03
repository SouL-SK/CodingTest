package algorithm_java;
/*
    problem : baekjoon NO.1018
    task : 보드가 체스판처럼 칠해져 있다는 보장이 없어서,
    지민이는 8×8 크기의 체스판으로 잘라낸 후에 몇 개의 정사각형을 다시 칠해야겠다고 생각했다.
    당연히 8*8 크기는 아무데서나 골라도 된다.
    지민이가 다시 칠해야 하는 정사각형의 최소 개수를 구하는 프로그램을 작성하시오.
    point :
        - 첫째 줄에 N과 M이 주어진다. N과 M은 8보다 크거나 같고, 50보다 작거나 같은 자연수이다. 둘째 줄부터 N개의 줄에는 보드의 각 행의 상태가 주어진다. B는 검은색이며, W는 흰색이다.
        - 첫째 줄에 지민이가 다시 칠해야 하는 정사각형 개수의 최솟값을 출력한다.
        - 어떤 크기로 주어지던, 최소로 칠할 수 있는 8×8 크기를 찾아내야 한다.
        - 경우의 수는 (가로 칸 개수 - 7) × (세로 칸 개수 - 7) 이다.
        - 경우의 수 = 2 × (가로 칸 개수 - 7) × (세로 칸 개수 - 7)
        - 알고리즘은 기본적으로 W(하얀색) 과 B(검은색)을 구분하기 위해 boolean 2차원 배열을 사용 할 것이다. 그래서 W 일 때는 true, B 일때는 false 로 표현
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class BK1018 {
    public static boolean[][] arr;
    public static int min = 64;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new boolean[N][M];

        // 배열 입력
        for (int i = 0; i < N; i++) {
            String str = br.readLine();

            for (int j = 0; j < M; j++) {
                if (str.charAt(j) == 'W') {
                    arr[i][j] = true;		// W일 때는 true
                } else {
                    arr[i][j] = false;		// B일 때는 false
                }
            }
        }
        int N_row = N - 7;
        int M_col = M - 7;
        for (int i = 0; i < N_row; i++) {
            for (int j = 0; j < M_col; j++) {
                find(i, j);
            }
        }
        System.out.println(min);
    }

    public static void find(int x, int y) {
        int end_x = x + 8;
        int end_y = y + 8;
        int count = 0;

        boolean TF = arr[x][y];	// 첫 번째 칸의 색

        for (int i = x; i < end_x; i++) {
            for (int j = y; j < end_y; j++) {

                // 올바른 색이 아닐경우 count 1 증가
                if (arr[i][j] != TF) {
                    count++;
                }

                /*
                 * 다음 칸은 색이 바뀌므로
                 * true라면 false로, false 라면 true 로
                 * 값을 변경한다.
                 */
                TF = (!TF);
            }

            TF = !TF;
        }
        /*
         *  첫 번째 칸을 기준으로 할 때의 색칠 할 개수(count)와
         *  첫 번째 칸의 색의 반대되는 색을 기준으로 할 때의
         *  색칠 할 개수(64 - count) 중 최솟값을 count 에 저장
         */
        count = Math.min(count, 64 - count);
        /*
         * 이전까지의 경우 중 최솟값보다 현재 count 값이
         * 더 작을 경우 최솟값을 갱신
         */
        min = Math.min(min, count);
    }
}