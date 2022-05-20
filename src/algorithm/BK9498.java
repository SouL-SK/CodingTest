package algorithm;

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
