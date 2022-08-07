import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {
    @Test
    @DisplayName("1~45 사이 숫자가 아니면 오류")
    void test1() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            LottoNumber lottoNumber = new LottoNumber(46);
        });
    }
}
