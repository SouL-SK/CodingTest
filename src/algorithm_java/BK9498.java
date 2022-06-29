package algorithm_java;
/*
	문제 : 백준 9498번 시험 성적
	설명 : 시험 점수를 입력받아 90 ~ 100점은 A, 80 ~ 89점은 B, 70 ~ 79점은 C, 60 ~ 69점은 D, 나머지 점수는 F를 출력하는 프로그램을 작성하시오.
	풀이 :
		- 첫째 줄에 시험 점수가 주어진다. 시험 점수는 0보다 크거나 같고, 100보다 작거나 같은 정수이다.
		- if 문으로 나누어 출력한다.
 */
import java.util.Scanner;
public class BK9498 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
		sc.close();
		if (score >= 90) {
			System.out.println("A");
		} else if (score >= 80) {
			System.out.println("B");
		} else if (score >= 70) {
			System.out.println("C");
		} else if (score >= 60) {
			System.out.println("D");
		} else {
			System.out.println("F");
		}
	}
//	public static void main(String[] args) {
//		Scanner in = new Scanner(System.in);
//		
//		int A = in.nextInt();
//		in.close();
//		
//		if(A>=90) System.out.println("A");
//		else if(A>=80) System.out.println("B");
//		else if (A>=70) System.out.println("C");
//		else if(A>=60) System.out.println("D");
//		else System.out.println("F");
//	}
//
//	public static void main(String[] args) throws IOException {
//        
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
// 
// 		int A = Integer.parseInt(br.readLine());
//        
//		if(A>=90) System.out.println("A");
//		else if(A>=80) System.out.println("B");
//		else if (A>=70) System.out.println("C");
//		else if(A>=60) System.out.println("D");
//		else System.out.println("F");
//	}
}
