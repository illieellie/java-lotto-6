package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int amountOfMoney = InputView.money(); // 구매 금액
        List<Integer> goalNumber = InputView.goalNumber(); // 당첨 번호
        int bonusNumber = InputView.bonusNumber(); // 보너스
        Lotto lotto = new Lotto(goalNumber);


    }
}
