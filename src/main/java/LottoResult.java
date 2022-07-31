import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class LottoResult {

    private final List<LottoScore> lottoScores;
    private final Price price;
    private Map<Reward, Long> countOfScore;

    public LottoResult(List<LottoScore> lottoScores, Price price) {
        this.lottoScores = lottoScores;
        this.price = price;
        this.result();
    }

    private void result() {
        countOfScore = lottoScores.stream()
               // .filter(lottoScore -> lottoScore.isNotZeroReward() )
                .collect(Collectors.groupingBy(LottoScore::getReward, TreeMap::new,Collectors.counting()));
    }

    public long winningRate() {

        long winningAmount = countOfScore.entrySet().stream()
                .mapToLong(lotto -> Reward.amountOfReward(lotto.getKey()) * lotto.getValue() ).sum() ;

        return price.getWinningRate(winningAmount);
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
}
