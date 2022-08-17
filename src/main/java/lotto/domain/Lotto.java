package lotto.domain;

import lotto.Reward;

import java.util.List;

public class Lotto {

    private List<LottoNumber> lotto;

    public Lotto() {
        generateLotto();
    }

    public Lotto(List<LottoNumber> lotto) {
        this.lotto = lotto;
        isValidLottoNumber();

    }

    private void isValidLottoNumber() {
        if (lotto.size() != 6) {
            throw new RuntimeException("당첨 번호가 6자리가 아닙니다.");
        }
        if (hasDupulicationNumber()) {
            throw new RuntimeException("중복된 숫자가 포함되어 있습니다.");
        }
    }

    private boolean hasDupulicationNumber() {
        return LottoNumbers.hasDupulicationNumber(lotto);
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
