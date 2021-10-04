package baseball.utils;

import baseball.commons.Constant;
import nextstep.utils.Console;
import nextstep.utils.Randoms;

public class NumbersSellect {

    public NumbersSellect(){}

    /**
     * 컴퓨터의 입력값 생성
     * @return 컴퓨터 랜덤 입력값 반환
     */
    public String inputComputerNums(){
        String input = "";
        while(input.length() < Constant.NUMBER_MAX_LENGTH){
            Integer num = Randoms.pickNumberInRange(Constant.NUMBER_RANGE_MIN, Constant.NUMBER_RANGE_MAX);
            if(!input.contains(num.toString())){
                input += num.toString();
            }
        }

        return input;
    }

    public String inputUserNums(){
        System.out.println(Constant.GAME_PROMPT);
        return Console.readLine();
    }
}
