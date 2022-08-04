import java.util.List;

public class LottoNumber {

    private static final int LOTTO_NUMBER_COUNT = 6;

    private List<LottoNo> lottoNumber;

    protected LottoNumber(List<LottoNo> lottoNumber) {
        this.lottoNumber = validateLottoNumber(lottoNumber);
    }

    public List<LottoNo> getLottoNumber() {
        return lottoNumber;
    }

    public boolean isContains(LottoNo lottoWinnerNumberEach) {

        return this.lottoNumber.stream()
                .anyMatch(lottoNo -> lottoNo.getLottoNo().equals(lottoWinnerNumberEach.getLottoNo()));
    }

    public int matchCount(LottoNumber lottoWinnerNumber) {
         return (int) this.lottoNumber.stream()
                .filter(lottoWinnerNumber::isContains)
                .count();
    }

    public List<LottoNo> validateLottoNumber(List<LottoNo> lottoNumber) {
        validateLength(lottoNumber);
        validateDuplication(lottoNumber);

        return lottoNumber;
    }

    public void validateDuplication(List<LottoNo> lottoNumber) {
        boolean duplicated = lottoNumber.stream()
                .map(LottoNo::getLottoNo)
                .distinct()
                .count() < lottoNumber.size();

        if (duplicated) {
            throw new IllegalArgumentException();
        }
    }

    public void validateLength(List<LottoNo> lottoNumber) {
        if (lottoNumber == null || lottoNumber.size() != LOTTO_NUMBER_COUNT) {
            throw new IllegalArgumentException();
        }
    }
}
