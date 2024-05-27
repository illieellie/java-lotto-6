package lotto;

import java.util.List;
import java.util.stream.Stream;

public class OutputView {

    public static void printMent1(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public static void printMent2(){
        System.out.println("\n당첨 번호를 입력해 주세요.");
    }
    public static void printMent3(){
        System.out.println("\n보너스 번호를 입력해 주세요.");
    }

    public static void printNum(int amountOfMoney) {
        System.out.println("\n" + amountOfMoney + "개를 구매했습니다.");
    }

    public static void printList(List<Integer> list) {
        System.out.println(list);
    }

    public static void printGrade(int[] result) {
        String s = "\n당첨 통계\n---\n" + "3개 일치 (5,000원) - " + result[5] + "개\n" +
                "4개 일치 (50,000원) - " + result[4] + "개\n" +
                "5개 일치 (1,500,000원) - " + result[3] + "개\n" +
                "5개 일치, 보너스 볼 일치 (30,000,000원) - " + result[2] + "개\n" +
                "6개 일치 (2,000,000,000원) - " + result[1] + "개";
                System.out.println(s);
    }

    public static void printResult(double result){
        System.out.println("총 수익률은 "+String.format("%.1f", result)+"%입니다.");

    }

}
