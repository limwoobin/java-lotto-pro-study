import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoRankTest {

    @Test
    void 일치하는개수로_enum_가져오는_테스트로_보너스_false() {
        assertThat(LottoRank.valueOf(3, false)).isEqualTo(LottoRank.FIFTH);
        assertThat(LottoRank.valueOf(4, false)).isEqualTo(LottoRank.FOURTH);
        assertThat(LottoRank.valueOf(5, false)).isEqualTo(LottoRank.THIRD);
        assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND);
        assertThat(LottoRank.valueOf(6, false)).isEqualTo(LottoRank.FIRST);
    }

    @Test
    void 일치하는개수_enum_가져오는_테스트_보너스_TRUE() {
        assertThat(LottoRank.valueOf(5, true)).isEqualTo(LottoRank.SECOND);
    }

}
