import java.util.List;

public class Lotto {

    private List<Integer> lottoNumbers;

    public Lotto() {
        generateLotto();
    }

    public Lotto(List<Integer> lottoNumbers) {
        isValidLottoNumberSize(lottoNumbers);
        isValidRangeNumber(lottoNumbers);
        this.lottoNumbers = lottoNumbers;
    }

    private void isValidRangeNumber(List<Integer> lottoNumbers) {
        LottoNumber.isValidRangeNumber(lottoNumbers);
    }

    private void isValidLottoNumberSize(List<Integer> lottoNumbers) {
        if (lottoNumbers.size() != 6) {
            throw new RuntimeException("당첨 번호가 6자리가 아닙니다.");
        }
    }

    private void generateLotto() {
        this.lottoNumbers = LottoNumber.autoGenerateLottoNumbers();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public Reward matching(Lotto winningLotto) {
        long matchedCount = lottoNumbers.stream()
                .filter(number -> winningLotto.hasNumber(number))
                .count();
        return Reward.valueOfReward(matchedCount);
    }

    private boolean hasNumber(Integer number) {
        return lottoNumbers.stream()
                .anyMatch(winningNumber -> winningNumber.equals(number));
    }
}
