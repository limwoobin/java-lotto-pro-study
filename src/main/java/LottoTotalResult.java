import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class LottoTotalResult {
    public static final int LOTTO_PRICE = 1000;

    private int totalWinningAmount = 0;
    private float returnRate;
    private Map<LottoRank, Long> totalMatchCountMap = new EnumMap<>(LottoRank.class);

    public LottoTotalResult(List<LottoResult> lottoResults) {
        calculates(lottoResults);
    }

    private void calculates(List<LottoResult> lottoResults) {
        putTotalMatchCountMap(lottoResults);
        calculateReturnRate(lottoResults.size());
    }

    private void putTotalMatchCountMap(List<LottoResult> lottoResults) {
        for (LottoRank lottoRank : LottoRank.values()) {
            long rankCount = matchCount(lottoResults, lottoRank);
            this.totalWinningAmount += lottoRank.getWinningMoney() * rankCount;
            totalMatchCountMap.put(lottoRank, rankCount);
        }
    }

    private long matchCount(List<LottoResult> lottoResults, LottoRank lottoRank) {
        return lottoResults.stream()
                .filter(lottoResult -> lottoResult.isRankEqual(lottoRank))
                .count();
    }

    // 테스트 코드에서 사용하기 위해 작성
    protected int getTotalWinningAmount() {
        return totalWinningAmount;
    }

    public void calculateReturnRate(int lottoNumberSize) {
        float inputAmount = lottoNumberSize * LOTTO_PRICE;
        this.returnRate = this.totalWinningAmount / inputAmount;
    }

    public Map<LottoRank, Long> getTotalMatchCountMap() {
        return totalMatchCountMap;
    }

    public float getReturnRate() {
        return returnRate;
    }

}
