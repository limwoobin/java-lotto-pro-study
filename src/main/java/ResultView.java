import java.util.List;

public class ResultView {
    public static void printLottoGame(List<Lotto> lottoGame) {
        for (Lotto lotto: lottoGame) {
            System.out.println(lotto.getLottoNumbers());
        }
    }
}
