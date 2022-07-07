package algorithm_java;
/*
    problem : beakjoon NO.7758
    task : 상근이는 모든 사람의 출입카드 시스템의 로그를 가지고 있다.
    이 로그는 어떤 사람이 회사에 들어왔는지, 나갔는지가 기록되어져 있다.
    로그가 주어졌을 때, 현재 회사에 있는 모든 사람을 구하는 프로그램을 작성하시오.
    point :
        - 첫째 줄에 로그에 기록된 출입 기록의 수 n이 주어진다.
        (2 ≤ n ≤ 106) 다음 n개의 줄에는 출입 기록이 순서대로 주어지며, 각 사람의 이름이 주어지고 "enter"나 "leave"가 주어진다.
        "enter"인 경우는 출근, "leave"인 경우는 퇴근이다.
        - 회사에는 동명이인이 없으며, 대소문자가 다른 경우에는 다른 이름이다. 사람들의 이름은 알파벳 대소문자로 구성된 5글자 이하의 문자열이다.
        - 현재 회사에 있는 사람의 이름을 사전 순의 역순으로 한 줄에 한 명씩 출력한다.
    explain :
        - 입출력을 받을 때 시간 제한이 1초, 입력의 개수는 10^6개 까지 들어오니까 Scanner를 써도 되겠지만, 사용의 편의를 위해서 BufferedReader를 쓸 것이다.
        또한 key와 value 값은 공백을 기준으로 구분되는 한 줄로 입력이 들어오기 때문에 StringTokenizer를 사용하여 한 줄에 받은 뒤 각각 treeMap의 key 와 value에 넣어줄 것이다.
        - 출력할 때는 그냥 treeMap에서 바로 출력하면 될 것이다.
        처음에 저장할 때 treeMap은 오름차순 순서로 데이터를 저장한다. 그렇기 때문에 저장할 때 Collections.reverseOrder()을 객체 옵션에 넣어주면 된다.
        - 대소문자를 구분하여 이름에 따라 enter, leave 상태를 바로 뽑아와야 하기 때문에 map 방식을 선택하는 것이 맞을 것 같다.
        먼저 enter, leave 상태는 중복값으로 들어갈 수 있어야 하기 때문에 set은 들어갈 수 없고, 빠른 search가 필요하기 때문에 tree 구조나 hash algorithm 을 이용한다.
        이름은 중복이 될 수 없기 때문에 key 값으로 적절하고, 출퇴근 상태는 중복이 될 수 있기 때문에 value 값으로 적절하다.
        출력할 때 사전 순의 역순으로 출력해야 하기 때문에 sort되어 들어가는 map 자료구조를 선택해야 한다. 즉, treeMap만 남는다.
        결론 : treeMap 을 사용.
        - 기존에는 모든 입력값을 treeMap에 넣고 enter 상태인 key들만 출력하려고 했으나 그러면 tree 내에서 연산 시간이 오래 걸린다.
        입력값을 확인하고 들여보내기로 결정했다. 물론 leave 인 경우에 만약 treeMap 내에 key 값과 중복되는 값이 있다면 그 값을 treeMap 내에서 지운다.
        - time complexity : O (NlogN), elapsed time : 1372 ms, memory : 53908 kb
    conclusion :
        생각보다 쉬운 문제였다. 어떤 자료구조를 쓸지, 해당 자료구조를 어떻게 선언할 지만 안다면 쉽게 접근할 수 있던 문제라고 본다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.TreeMap;
import java.util.Collections;

public class BK7785 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<String, String> empList = new TreeMap<>(Collections.reverseOrder());
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < n; i++) { // O(N)
            st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String status = st.nextToken();
            if (empList.isEmpty()) {
                if (Objects.equals(status, "enter")) {
                    empList.put(name, status); // O(log N)
                }
            } else {
                if (empList.containsKey(name)) { // O(log N)
                    if (Objects.equals(status, "leave")) {
                        empList.remove(name); // O(log N)
                    }
                } else if (Objects.equals(status, "enter")) {
                    empList.put(name, status); // O(log N)
                }
            }
        }
        for (String str : empList.keySet()) {
            System.out.print(str + " ");
        }
    }
}
