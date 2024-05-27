package lotto;

import java.util.*;

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
                if (validationMoney(amountOfMoney)) {
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


    public static boolean validationMoney(int amountOfMoney) {
        try {
            if (amountOfMoney % 1000 != 0) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 값을 입력했습니다. 다시 입력해주세요.");
            return false;
        }
        return true;
    }

    public static List<Integer> goalNumber() {
        List<Integer> arrayList = new ArrayList<>();
        while (true) {
            arrayList.clear();
            String[] stringArray = readLine().split(",");
            try {
                for (int i = 0; i < stringArray.length; i++) {
                    arrayList.add(Integer.parseInt(stringArray[i])); // 변환하기 불편
                    // 예외1. 숫자로 변환이 안 되는 경우
                }
            } catch (NumberFormatException e) {
                try {
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException e2) {
                    System.out.println("[ERROR] 잘못된 값을 입력했습니다. 다시 입력해주세요.");
                    continue;
                }
            }
            if (validationGoalNumber(arrayList)) {
                break;
            }
        }
        return arrayList;
    }

    public static boolean validationGoalNumber(List<Integer> arrayList) {
        // 예외1. 숫자 여섯개가 맞는지
        Set<Integer> tempSet = new HashSet<>();
        tempSet.addAll(arrayList);
        try {
            if (tempSet.size() != 6) {
                throw new IllegalArgumentException();
            }
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 잘못된 값을 입력했습니다. 다시 입력해주세요.");
            return false;
        }
        return true;
    }

    public static int bonusNumber() {
        int bonusNum = 0;
        while (true) {
            String s = readLine();
            try {
                bonusNum = Integer.parseInt(s);
                break;
            } catch (NumberFormatException e) {
                try {
                    throw new IllegalArgumentException();
                } catch (IllegalArgumentException e2) {
                    System.out.println("[ERROR] 잘못된 값을 입력했습니다. 다시 입력해주세요.");
                }
            }
        }
        return bonusNum;
    }
}
