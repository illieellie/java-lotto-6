package lotto;

import java.lang.reflect.Array;
import java.util.*;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        OutputView.printMent1();
        int amountOfMoney = InputView.money() / 1000; // 구매 횟수

        // 랜덤 숫자 생성 후 list에 넣기
        List<List<Integer>> randomNumbers = new ArrayList<>();
        OutputView.printNum(amountOfMoney);

        for (int i = 0; i < amountOfMoney; i++) {
            List<Integer> itemList = new ArrayList<>();
            Set<Integer> randomNumber = new HashSet<>();

            while (randomNumber.size() != 6) {
                int temp = pickUniqueNumbersInRange(1, 45, 1).get(0);
                randomNumber.add(temp);
            }

            itemList.addAll(randomNumber.stream().toList());
            Collections.sort(itemList); // 정렬

            OutputView.printList(itemList);
            randomNumbers.add(i,itemList); // 2차원 배열에 삽입
        }

        OutputView.printMent2();
        List<Integer> goalNumber = InputView.goalNumber(); // 당첨 번호
        Lotto lotto = new Lotto(goalNumber);

        OutputView.printMent3();
        int bonusNumber = InputView.bonusNumber(); // 보너스

        // 검사
        int[] result = new int[7];
        // 구매금액 만큼 반복
        for (int i = 0; i < amountOfMoney; i++) {
            int grade = lotto.checkGoal(bonusNumber, randomNumbers.get(i)); // 몇등인지 결과 반환
            result[grade]++;
        }
        OutputView.printGrade(result);
        lotto.result(result, amountOfMoney * 1000); // 수익률

    }
}
