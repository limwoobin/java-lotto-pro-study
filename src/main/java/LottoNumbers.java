import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class LottoNumbers {

    public static final int LOTTO_PRICE = 1000;

    private List<LottoNumber> lottoNumbers = new ArrayList<>();

    // 테스트 코드 작성하기 위해서 생성
    protected LottoNumbers() {
    }

    // 테스트 코드 작성하기 위해서 생성
    protected LottoNumbers(List<LottoNumber> lottoNumbers) {
        this.lottoNumbers = lottoNumbers;
    }

    public LottoNumbers(int inputAmount, List<LottoNumber> manualLottoNumbers) {
        validateInputAmount(inputAmount);
        createLottoNumbers(inputAmount, manualLottoNumbers);
    }

    private void validateInputAmount(int inputAmount) {
        if (inputAmount < LOTTO_PRICE) {
            throw new IllegalArgumentException();
        }
    }

    public void createLottoNumbers(int inputCash, List<LottoNumber> manualLottoNumbers) {
        int autoLottoCount = inputCash / LOTTO_PRICE - manualLottoNumbers.size();
        addAutoLottoNumber(autoLottoCount);
        this.lottoNumbers.addAll(manualLottoNumbers);
    }

    private void addAutoLottoNumber(int autoLottoCount) {
        for (int i = 0; i < autoLottoCount; i++) {
            this.lottoNumbers.add(LottoNumberGenerator.createLottoNumber());
        }
    }

    public LottoTotalResult calculateMatchCountAndRate(LottoWinnerNumber lottoWinnerNumber) {

        List<LottoResult> lottoResults = this.lottoNumbers.stream()
                .map(lottoWinnerNumber::matchCount)
                .collect(Collectors.toList());

        return new LottoTotalResult(lottoResults);
    }

    public List<LottoNumber> getLottoNumbers() {
        return this.lottoNumbers;
    }

}
