import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class LottoNumberTest {

    @Test
    void 로또번호범위_test() {
        LottoNumber 로또번호 = new LottoNumber();
        assertThat(로또번호.getLottoNumbers().size()).isEqualTo(45);
    }

    @Test
    void 랜덤번호6자리생성_test() {
        List<Integer> numbers = LottoNumber.autoGenerateLottoNumbers();

        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void 중복된_숫자_체크_test() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 5);
            LottoNumber 로또번호 = new LottoNumber();
            로또번호.checkDupulicationNumber(numbers);
        });
    }
}
