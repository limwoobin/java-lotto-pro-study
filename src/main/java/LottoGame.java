import java.util.ArrayList;
import java.util.List;

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
}
