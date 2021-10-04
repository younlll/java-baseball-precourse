package baseball;

import baseball.utils.NumbersSellect;

public class MainGame{
    private static NumbersSellect numbersSellect = new NumbersSellect();

    public void running(){
        String computerNum = numbersSellect.inputComputerNums();
        System.out.println("컴퓨터가 선택한 번호: " + computerNum);

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