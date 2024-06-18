package lotto;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.LottoGrade.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        Set<Integer> tempSet = new HashSet<>();
        tempSet.addAll(numbers);
        if (tempSet.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    public boolean isContain(int value){
        if(numbers.contains(value)){
            return true;
        }
        return false;
    }

    public List<Integer> getList() {
        return numbers;
    }

    public int valueOfIndex(int idx) {
        return numbers.get(idx);
    }
}

