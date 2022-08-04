import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoWinnerNumberTest {

    @Test
    void 로또가능값_0부터45가_아닌경우_Exception테스트() {

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoWinnerNumber(Arrays.asList(new LottoNo(0), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)), new LottoNo(7));
        });

        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoWinnerNumber(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(46)), new LottoNo(7));
        });
    }

    @Test
    void 번호가_중복인경우_Exception테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoWinnerNumber(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(46)), new LottoNo(7));
        });
    }

    @Test
    void 당첨번호랑_로또번호랑_몇개_일치하는지_체크() {
        LottoWinnerNumber lottoWinnerNumber = new LottoWinnerNumber(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)), new LottoNo(7));
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(new LottoNo(6), new LottoNo(5), new LottoNo(4), new LottoNo(45), new LottoNo(2), new LottoNo(1)));

        assertThat(lottoWinnerNumber.matchCount(lottoNumber).getLottoRank().getCountOfMatch()).isEqualTo(5);
    }
}
