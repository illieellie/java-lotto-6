package lotto;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    // 유틸성 클래스
    static int amountOfMoney = 0;
    private InputView() {
    }

    public static int money() {
        while (true) {
            try {
                amountOfMoney = Integer.parseInt(readLine());
                if (validation(amountOfMoney)) {
                    break;
                }
            } catch (NumberFormatException e) {
                try {
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException e2) {
                    System.out.println("[ERROR] 잘못된 값을 입력했습니다. 다시 입력해주세요.");
                }
            }
        }
        return amountOfMoney;
    }
        // * 15라인 안 넘어가도록 구현을 못하겠음

        // 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
        // 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException를 발생시키고,
        // "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

        // 예외1. 문자->정수 변환이 안 될 경우
        // 예외2. 1000원 단위가 아닌 경우


    public static boolean validation(int amountOfMoney){
        try{
        if (amountOfMoney % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        }catch (IllegalArgumentException e){
            System.out.println("[ERROR] 잘못된 값을 입력했습니다. 다시 입력해주세요.");
            return false;
        }
        return true;
    }

    public static List<Integer> goalNumber(){
        // string 쉼표로 구분해서 배열에 넣고 싶음
        String []stringArray = readLine().split(",");
        int[] intArray = Arrays.stream(stringArray)
                .mapToInt(Integer::parseInt)
                .toArray();
        List<Integer> arrayList = new ArrayList<>();
        for(int i = 0; i<stringArray.length; i++){
            arrayList.add(Integer.parseInt(stringArray[i]));
        }
        // 변환하기 불편하다
        return arrayList;
    }
}
