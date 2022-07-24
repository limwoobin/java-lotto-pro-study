import java.util.Scanner;

public class LottoApplication {
    public static void main(String[] args) {
        System.out.println("구입 금액을 입력해 주세요");
        Scanner scanner = new Scanner(System.in);

        Price price = new Price(Integer.parseInt(scanner.nextLine()));

        LottoGame lottoGame = new LottoGame(price);

        //입력한 돈으로 살 수 있는 금액
        lottoGame.printLottoCount();

        for (Lotto lotto: lottoGame.getLottos()) {
            System.out.println(lotto.getLottoNumbers());
        }
    }

}
