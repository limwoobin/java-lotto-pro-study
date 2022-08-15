import lotto.domain.LottoNumber;
import lotto.domain.LottoNumbers;
import org.junit.jupiter.api.Test;


import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;


public class LottoNumbersTest {

    @Test
    void 로또번호범위_test() {
        LottoNumbers 로또번호 = new LottoNumbers();
        assertThat(로또번호.getLottoNumbers().size()).isEqualTo(45);
    }

    @Test
    void 랜덤번호6자리생성_test() {
        List<LottoNumber> numbers = LottoNumbers.autoGenerateLottoNumbers();

        assertThat(numbers.size()).isEqualTo(6);
    }

    @Test
    void 중복된_숫자_체크_test() {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            List<Integer> numbers = Arrays.asList(1, 2, 3, 3, 4, 5);
            LottoNumbers 로또번호 = new LottoNumbers();
            로또번호.checkDupulicationNumber(numbers);
        });
    }
}
