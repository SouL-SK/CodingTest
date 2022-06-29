package algorithm_java;
/*
    문제 : 백준 17614번 369

    설명 : 민수는 같은 반 친구들과 369게임을 하고 있다. 369게임은 여러 명이 원형으로 둘러 앉아 시작 위치의 사람이 1을 외치며 시작된다.
            이후 시계방향으로 돌아가며 2, 3, 4와 같이 1씩 증가된 수가 자기 수가 된다.
            순서대로 돌아오는 자기 수에 3, 6, 혹은 9가 포함되어 있지 않다면 그 수를 말해야 하며, 3, 6, 혹은 9가 포함되어 있으면 그 개수만큼 박수를 쳐야 한다.
            이 규칙을 지키지 못하면 게임이 종료된다.
            민수는 369게임이 N까지 규칙을 지키며 진행된다면 그때까지의 들은 박수의 횟수 가 총 몇 번인지 궁금했다.
            예를 들어 N = 14라면, 3, 6, 9, 13에서 각각 한 번의 박 수를 치게 되므로 총 4회의 박수를 듣게 될 것이다.
            N = 36이라면 3, 6, 9, 13, 16. 19. 23. 26. 29. 30. 31. 32. 33. 34. 35, 36에서 박수를 치게 되는데 33, 36에서는 각 각 두 번 박수를 쳐야 하므로 총 18회가 된다.
            1 이상의 정수 N에 대하여 369게임을 N까지 규칙을 지키며 진행된다면 그때까지 듣게 되는 박수의 총 횟수를 계산하여 출력하는 프로그램을 작성하시오.

    풀이 :
        - 첫 번째 줄에 정수 N 이 주어진다. (1 <= N <= 10^6)
        - 조건문을 넣어 문자열에 3, 6, 9 가 들어가 있으면 박수 카운트를 추가한다. 두 개가 들어가 있으면 두 번 카운트
        - BufferedReager로 입력을 받은 뒤, split 으로 문자열을 1개씩 쪼개 3, 6, 9를 포함하고 있다면, 총 박수 횟수에 1씩 더한다.
        - BufferedReader로 쪼갤 필요 없이, 숫자 % 10 을 하면 일의 자리만 가져올 수 있다는 점을 이용
        - 경고: 1의 자리가 0 일 때를 생각해야한다.

        - 정수를 문자열로 바꾸는 것은 시간이 걸리기 때문에 정수 안에서 해결하는 것이 더 빠르다.
    다른 풀이 :
        - % 3 를 이용하여 3, 6, 9로 각 자리수 마다 true, false로 나누어 박수 카운트에 더한다.

    막힌 부분 :
        - string 메서드를 잘 활용하지 못했고, 특히 char을 이용하는 방법을 생각하지 못했다.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BK17614 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String nStr = "";
        char n;
        int result = 0;
        for(int i = 0;i<=N;i++){
            nStr = Integer.toString(i); //배열 안에 숫자 넣기

            for(int j = 0; j < nStr.length(); j++){
                n = nStr.charAt(j); //여기서 한 글자씩 가져온다
                if(n=='3'||n=='6'||n=='9'){
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
