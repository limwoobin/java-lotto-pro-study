import lotto.domain.LottoGame;
import lotto.domain.Price;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoGameTest {
    @Test
    @DisplayName("5000원을 입력하면 5장의 로또 번호가 생성되어야 한다.")
    void 로또_5장_생성확인() {
        Price price = new Price(5000);
        LottoGame lottoGame = new LottoGame(price);

        assertThat(lottoGame.getLottos().size()).isEqualTo(5);
    }

    @Test
    @DisplayName("5000원으로 로또를 5장 구매할 수 있다")
    void price_5000원_5장_test() {
        Price price = new Price(5000);
        LottoGame lottoGame = new LottoGame(price);
        assertThat(lottoGame.getLottoCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("5500원으로 로또를 5장 구매할 수 있다")
    void price_5500원_5장_test() {
        Price price = new Price(5500);
        LottoGame lottoGame = new LottoGame(price);
        assertThat(lottoGame.getLottoCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("1000원 미만이면 로또를 구매할 수 없다.")
    void test1() {

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            Price price = new Price(500);
            LottoGame lottoGame = new LottoGame(price);
        });
    }



}
