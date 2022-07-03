package algorithm_java;
/*
    problem : baekjoon NO.5618
    task : 자연수 n개가 주어진다. 이 자연수의 공약수를 모두 구하는 프로그램을 작성하시오.
    point :
        - 두 자연수를 계속 비교하여 맞는 값을 찾아내고 이 값이 다 나누어 떨어진다면 공약수로 넣는다.
 */
import java.util.StringTokenizer;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BK5618 {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int A;
        int B;
        int C;

        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        if(n == 2) {
            //두 수중 작은수까지만 반복하는 반복문
            for(int i = 1; i <= Math.min(A, B); i++) {
                if(A % i == 0 && B % i == 0) {
                    System.out.println(i);
                }
            }
        }else {
            C = Integer.parseInt(st.nextToken());
            //세 수중 작은수까지만 반복하는 반복문
            for(int i = 1; i <= Math.min(A, Math.min(B, C)); i++) {
                if(A % i == 0 && B % i == 0 && C % i == 0) {
                    System.out.println(i);
                }
            }
        }
    }
}
