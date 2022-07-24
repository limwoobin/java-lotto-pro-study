
public class LottoApplication {
    public static void main(String[] args) {
        Price price = new Price(InputView.inputLottoPrice());

        LottoGame lottoGame = new LottoGame(price);

        //입력한 돈으로 살 수 있는 금액
        lottoGame.printLottoCount();

        ResultView.printLottoGame(lottoGame.getLottos());

        Lotto lastWinningLotto = InputView.inputLastWinningLottoNumbers();

    }

}
