import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public static void isValidRangeNumber(List<Integer> lottoNumbers) {
        long notValidNumberCount = lottoNumbers.stream()
                .filter(number -> number < MIN_NUMBER || number > MAX_NUMBER)
                .count();

        if (notValidNumberCount > 0) {
            throw new RuntimeException("유효하지 않은 숫자가 포함되어 있습니다.");
        }
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
