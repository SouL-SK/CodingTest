package algorithm;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

/**
 * 알고스팟 
 * BOGGLE
 * @author shuai
 * 먼저 풀기 전에 완전탐색, 분할 정복 알고리즘을 먼저 하고 오자.
 */
public class BOGGLE {
	static ArrayList<String> list = new ArrayList<String>();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int tc = Integer.parseInt(br.readLine());

		for (int i = 0; i < tc; tc++) {
			for (int input = 0; input < 5; input++) {
				list.add(br.readLine());
			}
			int N = Integer.parseInt(br.readLine());
			if (N < 1 || N > 10) {
				bw.write("Error :: 1 <= N(number of word) <= 10");
				System.exit(0);
			}
			for (int now = 0; now < N; now++) {
				String word = br.readLine();
				boolean ret = false;
				for (int y = 0; y < 5; y++) {
					for (int x = 0; x < 5; x++) {
							//단어가 있는지 여기서 확인
						if (ret == true) break;
					}
					if (ret == true) break;
				}
				bw.write(String.format("%s %s\n", word, ret ? "YES" : "NO"));
			}
		}
		bw.close();
	}
}
