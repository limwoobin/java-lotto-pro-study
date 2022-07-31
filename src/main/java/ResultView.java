import java.util.List;
import java.util.Map;

public class ResultView {
    public static void printLottoGame(List<Lotto> lottoGame) {
        for (Lotto lotto: lottoGame) {
            System.out.println(lotto.getLottoNumbers());
        }
    }



    public static void printResult(LottoResult lottoResult) {
        System.out.println("당첨 통계");
        System.out.println("-----------");

        printScore(lottoResult);

        System.out.println("총 수익률은 " + lottoResult.winningRate() + "입니다. (기준이 1이기 때문에 결과적으로 손해라는 의미임");
    }

    private static void printScore(LottoResult lottoResult) {

        Map<Reward, Long> results = lottoResult.getResult();

        results.entrySet()
                .forEach(result -> {
                    if(!Reward.MISS.equals(result.getKey())) {
                        System.out.printf("%d개 일치 (%d 원) - %d 개", Reward.scoreOfReward(result.getKey())
                                , Reward.amountOfReward(result.getKey())
                                , result.getValue());
                        System.out.println();
                    }

                });

    }
}
