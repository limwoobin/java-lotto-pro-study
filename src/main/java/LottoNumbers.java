import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LottoNumbers {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int LOTTO_NUMBER_COUNT = 6;
    private static final List<LottoNumber> LOTTO_LOTTO_NUMBERS = new ArrayList<>();

    static {
        for (int i = MIN_NUMBER; i <= MAX_NUMBER; i++) {
            LOTTO_LOTTO_NUMBERS.add(new LottoNumber(i));
        }
    }

    public static List<LottoNumber> autoGenerateLottoNumbers() {
        Collections.shuffle(LOTTO_LOTTO_NUMBERS);
        List<LottoNumber> lotto = new ArrayList<>();

        for (int i = 0; i < LOTTO_NUMBER_COUNT; i++) {
            lotto.add(LOTTO_LOTTO_NUMBERS.get(i));
        }

        return lotto.stream()
                .sorted(Comparator.comparing(LottoNumber::getNumber))
                .collect(Collectors.toList());
    }

    public List<LottoNumber> getLottoNumbers() {
        return LOTTO_LOTTO_NUMBERS;
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
