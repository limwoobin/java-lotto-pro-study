import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;

public class LottoNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<Integer> LOTTO_NUMBERS = new ArrayList<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            LOTTO_NUMBERS.add(i);
        }
    }

    public static List<Integer> autoGenerateLottoNumbers() {
        Collections.shuffle(LOTTO_NUMBERS);
        List<Integer> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            lottoNumbers.add(LOTTO_NUMBERS.get(i));
        }
        Collections.sort(lottoNumbers);
        return lottoNumbers;
    }

    public List<Integer> getLottoNumbers() {
        return LOTTO_NUMBERS;
    }

    public void checkDupulicationNumber(List<Integer> numbers) {
        boolean isDupulication =  numbers.stream()
                .distinct()
                .count() < LOTTO_NUMBER_COUNT;

        if (isDupulication) {
            throw new RuntimeException("중복된 숫자가 존재함");
        }
    }
}
