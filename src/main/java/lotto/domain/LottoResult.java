package lotto.domain;

import lotto.Reward;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LottoResult {

    private final List<LottoScore> lottoScores;
    private long winningAmount;
    private Map<Reward, Long> countOfScore;

    public LottoResult(List<LottoScore> lottoScores, Price price) {
        this.lottoScores = lottoScores;
        this.result();
    }

    private void result() {
        countOfScore = lottoScores.stream()
                .collect(Collectors.groupingBy(LottoScore::getReward, TreeMap::new,Collectors.counting()));

        winningAmount = countOfScore.entrySet().stream()
                .mapToLong(lotto -> Reward.amountOfReward(lotto.getKey()) * lotto.getValue() ).sum() ;
    }

    public long getCount(Reward reward) {
        if(countOfScore.get(reward) == null) {
            return 0;
        }
        return countOfScore.get(reward);
    }

    public Map<Reward, Long> getResult() {

        Map<Reward, Long> results = new EnumMap<>(Reward.class);

        for (Reward reward : Reward.values()) {
            results.put(reward, getCount(reward));
        }
        return results;
    }

    public long getWinningAmount() {
        return this.winningAmount;
    }
}
