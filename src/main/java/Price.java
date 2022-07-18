public class Price {
    private final int price;
    private final int LOTTO_PRICE = 1000;
    private int lottoCount;

    public Price(int price) {

        checkPrice(price);
        this.price = price;
        this.lottoCount = price / LOTTO_PRICE;
    }

    public void checkPrice(int price) {
        if (price < 1000) {
            throw new RuntimeException("금액이 부족합니다.");
        }
    }


    public int getLottoCount() {
        return this.lottoCount;
    }
}
