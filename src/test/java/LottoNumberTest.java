import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class LottoNumberTest {

    @Test
    public void NUll로_생성_테스트() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumber(null);
        });
    }


    @Test
    public void 랜덤_6자리_생성_테스트() {
        LottoNumber lottoNumber = LottoNumberGenerator.createLottoNumber();
        assertThat(lottoNumber.getLottoNumber().size()).isEqualTo(6);
    }

    @ParameterizedTest
    @MethodSource("generateData")
    void 번호가_6자리_Exception테스트(List<LottoNo> numbers) {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            new LottoNumber(numbers);
        });
    }

    static Stream<Arguments> generateData() {
        return Stream.of(
                Arguments.of(Arrays.asList(1)),
                Arguments.of(Arrays.asList(1, 2)),
                Arguments.of(Arrays.asList(1, 2, 3)),
                Arguments.of(Arrays.asList(1, 2, 3, 4)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5)),
                Arguments.of(Arrays.asList(1, 2, 3, 4, 5, 6, 7))
                );
    }

    @Test
    void 당첨번호랑_로또번호랑_몇개_일치하는지_체크() {
        LottoNumber lottoWinnerNumber = new LottoNumber(Arrays.asList(new LottoNo(1), new LottoNo(2), new LottoNo(3), new LottoNo(4), new LottoNo(5), new LottoNo(6)));
        LottoNumber lottoNumber = new LottoNumber(Arrays.asList(new LottoNo(6), new LottoNo(5), new LottoNo(4), new LottoNo(45), new LottoNo(2), new LottoNo(1)));

        assertThat(lottoNumber.matchCount(lottoWinnerNumber)).isEqualTo(5);
    }


}
