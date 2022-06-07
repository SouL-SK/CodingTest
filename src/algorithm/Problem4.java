package algorithm;

/*
    문제 4 : 숫자 0을 입력받기 전까지 계속해서 숫자 입력을 받은 후, 그 결과를 리스트 형태로 출력합니다.

    풀이 과정 >
        - 결과 값은 리스트 형태로 출력해야 하고, 출력과 삽입이 편해야 하기 때문에 ArrayList를 사용한다.
        - 숫자가 아닌 값을 입력받게 되면 예외처리를 통해 처리하고 다시 입력받을 수 있도록 한다.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args){

        //object declaration
        ArrayList<Integer> resultList = new ArrayList<>();

        int inputValue = 0;
        boolean flag = false;
        System.out.print("[안내] 0을 입력하시면 입력이 종료됩니다.\n");
        Scanner sc = null;
        do{
            try{
                System.out.print("숫자 "+(resultList.size()+1)+" : ");
                sc = new Scanner(System.in);
                inputValue = sc.nextInt();
            // check value is valid
            if (isValueNotZero(inputValue)){
                flag = true;
            }
            }catch (Exception e){
                System.out.println("[입력 오류] 숫자를 입력해주세요.");
                sc = new Scanner(System.in);
                System.out.print("숫자 "+(resultList.size()+1)+" : ");
                inputValue = sc.nextInt();
            }
            if (inputValue != 0){
                resultList.add(inputValue);
            }
        }while(!flag);

        if (resultList.size() == 0){

        }else{
            System.out.print("결과 : ");
            Collections.sort(resultList);
            for(int i = 0; i < resultList.size()-1;i++){
                System.out.print(resultList.get(i) + ", ");
            }
            System.out.println(resultList.get(resultList.size()-1));
        }
    }

    /**
     * check number is 0 or not
     * @param inputValue number to check
     * @return number is 0 or not
     */
    public static boolean isValueNotZero(int inputValue){
        return inputValue == 0;
    }
}
