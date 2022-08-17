import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import lotto.view.InputView;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class InputViewTest {
    @Test
    @DisplayName("숫자가 아닌 문자가 입력된 경우 exception처리 ")
    void test1() {
        String[] lotto = {"a","1","2","3","4","5"};

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            InputView.parseLotto(lotto);
        });
    }
}
