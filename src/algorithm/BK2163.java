package algorithm;

/**
 * 백준 2163번 초콜릿 자르기
 * 
 * 조건
 * - 초콜릿 크기는 N * M. 쪼개어 N * M 개의 조각을 만들 수 있다.
 * - 초콜릿을 쪼개면 두 개의 조각으로 나눠지고, 이 중에서 초콜릿 조각을 하나 들고 또 쪼갠다.
 * - 1 * 1 크기의 초콜릿으로 쪼개기 위한 최소 쪼개기 횟수를 구하는 프로그램을 작성하라.
 * 
 * 헷갈린 부분
 * - 반으로 나눈 뒤에 또 반으로 나누면서 조각 마다 횟수를 세야하는건지? 
 * - N * M 개를 몇 번 쪼개야 1 * 1 크기의 조각만 남는지 어떻게 아는지?
 *
 */
import java.util.Scanner;

public class BK2163 {
//	public static void main(String[] agrs) {
//		Scanner sc = new Scanner(System.in);
//		
//		while() <여기서 어떻게 조건문을 넣어야 할지 감이 안온다.
//	}
	
	static int[][] resultArray = null;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = Integer.parseInt(scan.nextLine().trim());
        
        /**
         * 공식 풀이
         * 먼저 M 또는 N개만큼 나눈다. 
         * 어느쪽으로 나누어도 결과는 똑같이 나온다. 
         * N개로 나눈다고 하자. N개로 나누기 위해서는 가로선을 따라 쪼개면 되는데 이 횟수는 N - 1, 즉 6번이 된다. 
         * 그리고 N개로 나누어진 초콜릿들을 각각 M개로 나누어야 한다. 이 횟수는 N x (M - 1)이다. 
         * 두 횟수를 더하면 N - 1 + N x (M - 1) 이 된다. 
         * 이는 N - 1 + (N x M) - N과 같으므로 N을 지워주면 N x M - 1 이라는 아주 간단한 공식이 나오게 된다.
         */
        System.out.println((M * N) - 1);
        scan.close();
    }
}
