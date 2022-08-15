import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoTest {
    @Test
    @DisplayName("자동 생성 번호 테스트")
    void 로또_번호생성_test() {
        Lotto 로또 = new Lotto();
        List<LottoNumber> 로또번호 = 로또.getLotto();

        assertThat(로또번호.size()).isEqualTo(6);
    }

    @Test
    @DisplayName("당첨번호 테스트 - 6자리가 아니면 에러")
    void 당첨번호_입력_test1() {

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            List<LottoNumber> 입력당첨번호 = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5));

            Lotto 당첨번호 = new Lotto(입력당첨번호);

        });
    }

    @Test
    @DisplayName("당첨번호 테스트 - 중복 숫자 에러")
    void 당첨번호_입력_test4() {

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            List<LottoNumber> 입력당첨번호 = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(5));

            Lotto 당첨번호 = new Lotto(입력당첨번호);

        });
    }

    @Test
    @DisplayName("당첨번호 테스트 - 유효한 숫자가 포함되어 있지 않으면 에러")
    void 당첨번호_입력_test2() {

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            List<LottoNumber> 입력당첨번호 = Arrays.asList(new LottoNumber(1), new LottoNumber(2), new LottoNumber(3), new LottoNumber(4), new LottoNumber(5), new LottoNumber(5));

            Lotto 당첨번호 = new Lotto(입력당첨번호);

        });
    }
}
