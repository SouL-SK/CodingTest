package algorithm_java;
/*
    problem : baekjoon NO.1181
    task : 알파벳 소문자로 이루어진 N개의 단어가 들어오면 아래와 같은 조건에 따라 정렬하는 프로그램을 작성하시오.
        1. 길이가 짧은 것부터 2. 길이가 같으면 사전 순으로
        첫째 줄에 단어의 개수 N이 주어진다. (1 <= N <= 20,000)
        둘째 줄부터 N개의 줄에 걸쳐 알파벳 소문자로 이루어진 단어가 한 줄에 하나씩 주어진다.
        주어지는 문자열의 길이는 50는 넘지 않는다.
        조건에 따라 정렬하여 단어들을 출력한다. 단, 같은 단어가 여러 번 입력된 경우에는 한 번씩만 출력한다.
    point :
        문자열을 char로 바꿔서 오름차순으로 정렬한다. 혹은 ArrayList 정렬을 사용해도 되겠다.
        i
        im
        it
        no
        more
        but
        wait
        wont
        cannot
        hesitate
        yours
        예제에서 막혔다. 이걸 다시 한 번 뜯어보자. 알고리즘 다시 파악하자.
    explain :
    conclusion :
 */

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class BK1181 {
    public static void main(String[] args) throws IOException {
        ArrayList<String> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
//            br = new BufferedReader(new InputStreamReader(System.in));
            list.add(br.readLine());
        }
//        String[] strList = new String[list.size()];
//        for (int i = 0; i < list.size(); i++) {
//            strList[i] = list.get(i);
//        }
//        for (int i = 0; i < list.size(); i++) {
//            for (int j = i + 1; j < list.size() - 1; j++) {
//                if (strList[j].length() <= strList[i].length()) {
//                    String temp = strList[j];
//                    strList[j] = strList[i];
//                    strList[i] = temp;
//                }
//                if (strList[j].equals(strList[i])) {
//                }
//            }
//        }
        Collections.sort(list);
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size() - 1; j++) {
                if (list.get(i).length() > list.get(j).length()) {
                    String temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
                if (list.get(i).equals(list.get(j))) {
                    list.remove(j);
                }
            }
        }
        for (String str : list) {
            System.out.println(str);
        }
//        for (int i = 0; i < strList.length; i++) {
//            System.out.println(strList[i]);
//        }
    }
}
