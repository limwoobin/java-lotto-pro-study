import java.util.Arrays;

public enum Reward {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    MISS(0, 0);

    private final long score;
    private final long amount;

    Reward(long score, long amount) {
        this.score = score;
        this.amount = amount;
    }

    public static Reward valueOfReward(long score) {
        return Arrays.stream(Reward.values())
                .filter(reward -> reward.score == score)
                .findFirst()
                .orElse(MISS);

    }

    public static long amountOfReward(Reward key) {
        return key.amount;
    }

    public static long scoreOfReward(Reward key) {
        return key.score;
    }
}
