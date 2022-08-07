import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);

    public static int inputLottoPrice() {
        System.out.println("구입 금액을 입력해 주세요");
        return Integer.parseInt(scanner.nextLine());
    }

    public static Lotto inputLastWinningLottoNumbers() {
        System.out.println("지난 주 당첨 번호를 입력해 주세요");
        return parseLotto(scanner.nextLine().split(","));
    }

    private static Lotto parseLotto(String[] numbers) {
        List<LottoNumber> lottoNumbers = Arrays.stream(numbers)
                .map(number -> new LottoNumber(Integer.parseInt(number)))
                .collect(Collectors.toList());
        return new Lotto(lottoNumbers);
    }
}
