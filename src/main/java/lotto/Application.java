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

        // 구매 금액만큼 로또 번호 구매, 출력
        OutputView.printNum(amountOfMoney);

        // 랜덤 숫자 생성 후 list에 넣기
        List<Lotto> randomNumbers = new ArrayList<>();

        for (int i = 0; i < amountOfMoney; i++) {
            List<Integer> temp = new ArrayList<>(pickUniqueNumbersInRange(1, 45, 6));// 6자리 로또 번호 생성
            Collections.sort(temp);
            OutputView.printList(temp);

            randomNumbers.add(new Lotto(temp)); // 2차원 배열에 삽입
        }

        // 당첨 번호 입력
        OutputView.printMent2();
        Lotto goalNumber = new Lotto(InputView.goalNumber());

        // 보너스 번호 입력
        OutputView.printMent3();
        int bonusNumber = InputView.bonusNumber(goalNumber);
        Game game = new Game(goalNumber,bonusNumber);

        // 구매 번호 당첨 검사
        int[] result = new int[7];
        for (int i = 0; i < amountOfMoney; i++) {
            int grade = game.checkGoal(randomNumbers.get(i)); // 몇등인지 결과 반환
            result[grade]++;
        }
        OutputView.printGrade(result);
        double profitRate = game.result(result, amountOfMoney * 1000); // 수익률
        OutputView.printResult(profitRate);
    }

}
