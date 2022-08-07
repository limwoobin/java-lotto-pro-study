import java.util.List;

public class Lotto {

    private List<LottoNumber> lotto;

    public Lotto() {
        generateLotto();
    }

    public Lotto(List<LottoNumber> lotto) {
        isValidLottoNumberSize(lotto);
        this.lotto = lotto;
    }

    private void isValidLottoNumberSize(List<LottoNumber> lotto) {
        if (this.lotto.size() != 6) {
            throw new RuntimeException("당첨 번호가 6자리가 아닙니다.");
        }
    }

    private void generateLotto() {
        this.lotto = LottoNumbers.autoGenerateLottoNumbers();
    }

    public List<LottoNumber> getLotto() {
        return lotto;
    }

    public Reward matching(Lotto winningLotto) {
        long matchedCount = lotto.stream()
                .filter(number -> winningLotto.hasNumber(number))
                .count();
        return Reward.valueOfReward(matchedCount);
    }

    private boolean hasNumber(LottoNumber number) {
        return lotto.stream()
                .anyMatch(winningNumber -> winningNumber.equals(number));
    }
}
