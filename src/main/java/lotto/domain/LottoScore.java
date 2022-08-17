package lotto.domain;

import lotto.Reward;

public class LottoScore {
    private final Lotto lotto;
    private final Reward reward;

    public LottoScore(Lotto lotto, Reward reward) {
        this.lotto = lotto;
        this.reward = reward;
    }


    public Reward getReward() {
        return reward;
    }
}
