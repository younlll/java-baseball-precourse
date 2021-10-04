package baseball;

import baseball.utils.NumbersSellect;

public class MainGame{
    private static NumbersSellect numbersSellect = new NumbersSellect();

    public void running(){
        String computerNum = numbersSellect.inputComputerNums();

        while(true){
            GameController.init();
            String userNum = gameStart();
            if(GameController.isGameMidwayCount(computerNum, userNum)){
                return;
            }
        }
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
}