package algorithm_java;
/* 
    problem : baekjoon NO.2236
    task : n개의 정점을 갖는 이진 트리의 정점에 1부터 n까지의 번호가 중복 없이 매겨져 있다. 
    이와 같은 이진 트리의 인오더와 포스트오더가 주어졌을 때, 
    프리오더를 구하는 프로그램을 작성하시오.
    point : 
    <입력>
    첫째 줄에 n(1 ≤ n ≤ 100,000)이 주어진다. 
    다음 줄에는 인오더를 나타내는 n개의 자연수가 주어지고, 
    그 다음 줄에는 같은 식으로 포스트오더가 주어진다.
    <출력>
    첫째 줄에 프리오더를 출력한다.

이진트리란?
null or
자식이 두 개인 이진 트리. 
없는 거 처럼 보여도 null이 있다.
     1
null   1    < 이진 트리 O
 
     2      < 이진 트리 O
null  null



재귀 함수를 짤 때는 종료 조건이 중요하다.


------
    1
  2   3
 4 5 6 7
InOrder : 4 - 2 - 5 - 1 - 6 - 3 - 7
PostOrder : 4 - 5- 2 - 6 - 7 - 3 - 1
PreOrder : 1 - 2 - 4 - 5 - 3 - 6 - 7

PostOrder를 통해 root를 알아 낼 수 있다. 맨 마지막 숫자가 루트이다.
Inorder를 통해 root를 기준으로 한 왼쪽과 오른쪽 노드들을 알 수 있다.
PreOrder에서는 root가 제일 먼저 온다. 그리고 왼쪽 노드, 오른쪽 노드 순.
root는 PostOrder에서 찾고, 
InOrder에서는 root 기준으로 왼쪽 노드와 오른쪽 노드를 찾을 수 있다.

이진 트리는 스택이랑 관련이 있다. < 이 또한 찾아보자.
https://m.blog.naver.com/PostView.naver?isHttpsRedirect=true&blogId=sunkwang0307&logNo=221543896967

재귀 함수는 스택이다.
---
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class BK2263 {

	static int n;
	static int[] in, post, pre;

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		n = Integer.parseInt(br.readLine());
		
		// 크기 초기화
		in = new int[n];
		post = new int[n];
		pre = new int[n];

		// 인오더 입력
		int[] temp = Integer.parseInt(br.readLine().split(" "));
		for (int i = 0; i < n; i++) in[i] = temp[i];
		// 포스트오더 입력
		sarr = Integer.parseInt(br.readLine().split(" "));
		for (int i = 0; i < n; i++) post[i] = temp[i];

		// 여기서 재귀함수로 포스트오더로 root 찾아서 인오더에서 왼쪽 오른쪽을 구분.
		1개 노드 밖에 없을 때까지 내려가면 된다. root -> left -> right

		for (int n : pre)
			bw.write(n + " ");

		bw.flush();
	}
}