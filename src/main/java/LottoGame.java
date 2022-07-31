import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    private final Price price;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoGame(Price price) {
        this.price = price;
        this.generateLottos();
    }

    private void generateLottos() {
        for (int i = 0; i < price.getLottoCount(); i++) {
            lottos.add(new Lotto());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void printLottoCount() {
        System.out.printf("%d개를 구매했습니다.", price.getLottoCount());
        System.out.println();
    }

    public LottoResult matchNumbers(Lotto winningLotto) {
        List<LottoScore> lottoScores = lottos.stream()
                .map(lotto -> new LottoScore(lotto, lotto.matching(winningLotto)))
                .collect(Collectors.toList());

        return new LottoResult(lottoScores, price);
    }
}
