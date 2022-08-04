import java.util.List;

public class LottoWinnerNumber {

    private LottoNumber lottoWinnerNumber;
    private LottoNo lottoWinnerBonusNumber;

    public LottoWinnerNumber(List<LottoNo> lottoWinnerNumbers, LottoNo lottoWinnerBonusNumber) {
        this.lottoWinnerNumber = new LottoNumber(lottoWinnerNumbers);
        this.lottoWinnerBonusNumber = lottoWinnerBonusNumber;
        validations();
    }

    private void validations() {
        duplicationValidation();
    }

    public LottoResult matchCount(LottoNumber lottoNumber) {
        return new LottoResult(lottoNumber.matchCount(this.lottoWinnerNumber), lottoNumber.isContains(this.lottoWinnerBonusNumber));
    }

    public void duplicationValidation() {
        if (this.lottoWinnerNumber.isContains(this.lottoWinnerBonusNumber)) {
            throw new IllegalArgumentException();
        }
    }


    @Override
    public String toString() {
        return String.valueOf(lottoWinnerNumber);
    }
}
