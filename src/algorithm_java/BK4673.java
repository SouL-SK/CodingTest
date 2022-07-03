package algorithm_java;
/*
    problem : baekjoon NO.4673
    task : 10000보다 작거나 같은 셀프 넘버를 한 줄에 하나씩 출력하는 프로그램을 작성하시오.
    point :
        - 생성자가 없는 숫자를 셀프 넘버라고 한다.
        100보다 작은 셀프 넘버는 총 13개가 있다. 1, 3, 5, 7, 9, 20, 31, 42, 53, 64, 75, 86, 97
        - 한 줄에 하나씩 출력해야한다. 그렇다고 a lot more numbers 문자를 출력하는 것은 절대 아니다.
        - 양의 정수. 즉 0보다 크고 10000 보다 작거나 같은 수 중에 셀프 넘버(self number) 을 출력하면 된다.
        - 구현 방식은 1 부터 10000까지 검사한 뒤, 해당 수를 생성자로 하는 수가 있으면 그 수를 거르는 것이다.
 */
public class BK4673 {

    public static void main(String[] args) {
        boolean[] check = new boolean[10001];	// 1부터 10000이므로
        for (int i = 1; i < 10001; i++){
            int n = d(i);
            if(n < 10001){	// 10000 이 넘는 수는 필요가 없음
                check[n] = true;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < 10001; i++) {
            if (!check[i]) {	// false 인 인덱스만 출력
                sb.append(i).append('\n');
            }
        }
        System.out.println(sb);
    }

    public static int d(int number){
        int sum = number;
        while(number != 0){
            sum = sum + (number % 10); // 첫 째 자리수
            number = number/10;	// 10을 나누어 첫 째 자리를 없앤다
        }
        return sum;
    }
}