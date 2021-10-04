package baseball;

import baseball.commons.Constant;
import baseball.exception.InputException;
import baseball.utils.BaseballScore;
import nextstep.utils.Console;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameController{

    private static BaseballScore baseballScore = new BaseballScore();

    /**
     * 스트라이크 및 볼 카운트 초기화
     */
    public static void init(){
        baseballScore.setStrike(0);
        baseballScore.setBall(0);
    }

    /**
     * 유저가 입력한 숫자에 대한 유효성 검사
     * @param userNum
     * @return
     */
    public static Boolean isCheckedUserNumber(String userNum){
        try{
            isCheckedRange(userNum);
            isCheckedLength(userNum);
            isCheckedDuplication(userNum);
        }catch (InputException e){
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    /**
     * 게임 중간 집계
     * @param computerNum
     * @param userNum
     * @return 게임종료 여부 반환(true = 종료O, false = 종료X)
     */
    public static Boolean isGameMidwayCount(String computerNum, String userNum){
        isCheckedStrikeBall(computerNum, userNum);
        if(!baseballScore.isNothing()){
            printStrikeBall();
        }

        return isCheckedFinish();
    }

    /**
     * 스트라이크 3개로 유저가 컴퓨터의 숫자를 맞췄는지 확인
     * @return 게임종료 여부 반환(true = 종료O, false = 종료X)
     */
    private static Boolean isCheckedFinish(){
        if(baseballScore.getStrike() == Constant.NUMBER_MAX_LENGTH){
            System.out.println(Constant.GAME_FINISH_MSG);
            return true;
        }
        return false;
    }

    /**
     * 스트라이크와 볼 카운트 결과 출력
     */
    private static void printStrikeBall(){
        if(baseballScore.getStrike() > 0){
            System.out.print(baseballScore.getStrike() + "스트라이크 ");
        }
        if(baseballScore.getBall() > 0){
            System.out.print(baseballScore.getBall() + "볼");
        }
        System.out.println();
    }

    /**
     * 유저의 입력한 값을 컴퓨터 숫자와 비교하여 스트라이크 및 볼 카운트
     * @param computerNum
     * @param userNum
     */
    private static void isCheckedStrikeBall(String computerNum, String userNum){
        for(int ii = 0; ii < Constant.NUMBER_MAX_LENGTH; ii++){
            if(computerNum.charAt(ii) == userNum.charAt(ii)){
                baseballScore.setStrike(baseballScore.getStrike() + 1);
            }
            if(computerNum.charAt(ii) != userNum.charAt(ii)
                    && computerNum.indexOf(userNum.charAt(ii)) != -1){
                baseballScore.setBall(baseballScore.getBall() + 1);
            }
        }
    }

    /**
     * 입력값 범위에 대한 유효성 검사
     * 유저의 입력값 각 숫자 범위가 1~9사이 인지 확인
     * @param userNum
     */
    private static void isCheckedRange(String userNum){
        if(!userNum.matches(Constant.NUMBER_RANGE_CHECKED)){
            throw new InputException(Constant.RANGE_ERR_MSG);
        }
    }

    /**
     * 입력값 길이에 대한 유효성 검사
     * 유저의 입력값의 길이가 3의 길이를 갖는지 확인
     * @param userNum
     */
    private static void isCheckedLength(String userNum){
        if(userNum.length() != Constant.NUMBER_MAX_LENGTH){
            throw new InputException(Constant.LENGTH_ERR_MSG);
        }
    }

    /**
     * 입력값 중복에 대한 유효성 검사
     * 유저의 입력값 중에서 중복된 숫자가 포함되었는지 확인
     * @param userNum
     */
    private static void isCheckedDuplication(String userNum){
        Set<String> unique = new HashSet<>(Arrays.asList(userNum.split("")));
        if(unique.size() != Constant.NUMBER_MAX_LENGTH){
            throw new InputException(Constant.DUPLICATION_ERR_MSG);
        }
    }

    public static Boolean isCheckedRestart(){
        System.out.println(Constant.GAME_RESTART_MSG);
        String input = Console.readLine();
        if(Integer.parseInt(input) == Constant.GAME_RESTART_Y){

            return true;
        }
        return false;
    }
}
