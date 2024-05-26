package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int amountOfMoney = InputView.money();
        List<Integer> goalNumber = InputView.goalNumber();
        Lotto lotto = new Lotto(goalNumber);


    }
}
