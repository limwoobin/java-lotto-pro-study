package lotto;

import lotto.domain.Lotto;
import lotto.domain.LottoGame;
import lotto.domain.LottoResult;
import lotto.domain.Price;
import lotto.view.InputView;
import lotto.view.ResultView;

public class LottoApplication {
    public static void main(String[] args) {
        Price price = new Price(InputView.inputLottoPrice());

        LottoGame lottoGame = new LottoGame(price);

        lottoGame.printLottoCount();

        ResultView.printLottoGame(lottoGame.getLottos());

        Lotto winningLottoNumbers = InputView.inputLastWinningLottoNumbers();
        ResultView.printWinningLotto(winningLottoNumbers);

        LottoResult result = lottoGame.matchNumbers(winningLottoNumbers);
        long winningRate = price.getWinningRate(result.getWinningAmount());
        ResultView.printResult(result, winningRate);
    }

}
