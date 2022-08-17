import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumbersTest {

    @Test
    public void 로또_구매_테스트() {
        List<LottoNumber> manualLottoNumbers =
            Arrays.asList(new LottoNumber(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6))),
                new LottoNumber(Arrays.asList(new LottoNo(7), new LottoNo(8), new LottoNo(9), new LottoNo(10), new LottoNo(11), new LottoNo(12))),
                new LottoNumber(Arrays.asList(new LottoNo(13), new LottoNo(14), new LottoNo(15), new LottoNo(16), new LottoNo(17), new LottoNo(18)))
            );

        LottoNumbers lottoNumbers = new LottoNumbers(14000, manualLottoNumbers);
        assertThat(lottoNumbers.getLottoNumbers().size()).isEqualTo(14);
    }

    @Test
    public void 로또_1000원미만_입력시_Exception_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumbers(999, null);
        });
    }


}
