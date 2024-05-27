package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int amountOfMoney = InputView.money()%1000; // 구매 횟수
        List<Integer> goalNumber = InputView.goalNumber(); // 당첨 번호
        int bonusNumber = InputView.bonusNumber(); // 보너스
        Lotto lotto = new Lotto(goalNumber);

        int []result = new int[7];
        // 구매금액 만큼 반복

        OutputView.printNum(amountOfMoney);
        for(int i = 0; i<amountOfMoney ; i++){
            int grade = lotto.random(bonusNumber); // 몇등인지 결과 반환
            // 등급index에 ++ 해주기
            result[grade]++;
        }

        lotto.result(result); // 수익률

    }
}
