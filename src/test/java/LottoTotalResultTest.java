import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoTotalResultTest {

    private LottoWinnerNumber lottoWinnerNumber;
    private LottoNumbers lottoNumbers = new LottoNumbers();

    @BeforeEach
    void setUp() {
        this.lottoWinnerNumber = new LottoWinnerNumber(Arrays.asList(new LottoNo(1),new LottoNo(2),new LottoNo(3),new LottoNo(4),new LottoNo(5),new LottoNo(6)),new LottoNo(7));

        List<LottoNumber> lottoNumbers = new ArrayList<>();
        lottoNumbers.add(new LottoNumber(Arrays.asList(new LottoNo(8), new LottoNo(21), new LottoNo(23), new LottoNo(41), new LottoNo(42), new LottoNo(43))));
        lottoNumbers.add(new LottoNumber(Arrays.asList(new LottoNo(3), new LottoNo(5), new LottoNo(11), new LottoNo(16), new LottoNo(32), new LottoNo(38))));
        lottoNumbers.add(new LottoNumber(Arrays.asList(new LottoNo(7), new LottoNo(11), new LottoNo(16), new LottoNo(35), new LottoNo(36), new LottoNo(44))));
        lottoNumbers.add(new LottoNumber(Arrays.asList(new LottoNo(1), new LottoNo(8), new LottoNo(11), new LottoNo(31), new LottoNo(41), new LottoNo(42))));
        lottoNumbers.add(new LottoNumber(Arrays.asList(new LottoNo(13), new LottoNo(14), new LottoNo(16), new LottoNo(38), new LottoNo(42), new LottoNo(45))));
        lottoNumbers.add(new LottoNumber(Arrays.asList(new LottoNo(7), new LottoNo(11), new LottoNo(30), new LottoNo(40), new LottoNo(42), new LottoNo(43))));
        lottoNumbers.add(new LottoNumber(Arrays.asList(new LottoNo(2), new LottoNo(13), new LottoNo(22), new LottoNo(32), new LottoNo(38), new LottoNo(45))));
        lottoNumbers.add(new LottoNumber(Arrays.asList(new LottoNo(23), new LottoNo(25), new LottoNo(33), new LottoNo(36), new LottoNo(39), new LottoNo(41))));
        lottoNumbers.add(new LottoNumber(Arrays.asList(new LottoNo(1), new LottoNo(3), new LottoNo(5), new LottoNo(14), new LottoNo(22), new LottoNo(45))));
        lottoNumbers.add(new LottoNumber(Arrays.asList(new LottoNo(5), new LottoNo(9), new LottoNo(38), new LottoNo(41), new LottoNo(43), new LottoNo(44))));
        lottoNumbers.add(new LottoNumber(Arrays.asList(new LottoNo(2), new LottoNo(8), new LottoNo(9), new LottoNo(18), new LottoNo(19), new LottoNo(21))));
        lottoNumbers.add(new LottoNumber(Arrays.asList(new LottoNo(13), new LottoNo(14), new LottoNo(18), new LottoNo(21), new LottoNo(23), new LottoNo(35))));
        lottoNumbers.add(new LottoNumber(Arrays.asList(new LottoNo(17), new LottoNo(21), new LottoNo(29), new LottoNo(37), new LottoNo(42), new LottoNo(45))));
        lottoNumbers.add(new LottoNumber(Arrays.asList(new LottoNo(3), new LottoNo(8), new LottoNo(27), new LottoNo(30), new LottoNo(35), new LottoNo(44))));
        this.lottoNumbers = new LottoNumbers(lottoNumbers);
    }

    @Test
    void 수익률_계산_테스트() {
        int inputAmount = this.lottoNumbers.getLottoNumbers().size() * LottoTotalResult.LOTTO_PRICE;

        LottoTotalResult lottoTotalResult = lottoNumbers.calculateMatchCountAndRate(this.lottoWinnerNumber);

        float returnRate = (float) lottoTotalResult.getTotalWinningAmount() / inputAmount;

        assertThat(lottoTotalResult.getReturnRate()).isEqualTo(returnRate);
    }

    @Test
    void 일치하는_개수_테스트() {
        LottoTotalResult lottoTotalResult = lottoNumbers.calculateMatchCountAndRate(this.lottoWinnerNumber);
        assertThat(lottoTotalResult.getTotalMatchCountMap().get(LottoRank.FIFTH)).isEqualTo(1);
        assertThat(lottoTotalResult.getTotalMatchCountMap().get(LottoRank.FOURTH)).isEqualTo(0);
        assertThat(lottoTotalResult.getTotalMatchCountMap().get(LottoRank.THIRD)).isEqualTo(0);
        assertThat(lottoTotalResult.getTotalMatchCountMap().get(LottoRank.SECOND)).isEqualTo(0);
        assertThat(lottoTotalResult.getTotalMatchCountMap().get(LottoRank.FIRST)).isEqualTo(0);
    }
}
