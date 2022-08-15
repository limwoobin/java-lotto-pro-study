package lotto.domain;

public class Price {
    private final int LOTTO_PER_PRICE = 1000;
    private final int price;

    public Price(int price) {
        checkPrice(price);
        this.price = price;

    }

    public void checkPrice(int price) {
        if (price < LOTTO_PER_PRICE) {
            throw new RuntimeException("금액이 부족합니다.");
        }
    }


    public long getWinningRate(long winningAmount) {
        if (winningAmount < 5000) {
            return 0;
        }
        return price/ winningAmount;
    }

    public int getPrice() {
        return price;
    }
}
