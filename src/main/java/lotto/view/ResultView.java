package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.Reward;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultView {
    private static final String SCORE_INFO_COMMENTS = "당첨 통계";
    private static final String DIVISION_LINE = "-----------";
    public static void printLottoGame(List<Lotto> lottoGame) {
        for (Lotto lotto: lottoGame) {
            printLotto(lotto);

        }
    }

    private static void printLotto(Lotto lotto) {
        List<Integer> parseIntegerLotto = lotto.getLotto().stream()
                .map(lottoNumber -> lottoNumber.getNumber())
                .collect(Collectors.toList());
        System.out.println(parseIntegerLotto);
    }


    public static void printResult(LottoResult lottoResult, long winningRate) {
        System.out.println(SCORE_INFO_COMMENTS);
        System.out.println(DIVISION_LINE);

        printScore(lottoResult);

        System.out.println("총 수익률은 " + winningRate + "입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임");
    }

    private static void printScore(LottoResult lottoResult) {

        Map<Reward, Long> results = lottoResult.getResult();

        results.entrySet()
                .forEach(result -> {
                    printScore(result);

                });

    }

    private static void printScore(Map.Entry<Reward, Long> result) {
        if(!Reward.MISS.equals(result.getKey())) {
            System.out.printf("%d개 일치 (%d 원) - %d 개", Reward.scoreOfReward(result.getKey())
                    , Reward.amountOfReward(result.getKey())
                    , result.getValue());
            System.out.println();
        }
    }

    public static void printWinningLotto(Lotto winningLottoNumbers) {
        printLotto(winningLottoNumbers);
    }
}
