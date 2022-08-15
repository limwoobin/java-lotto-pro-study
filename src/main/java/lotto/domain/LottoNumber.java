package lotto.domain;

import java.util.Objects;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private int number;

    public LottoNumber(int i) {
        this.number = i;
        isValidRangeNumber();
    }


    public Integer getNumber() {
        return number;
    }

    public void isValidRangeNumber() {

        if (number < MIN_NUMBER || number > MAX_NUMBER) {
            throw new RuntimeException("유효하지 않은 숫자가 포함되어 있습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LottoNumber lottoNo1 = (LottoNumber) o;
        return number == lottoNo1.number;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number);
    }

}
