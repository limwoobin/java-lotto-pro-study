package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoNumber;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    private static final String PRICE_INPUT_COMMENTS = "구입 금액을 입력해 주세요";
    private static final String WINNING_GAME_NUMBER_INPUT_COMMENTS = "지난 주 당첨 번호를 입력해 주세요";
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputLottoPrice() {
        System.out.println(PRICE_INPUT_COMMENTS);
        return Integer.parseInt(scanner.nextLine());
    }

    public static Lotto inputLastWinningLottoNumbers() {
        System.out.println(WINNING_GAME_NUMBER_INPUT_COMMENTS);
        return parseLotto(scanner.nextLine().split(","));
    }

    public static Lotto parseLotto(String[] numbers) {
        List<LottoNumber> lottoNumbers;
        try {
            lottoNumbers = Arrays.stream(numbers)
                    .map(number -> new LottoNumber(parseInt(number)))
                    .collect(Collectors.toList());
        } catch (NumberFormatException a) {
            throw new RuntimeException("숫자만 입력할 수 있습니다. ");
        }

        return new Lotto(lottoNumbers);
    }

    private static int parseInt(String number) {
        return Integer.parseInt(number);
    }
}
