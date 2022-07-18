import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PriceTest {


    @Test
    @DisplayName("1000원 미만이면 로또를 구매할 수 없다.")
    void price_1000원_미만_test() {

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            new Price(0);
        });
    }

    @Test
    @DisplayName("5000원으로 로또를 5장 구매할 수 있다")
    void price_5000원_5장_test() {
        Price price = new Price(5000);
        assertThat(price.getLottoCount()).isEqualTo(5);
    }

    @Test
    @DisplayName("5500원으로 로또를 5장 구매할 수 있다")
    void price_5500원_5장_test() {
        Price price = new Price(5500);
        assertThat(price.getLottoCount()).isEqualTo(5);
    }
}
