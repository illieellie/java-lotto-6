package lotto;

import java.util.stream.Stream;

public class OutputView {
    public static void printNum(int amountOfMoney) {
        System.out.println(amountOfMoney + "개를 구매했습니다.");
    }


    public static void printList(Stream<Integer> sorted) {
        System.out.println(sorted);
        // 어떻게 출력되는지 볼것
    }

    // 담청 결과 return
//        - 1등: 6개 번호 일치 / 2,000,000,000원
//        - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
//        - 3등: 5개 번호 일치 / 1,500,000원
//        - 4등: 4개 번호 일치 / 50,000원
//        - 5등: 3개 번호 일치 / 5,000원
}
