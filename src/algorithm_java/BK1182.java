package algorithm_java;
/*
    problem : baekjoon NO.1182
    task : N개의 정수로 이루어진 수열이 있을 때, 크기가 양수인 부분수열 중에서 그 수열의 원소를 다 더한 값이 S가 되는 경우의 수를 구하는 프로그램을 작성하시오.
    point :
        - 첫째 줄에 정수의 개수를 나타내는 N과 정수 S가 주어진다. (1 ≤ N ≤ 20, |S| ≤ 1,000,000) 둘째 줄에 N개의 정수가 빈 칸을 사이에 두고 주어진다.
        주어지는 정수의 절댓값은 100,000을 넘지 않는다.
        - 첫째 줄에 합이 S가 되는 부분수열의 개수를 출력한다.도
        - 백트랙킹 문제, dfs 로 풀이한다. (two pointer algorithm 공부하기)
        depth 와 sum를 dfs로 받아 depth가 N과 같을 때, sum 또한 S와 같다면 answer++을 하고 아니면 return을 한다.
        return하는 dfs는 depth에 +1을 하고 sum 에 해당 index 원소를 더한다.
    explain :
        - 부분 수열들을 돌아가며 더해 S가 나오는 경우의 수를 구해야 한다. 즉, 부분 수열을 전부 돌아야 한다.
        - 부분 수열의 크기를 1부터 N까지 만들어 부분 수열 마다 S가 나오는지 확인해 맞으면 cnt++, 아니면 continue를 한다.
        size가 1일 때 부터 N일 때를 만드려면, 1~N까지 이중 for문을 이용해보자 < 구현하지 못해 구글링 시
        - https://velog.io/@ilil1/%EB%B0%B1%EC%A4%80-1182%EB%B2%88-java 여기서 문제 해석 파트를 보자.
        dfs(depth + 1, sum + numList[depth]); (ㄱ -> ㄱㄴ 같은 상황)
        dfs(depth + 1, sum); (ㄱ -> ㄱ 같은 상황)
        즉, 모든 경우의 수는 뒤에 글자가 추가 되는 상황과 아닌 상황 둘로 나뉘어져 있기 때문에 저 두 가지 상황을 dfs에 넣어준다.
        종합하면 트리의 전위 순회 구조로 작동하기 때문
        (전위순회란 : root를 먼저 방문(왼쪽으로 쭉 간 뒤에 리프 노드에 다다르면 오른쪽 노드, 그 마저도 없으면 부모 노드의 오른쪽 노드)
        순회 방식은 https://m.blog.naver.com/rlakk11/60159303809 여기서 확인
    conclusion :
        구현력이 정말 너무 딸린다. 아니 구현력 보다는 think straight가 되질 않는 것 같다. 좀 더 알고리즘적인 사고 방식을 가지도록 하자.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BK1182 {
    static int N, S;
    static int[] numList;
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        numList = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < N; i++) {
            numList[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, 0);
        if (S == 0) System.out.println(answer - 1); // S 0일때 처리 (count 합이 0인 경우 공집합도 포함되므로 그 수를 하나 빼주고 출력)
        else  System.out.println(answer);
    }

    public static void dfs(int depth, int sum){
        if (depth == N) { // DFS로 돌며 누적시키다가 위치를 나타내는 v가 마지막 위치로 오면 원하는 값인지 아닌지 count after check
            if (sum == S) answer++;
            return;
        }
        dfs(depth + 1, sum + numList[depth]); // 1. 해당 인덱스 더함 (지금 위치의 원소를 선택)
        dfs(depth + 1, sum); // 2. 해당 인덱스 더하지않음 (지금 위치의 원소를 선택하지 않음)
    }
}
