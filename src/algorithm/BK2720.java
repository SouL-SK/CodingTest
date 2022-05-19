package algorithm;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BK2720 {
// ArrayIndexOutOfBound error 때문에 재작성
//	public static void main(String[] agrs) {
//		Scanner sc = new Scanner(System.in);
//		int count = sc.nextInt();
//		String[] list = new String[3];
//		try {
//
//			for (int i = 0; i < count; i++) {
//				list[i] = returnCoin(sc.nextInt());
//			}
//			for (int i = 0; i < list.length; i++) {
//				System.out.println(list[i]);
//			}
//		} catch (ArrayIndexOutOfBoundsException e) {
//			System.out.println(e);
//		}
//		finally {
//			
//			sc.close();
//		}
//	}
//
//	static String returnCoin(int coin) {
//		String result = "";
//		result += coin / 25 + " ";
//		result += (coin % 25) / 10 + " ";
//		result += ((coin % 25) % 10) / 5 + " ";
//		result += (((coin % 25) % 10) % 5) / 1 + " ";
//		return result;
//
//	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int tc = Integer.parseInt(br.readLine());
		
		while(tc-->0) {
			int money = Integer.parseInt(br.readLine());
			
			int q = money/25;
			money = money%25;
			int d = money/10;
			money = money%10;
			int n = money/5;
			money = money%5;
			int p = money;
			
			System.out.println(q+" "+d+" "+n+" "+p);
		}
	}
}
