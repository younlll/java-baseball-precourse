package baseball;

import baseball.commons.Constant;
import baseball.exception.InputException;
import baseball.utils.BaseballScore;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GameController {

    private static BaseballScore baseballScore = new BaseballScore();

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
}
