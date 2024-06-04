package lotto;

import java.util.*;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    // 유틸성 클래스
    private static int amountOfMoney = 0;
    private static final int ONE_THOUSAND = 1000;

    private InputView() {
    }

    public static int money() {
        while (true) {
            try {
                amountOfMoney = Integer.parseInt(readLine());
                if (amountOfMoney % ONE_THOUSAND != 0) {
                    throw new IllegalArgumentException();
                }
                return amountOfMoney;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 잘못된 값을 입력했습니다. 다시 입력해주세요.");
            }
        }
    }

    public static List<Integer> goalNumber() {
        Set result = new HashSet();
        while (true) {
            String[] s = readLine().split(",");
            try {
                for (int i = 0; i < s.length; i++) {
                    result.add(Integer.parseInt(s[i])); // 예외 1. 숫자로 변환이 안 되는 경우
                }
                if (result.size() != 6) { // 예외 2. 숫자 6개가 맞는지
                    throw new IllegalArgumentException();
                }
                return new ArrayList<>(result);
            } catch (IllegalArgumentException e) { // NumberFormatException 는 IllegalArgumentException의 서브 클래스
                System.out.println("[ERROR] 잘못된 값을 입력했습니다. 다시 입력해주세요.");
            }
        }
    }

    public static int bonusNumber(Lotto goalNumber) {
        int bonusNum = 0;
        while (true) {
            try {
                bonusNum = Integer.parseInt(readLine());
                if (goalNumber.isContain(bonusNum)) {
                    throw new IllegalArgumentException(); // 당첨 번호에 있는 번호와 중복되는 번호라면
                }
                return bonusNum;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 잘못된 값을 입력했습니다. 다시 입력해주세요.");
            }
        }
    }
}
