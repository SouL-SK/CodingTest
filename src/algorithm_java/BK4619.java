package algorithm_java;
/*
    problem : baekjoon NO.4619
    task : 양의 정수 B와 N이 주어졌을 때, B에 가장 가까운 AN의 정수 A를 찾는 프로그램을 작성하시오.
    A^N은 B보다 작거나, 크거나, 같다.
    point :
        - A의 N 제곱이 B에 근접한 수를 구하려면 A에 1부터 넣어서 N제곱 했을때 B보다 작거나 같거나 큰 수 중 2개를 구하면 된다.
        그리고 두 값중 B와 제일 근접한 수를 찾으려면 B를 빼서 더 작은 수를 구하면 된다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BK4619 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스의 수가 정해져있지 않으니 무한루프 사용
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            //B와 근접한 A값을 저장할 변수
            int num1 = 0;
            int num2 = 0;

            //0 0 입력되면 무한루프 종료
            if(B == 0 && N == 0) {
                break;
            }

            int A = 0;
            //반복 횟수를 정하기 애매하기에 무한루프 사용
            while(true) {
                //A의 N제곱이 B보다 작거나 같거나 클때에 맞춰 num1 num2에 저장. 클경우엔 저장하고 반복문 종료
                //간단히 설명하면 B보다 작을때는 계속 저장하다보면 작은 수중 제일 작은 수가 저장될 것이다.
                //큰 수는 한번이라도 나오면 저장하고 종료되게 해둔 것이다.
                if(Math.pow(A, N) <= B) {
                    num1 = A;
                }else if(Math.pow(A, N) > B){
                    num2 = A;
                    break;
                }
                //반복문이 계속되는 동안 A에 1씩 더해간다.
                A++;
            }
            //삼항연산자로 A의 N제곱과 B의 차이가 누가 더 큰가를 본다.
            //하지만 두 갑의 차이를 보는 것이기에 음수가 나오면 안되니 절댓값으로 구해준다.
            int result = (Math.abs(Math.pow(num1, N) - B) <= Math.abs(Math.pow(num2, N) - B)) ? num1 : num2;

            System.out.println(result);
        }
    }
}
