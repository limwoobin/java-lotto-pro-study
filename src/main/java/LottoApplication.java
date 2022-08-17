public class LottoApplication {

    public static void main(String[] args) {
        int inputAmount = InputView.scannerBuyAmount();
        Integer manualLottoNumberCount = InputView.scannerBuyManualCount();
        LottoNumbers lottoNumbers = new LottoNumbers(inputAmount, InputView.scannerBuyManualLottoNumber(manualLottoNumberCount));
        ResultView.printLottoNumber(lottoNumbers, manualLottoNumberCount);

        LottoWinnerNumber lottoWinnerNumber = InputView.scannerLastWeekLottoNumber();
        LottoTotalResult lottoTotalResult = lottoNumbers.calculateMatchCountAndRate(lottoWinnerNumber);
        ResultView.printMatchCount(lottoTotalResult);
    }

}
