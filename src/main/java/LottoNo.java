public class LottoNo {

    private static final int LOTTO_START_NUMBER = 1;
    private static final int LOTTO_LAST_NUMBER = 45;

    private Integer lottoNo;

    public LottoNo(Integer inputLottoNo) {
        rangeValidation(inputLottoNo);
        this.lottoNo = inputLottoNo;
    }

    public void rangeValidation(Integer inputLottoNo) {
        if (inputLottoNo < LOTTO_START_NUMBER || inputLottoNo > LOTTO_LAST_NUMBER) {
            throw new IllegalArgumentException();
        }
    }

    public Integer getLottoNo() {
        return lottoNo;
    }

    @Override
    public String toString() {
        return lottoNo.toString();
    }
}
