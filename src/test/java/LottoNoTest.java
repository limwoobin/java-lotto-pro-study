import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNoTest {

    @Test
    void 로또가능값_0부터45가_아닌경우_Exception테스트() {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNo(0);
        });

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumber(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(46)));
        });
    }

    @Test
    void 번호가_중복인경우_Exception테스트() {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumber(Arrays.asList(new LottoNo(1), new LottoNo(1), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        });

    }


}
