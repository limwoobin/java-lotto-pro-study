import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoTest {
    @Test
    void 로또_1개_test() {
        Lotto 로또 = new Lotto();
        List<Integer> 로또번호 = 로또.getLottoNumbers();

        assertThat(로또번호.size()).isEqualTo(6);
    }
}
