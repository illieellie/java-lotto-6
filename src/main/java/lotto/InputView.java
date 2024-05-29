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

    public static List<Integer> goalNumber() throws IllegalArgumentException {
        List<Integer> result = new ArrayList<>();
        String[] s = readLine().split(",");
        try {
            // 변환하기 불편 string[] -> List<Integer>
            for (int i = 0; i < s.length; i++) {
                result.add(Integer.parseInt(s[i])); // 예외1. 숫자로 변환이 안 되는 경우
            }
            validationGoalNumber(result); // 예외2. 숫자 6개가 맞는지
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
        return result;
    }

    public static void validationGoalNumber(List<Integer> arrayList) throws IllegalArgumentException {
        // 예외2. 숫자 여섯개가 맞는지
        Set<Integer> tempSet = new HashSet<>();
        tempSet.addAll(arrayList);
        if (tempSet.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public static int bonusNumber() throws IllegalArgumentException{
        int bonusNum = 0;
            String s = readLine();
            try {
                bonusNum = Integer.parseInt(s);
            } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }
        return bonusNum;
    }
}
