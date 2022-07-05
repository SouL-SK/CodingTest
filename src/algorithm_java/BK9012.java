package algorithm_java;
/*
    problem : baekjoon NO.9012
    task : 입력으로 주어진 괄호 문자열(Parenthesis String)이 VPS(Valid PS)인지 아닌지를 판단해서 그 결과를 YES와 NO로 나타내는 프로그램을 짜시오.
    point :
        - stack 의 top() 연산을 이용하며 괄호를 받는 동시에 위에서 부터 차근차근 pop() 해나간다.
        마지막에 괄호가 남아있다면 NO, 비었다면 YES 를 출력한다.
        - 여는 괄호에 push
        - 닫는 괄호에서 if 문을 통해 push()할건지 pop()할건지 정하게 한다.
        - 입력을 받을 때, StringTokenizer으로 한 줄, 한 글자씩 어떻게 받아서 넣을지? < split을 사용하자.
        - EmptyStackException 에러가 뜬다. < String 배열에서 꺼내서 쓸 때, length 메서드를 제대로 사용하지 못했다.
        - StringBuilder에 바로 결과값을 넣어 출력하면 더 짧은 시간 안에 출력할 수 있다.
        - 시간 복잡도 : O(N^2), 소요 시간 : 128 ms, 메모리 : 14344 kb
 */
import java.util.Stack;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BK9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
//        String[] str = new String[N]; 굳이 배열로 선언해 저장해줄 필요가 없었다.
//        StringTokenizer st; StringTokenizer가 필요하진 않는다. 과정의 단순화를 하여,
//        바로 결과 값을 넣어주기 위해 따로 메서드를 만들어 그 메서드에서
//        입력값을 처리하고 StringBuilder에 넣어주면 된다.
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
//            st = new StringTokenizer(br.readLine(), "");
//            str[i] = st.nextToken();
//            바로 결과값을 sb에 넣어준다.
            sb.append(solve(br.readLine())).append('\n');
        }
//        while (true) {
//            for (int i = 0; i < str.length; i++) {
//                for (int j = 0; j < str[i].length(); j++) {
//                    if (Objects.equals(str[i].charAt(j), '(')) {
//                        psStk.push(str[i].charAt(j));
//                    } else if (Objects.equals(str[i].charAt(j), ')')) {
//                        if(Objects.equals(psStk.peek(), '(') && !psStk.isEmpty()){
//                            psStk.pop();
//                        }else{
//                            psStk.push(str[i].charAt(j));
//                        }
//                    }
//                }
//            if (psStk.empty()) System.out.println("YES");
//            else System.out.println("NO");
//            }
//            break;
//        }
        System.out.println(sb);
    }

    public static String solve(String str) {
        Stack<Character> psStk = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            // 여는 괄호일 경우 stack에 넣는다.
            if (c == '(') {
                psStk.push(c);
            }

            // 닫는 괄호일 경우들 (else if, else)
            // stack is empty, 즉, 닫는 괄호를 입력받았으나 pop할 원소가 없는 경우
            else if (psStk.empty()) {
                return "NO";
            }
            // 그 외의 경우 stack 내의 원소를 pop 한다.
            else {
                psStk.pop();
            }
        }
        if (psStk.empty()) {
            return "YES";
        } else {
            return "NO";
        }
    }
}
