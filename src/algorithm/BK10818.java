import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    백준 10818번
    문제 : n 개의 정수가 주어진다. 총 합을 구하시오
    풀이 : 문자열을 받기 때문에 버퍼사용
 */
public class BK10818 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String strList = br.readLine();
        int[] array = Integer.parseInt(strList.split(" "));

        int sum = 0;
        for(int i = 0;i<array.length;i++){
            sun += array[i];
        }
        System.out.println(sum);
    }
}
