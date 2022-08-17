public class LottoResult {

    private LottoRank lottoRank;

    public LottoResult(int matchCount, boolean matchBonusNumber) {
        this.lottoRank = LottoRank.valueOf(matchCount, matchBonusNumber);
    }

    protected LottoRank getLottoRank() {
        return lottoRank;
    }

    public int getWinningAmount() {
        return this.lottoRank.getWinningMoney();
    }

    public boolean isRankEqual(LottoRank lottoRank) {
        return this.lottoRank.equals(lottoRank);
    }
}
