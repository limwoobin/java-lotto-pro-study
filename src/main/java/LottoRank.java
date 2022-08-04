import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum LottoRank {

    FIRST(6, 2000000000, false),
    SECOND(5, 30000000, true),
    THIRD(5, 1500000, false),
    FOURTH(4, 50000, false),
    FIFTH(3, 5000, false),
    MISS(0, 0, false);

    private int countOfMatch;
    private int winningMoney;
    private boolean matchBonus;

    LottoRank(int countOfMatch, int winningMoney, boolean matchBonus) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
        this.matchBonus = matchBonus;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static LottoRank valueOf(int countOfMatch, boolean matchBonus) {
        if (isMatchBonusRequire(countOfMatch)) {
            return matchBonusRequireLottoRank(countOfMatch, matchBonus);
        }

        return matchBonusNotRequireLottoRank(countOfMatch);
    }

    private static LottoRank matchBonusNotRequireLottoRank(int countOfMatch) {
        return Arrays.stream(LottoRank.values())
                .filter(value -> value.countOfMatch == countOfMatch)
                .findFirst()
                .orElse(LottoRank.MISS);
    }

    private static LottoRank matchBonusRequireLottoRank(int countOfMatch, boolean matchBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(value -> value.countOfMatch == countOfMatch && value.matchBonus == matchBonus)
                .findFirst()
                .orElse(LottoRank.MISS);
    }

    private static boolean isMatchBonusRequire(int countOfMatch) {

        List<Integer> matchBonusRequireCountOfMatches = Arrays.stream(values())
                .filter(lottoRank -> lottoRank.matchBonus == true)
                .map(LottoRank::getCountOfMatch)
                .collect(Collectors.toList());

        return matchBonusRequireCountOfMatches.contains(countOfMatch);
    }

}
