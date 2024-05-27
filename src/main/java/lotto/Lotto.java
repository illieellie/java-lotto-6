package lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public int random(int bonusNumber) {

        int grade = 0;
        Set<Integer> randomNumber = new HashSet<>();
        while (randomNumber.size() != 6) {
            List<Integer> temp = pickUniqueNumbersInRange(1, 45, 1);
            randomNumber.add(temp.get(0));
        }
        OutputView.printList(randomNumber.stream().sorted());
        // 당첨이 되었는지 검사
        grade = checkGoal(randomNumber, bonusNumber);

        return grade;
    }

    private int checkGoal(Set<Integer> randomNumber, int bonusNumber) {
        // List<Integer> numbers 와 비교
        int score = 0;
        for (int i = 0; i < 6; i++) {
            int temp = numbers.get(i);
            if (randomNumber.contains(temp)) {
                // 한개의 숫자를 맞춘거임
                score++;
            }
        }
        // 6개를 맞추고 나서 보너스 넘버를 한번 더 체크
        if(score==6){
            score++;
        }
        else if(score==5 && randomNumber.contains(bonusNumber)){
            score++; // 3등에서 2등
        }
        return gradeCheck(score);
    }

    private int gradeCheck(int score){
        int []arr = {0,0,0,5,4,3,2,1};
        return arr[score];
    }

    public void result(int[] result) {
        // 수익률 반환
    }


    // TODO: 추가 기능 구현
}
