package algorithm_java;
/*
    problem : baekjoon NO.23757
    task : 상훈이는 N개의 선물 상자를 가지고 있다. 선물 상자에는 현재 담겨있는 선물의 개수가 적혀있다.
    선물을 받을 아이들이 M명 있다. 아이들은 각자 $1$에서 $M$까지의 서로 다른 번호를 하나씩 부여받았다.
    1번 아이부터 M번 아이까지 한 번에 한 명씩, 현재 선물이 가장 많이 담겨있는 상자에서 각자 원하는 만큼 선물을 가져간다.
    이 때, 앞서 누군가 선물을 가져갔던 선물 상자에서 또다시 가져가도 상관없다.
    하지만 상자에 자신이 원하는 것보다 적은 개수의 선물이 들어있다면, 선물을 가져가지 못해 실망한다.
    상훈이는 한 명이라도 실망하지 않고 모두가 선물을 가져갈 수 있는지 궁금하다.
    point :
        - priority queue를 사용하면 된다.
        - 무조건 가장 선물이 많이 든 상자를 먼저 꺼내어 아이에게 준다. 선물이 남으면 다시 힙으로 돌아간다.
        - 0은 안넣고 바로 뺀다. < 이건 추가해줘도 되는 부분이다. 하지만 Token으로 문자열을 다 받았으니 그냥 한 번에 다 넣어주었다.
        - 중간에 수량이 부족하다면 0을 출력, 전부 다 돌았다면 1을 출력한다.
        - 빠른 출력을 사용하면 시간을 단축할 수 있다. java 의 BufferedReader, BufferedWriter, InputStreamReader, OutputStreamWriter 등
        - java priority queue는 기본적으로 최소 힙이다. Collectios.reverseOrder()로 선언해주면 최대 힙으로 만들 수 있다.
        - readLine() 은 개행 문자(\n) 를 포함한 한 줄(line)을 가져오기 때문에, 3번 readLine() 해주어야 3줄을 가져올 수 있다.
        - StringTokenizer에서 delim 값을 " "로 주어 Token에 한 문자씩 넣어준 뒤, for문을 N만큼 돌려주어 priority queue에 다 넣는다.
        - Time Complexity : O(N), elapsed time : 508 ms, memory : 37312 kb
 */
import java.util.Collections;
import java.util.PriorityQueue;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BK23757 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> gift = new PriorityQueue<>(Collections.reverseOrder());
        int result = 1;

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < N ; i++){
            gift.add(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0 ; i < M ; i++){
            int child = Integer.parseInt(st.nextToken());
            if(gift.peek() >= child){
                gift.offer(gift.peek()-child);
                gift.poll();
            }else{
                result = 0;
            }
        }
        System.out.print(result);

    }
}
