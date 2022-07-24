import java.util.List;

public class Lotto {

    private List<Integer> lottoNumbers;

    public Lotto() {
        generateLotto();
    }

    private void generateLotto() {
        this.lottoNumbers = LottoNumber.autoGenerateLottoNumbers();
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }
}
