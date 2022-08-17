package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LottoGame {

    private final Price price;
    private final int LOTTO_PER_PRICE = 1000;
    private int lottoCount;
    private List<Lotto> lottos = new ArrayList<>();

    public LottoGame(Price price) {
        this.price = price;
        this.lottoCount = this.price.getPrice() / LOTTO_PER_PRICE;
        this.generateLottos();
    }

    private void generateLottos() {
        for (int i = 0; i < this.lottoCount; i++) {
            lottos.add(new Lotto());
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public void printLottoCount() {
        System.out.printf("%d개를 구매했습니다.", this.lottoCount);
        System.out.println();
    }

    public LottoResult matchNumbers(Lotto winningLotto) {
        List<LottoScore> lottoScores = lottos.stream()
                .map(lotto -> new LottoScore(lotto, lotto.matching(winningLotto)))
                .collect(Collectors.toList());

        return new LottoResult(lottoScores, price);
    }

    public int getLottoCount() {
        return lottoCount;
    }
}
