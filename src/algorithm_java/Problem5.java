package algorithm_java;/*
  문제 5 : 숫자 0을 입력하기 전까지 계속해서 숫자 입력을 받은 후,
    입력받은 숫자 중 소수(Prime number)만 리스트 형태로 출력합니다.
  풀이 과정 >
   - 0을 입력하기 전까지 무한으로 입력받기에 while 반복믄을 사용하기로 결정.
   - 소수는 2 이상이면서, 1과 본인만을 약수로 갖고 있는 수이다.
   - 구현 예시를 토대로 결과 리스트는 오른차순 정렬, 중복 입력 불가한 점을 토대로 HashSet 을 이용하여 입력값을 받기로 결정.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args){

        //object declaration
        HashSet<Integer> valueList = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        //variable declaration
        int inputValue = 0;

        System.out.println("[안내] 0을 입력하시면 입력이 종료 됩니다.");
            // get inputs and check prime number
        do{
            try{
                System.out.print("숫자 " + (valueList.size()+1) + " : ");
                inputValue = sc.nextInt();
            }catch(Exception e){
                System.out.println("[입력오류] : 이미 입력된 숫자 혹은 잘못된 숫자입니다.");
                System.out.print("숫자 " + (valueList.size()+1) + " : ");
                sc = new Scanner(System.in);
                inputValue = sc.nextInt();
            }finally {
                if(valueList.add(inputValue)){
                    if(isPrime(inputValue)) {
                        result.add(inputValue);
                    }
                }else{
                    System.out.println("[입력오류] : 이미 입력된 숫자 혹은 잘못된 숫자입니다.");
                }
            }
        }
        while(inputValue != 0);

            // print the result
            System.out.print("결과 : ");
            Collections.sort(result);
            for(int i = 0; i < result.size()-1; i++){
                System.out.print(result.get(i) + ", ");
            }
            System.out.println(result.get(result.size()-1));
    }

    /**
     * check number is prime number or not
     * @param number number to check
     * @return number is prime number or not
     */
    static boolean isPrime(int number){
        // the number must be >= 2
        if(number < 2){
            return false;
        }else if(number == 2){
            return true;
        }else{
            for (int i = 2; i < number;i++){
                if(number % i == 0){
                    return false;
                }
            }
            return true;
        }
    }
}