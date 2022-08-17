import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

class LottoResultTest {

    @Test
    void 당첨번호랑_로또번호랑_몇개_일치하는지_체크() {
        LottoWinnerNumber lottoWinnerNumber = new LottoWinnerNumber(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)), new LottoNo(7));
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(new LottoNo(6), new LottoNo(5), new LottoNo(4), new LottoNo(45), new LottoNo(2), new LottoNo(1)));
        LottoResult lottoResult = lottoWinnerNumber.matchCount(lottoNumber);

        assertThat(lottoResult.getLottoRank()).isEqualTo(LottoRank.THIRD);
        assertThat(lottoResult.getWinningAmount()).isEqualTo(LottoRank.THIRD.getWinningMoney());

        LottoWinnerNumber lottoWinnerNumber1 = new LottoWinnerNumber(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(43), new LottoNo(44), new LottoNo(45)), new LottoNo(4));
        LottoNumber lottoNumber1 = new LottoNumber(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        LottoResult lottoResult1 = lottoWinnerNumber1.matchCount(lottoNumber1);

        assertThat(lottoResult1.getLottoRank()).isEqualTo(LottoRank.FIFTH);
    }

}
