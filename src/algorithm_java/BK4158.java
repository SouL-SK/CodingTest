package algorithm_java;
/*
    problem : baekjoon NO.4158
    task : 상근이와 선영이는 동시에 가지고 있는 CD를 팔려고 한다. CD를 몇 개나 팔 수 있을까?
    point :
        - set을 사용하여 size의 변화를 보고, 변화가 없다면 cnt++, 변화가 있다면 continue를 한다.
        size 말고 contain() 을 이용하여 있는지 없는지를 if 문으로 나누어 cnt++ 을 해주어도 된다.
        - map을 이용하여 풀 수도 있다.
        - time complexity : O(n + m), elapsed time : 1176 ms, memory : 248496 kb
 */

import java.util.HashSet;
import java.util.Set;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BK4158 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> cd;
        int cnt = 0;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            if (N == 0 && M == 0) break;
            cnt = 0;
            cd = new HashSet<>();
            for (int i = 0; i < N; i++) {
                cd.add(Integer.parseInt(br.readLine()));
            }
            for (int i = 0; i < M; i++) {
                int temp = Integer.parseInt(br.readLine());
                if (cd.contains(temp)) {
                    cnt++;
                }
            }
//            int temp = cd.size();
//            String str1 = st.nextToken();
//            cd.add(str1);
//            if(temp == cd.size()){
//                cnt++;
//            }
            System.out.println(cnt);
        }
    }
}
