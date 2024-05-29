package lotto;

import camp.nextstep.edu.missionutils.test.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import camp.nextstep.edu.missionutils.test.NsTest;


class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    // 아래에 추가 테스트 작성 가능

    @DisplayName("번호가 몇개 일치하는 지 체크 후 등수를 반환한다.")
    @Test
    void checkLottoNumber() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 당첨
        assertThat(lotto.checkGoal(7, List.of(1, 2, 3, 4, 5, 6))).isEqualTo(1);
    }

    @DisplayName("번호가 몇개 일치하는 지 체크 후 등수를 반환한다.")
    @Test
    void checkLottoNumber2() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 당첨
        assertThat(lotto.checkGoal(7, List.of(1, 2, 3, 4, 5, 8))).isEqualTo(3);
    }

    @DisplayName("수익률이 제대로 프린트 되는지 확인")
    @Test
    void checkLottoGrade() {
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6)); // 당첨
        int[] grade = {0,1,0,0,0,0,0};

        assertThat(lotto.result(grade, 1000)).isEqualTo(200000000.0);

    }


}