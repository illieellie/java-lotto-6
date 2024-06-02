package lotto;

import java.lang.reflect.Array;
import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        // 구매 금액 입력
        OutputView.printMent1();
        int amountOfMoney = InputView.money() / 1000; // 구매 횟수

        // 랜덤 숫자 생성 후 list에 넣기
        List<List<Integer>> randomNumbers = new ArrayList<>();

        // 구매 금액만큼 로또 번호 구매, 출력
        OutputView.printNum(amountOfMoney);
        for (int i = 0; i < amountOfMoney; i++) {
            List<Integer> temp = new ArrayList<>(pickUniqueNumbersInRange(1, 45, 6));// 6자리 로또 번호 생성

            Collections.sort(temp);
            OutputView.printList(temp);
            randomNumbers.add(i, temp); // 2차원 배열에 삽입
        }

        // 당첨 번호 입력
        OutputView.printMent2();
        List<Integer> goalNumber = inputGoalNumber();
        Lotto lotto = new Lotto(goalNumber);

        // 보너스 번호 입력
        OutputView.printMent3();
        int bonusNumber = inputBonusNumber();

        // 구매 번호 당첨 검사
        int[] result = new int[7];
        for (int i = 0; i < amountOfMoney; i++) {
            int grade = lotto.checkGoal(bonusNumber, randomNumbers.get(i)); // 몇등인지 결과 반환
            result[grade]++;
        }
        OutputView.printGrade(result);
        double profitRate = lotto.result(result, amountOfMoney * 1000); // 수익률
        OutputView.printResult(profitRate);
    }

    // 정상적인 입력을 받을 때까지 실행을 해야할 때 어떤게 나은 방법인지 몰라 여러 방법으로 시도
    private static int inputBonusNumber() {
        int result = 0;
        while (true) {
            try {
                result = InputView.bonusNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 잘못된 값을 입력했습니다. 다시 입력해주세요.");
            }
        }
        return result;
    }


    private static List<Integer> inputGoalNumber() {
        List<Integer> result = new ArrayList<>();
        while (true) {
            try {
                result = InputView.goalNumber();
                break;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 잘못된 값을 입력했습니다. 다시 입력해주세요.");
            }
        }
        return result;
    }
}
