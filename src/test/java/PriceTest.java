import lotto.domain.Price;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class PriceTest {


    @Test
    @DisplayName("1000원 미만이면 로또를 구매할 수 없다.")
    void price_1000원_미만_test() {

        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> {
            new Price(0);
        });
    }


}
