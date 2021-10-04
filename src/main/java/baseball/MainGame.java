package baseball;

import baseball.utils.BaseballScore;
import baseball.utils.NumbersSellect;

public class MainGame {
    private static NumbersSellect numbersSellect = new NumbersSellect();

    public void running(){
        String computerNum = numbersSellect.inputComputerNums();
        System.out.println("컴퓨터가 선택한 번호: " + computerNum);

        init();
        String userNum = gameStart();
        GameController.isGameMidwayCount(computerNum, userNum);
    }

    private static String gameStart(){
        String userNum = "";
        while(true){
            userNum = numbersSellect.inputUserNums();
            if(GameController.isCheckedUserNumber(userNum)){
                break;
            }
        }
        return userNum;
    }

    /**
     * 스트라이크 및 볼 카운트 초기화
     */
    private static void init(){
        BaseballScore baseballScore = new BaseballScore();
        baseballScore.setStrike(0);
        baseballScore.setBall(0);
    }
}