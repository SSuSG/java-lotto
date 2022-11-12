package lottoService;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import common.Constant;
import common.LottoGameMessage;
import domain.Lotto;
import domain.LottoRank;
import domain.LottoReward;
import domain.Player;

import java.util.*;

public class LottoService {

    LottoGameMessage lottoGameMessage = new LottoGameMessage();

    public void printPlayerLottoNumberAndCreateLottoNumber(Player player){
        lottoGameMessage.printPurchaseCountMessage(player.getLottoCount());
        createPlayerRandomLottoPickNumbers(player);
        lottoGameMessage.printPlayerRandomLottoPickNumbers(player);
    }

    public void isNumber(String number){
        try {
            Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(Constant.NOT_NUMBER_EXCEPTION);
        }
    }

    public void createPlayerRandomLottoPickNumbers(Player player){
        for (int lottoNum = 0; lottoNum < player.getLottoCount(); lottoNum++) {
            Lotto playerLotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            Collections.sort(playerLotto.getNumbers());
            player.getPlayerLottoPickNumbers().add(playerLotto);
        }
    }
}
