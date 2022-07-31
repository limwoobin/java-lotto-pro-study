import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGameTest {
    @Test
    @DisplayName("5000원을 입력하면 5장의 로또 번호가 생성되어야 한다.")
    void 로또_5장_생성확인() {
        Price price = new Price(5000);
        LottoGame lottoGame = new LottoGame(price);

        assertThat(lottoGame.getLottos().size()).isEqualTo(5);
    }



}
