package algorithm_java;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;

/**
 * 백준 10026번 적록색약 문제
 * 
 * @author shuai
 *
 */
public class BK10026 {

	public static void main(String[] args) throws IOException, NoSuchElementException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = br.read();
		String s = br.readLine();

		String[][] list = new String[n][n];
		StringTokenizer st = new StringTokenizer(s, " ");
		for (int i = 0; i < n; i++) {
			int in = 0;
			while (st.hasMoreElements()) {
				list[in++][n] = st.nextToken();

			}
		}
		
		for (int i = 0; i < n; i++) {
			
		}
		
	}

}
