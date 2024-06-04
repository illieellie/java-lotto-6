package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static lotto.LottoGrade.*;

public class Game {
    private int bonusNumber;
    private Lotto goalNumber; //Lotto 형식으로 해도 될듯
    
    public Game(Lotto goalNumber, int bonusNumber){
        this.goalNumber = goalNumber;
        this.bonusNumber = bonusNumber;
    } // 생성자 
    
    public int checkGoal(Lotto randomNumberList) {
        // List<Integer> numbers 와 비교
        int score = 0;

        Set<Integer> userNumber = new HashSet<>();
        userNumber.addAll(randomNumberList.getList());

        for (int i = 0; i < 6; i++) {
            int temp = goalNumber.valueOfIndex(i);
            if (userNumber.contains(temp)) {
                // 한개의 숫자를 맞춘거임
                score++;
            }
        }
        // 6개를 맞추고 나서 보너스 넘버를 한번 더 체크
        if (score == 6) {
            score++;
        } else if (score == 5 && userNumber.contains(bonusNumber)) {
            score++; // 3등에서 2등
        }
        return gradeCheck(score);
    }

    private int gradeCheck(int score) {
        // 스코어에 따른 등급 반환
        return LottoGrade.getGradeFromScore(score);
    }

    public double result(int[] result, int investmentMoney) {
        //  double[] arr = {0, 2000000000, 30000000, 1500000, 50000, 5000};
        double profits = result[1] * GRADE_1.getMoney()+ result[2] * GRADE_2.getMoney() + result[3] * GRADE_3.getMoney() +
                result[4] * GRADE_4.getMoney() + result[5] * GRADE_5.getMoney();
        if (investmentMoney == 0) {
            return 0;
        }
        return profits / investmentMoney * 100;
        // 수익률 반환
        // 수익금/투자금*100
        // 소수점 둘째 자리에서 반올림
    }
    
    
    

}
