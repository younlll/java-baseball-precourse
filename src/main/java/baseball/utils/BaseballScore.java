package baseball.utils;

import baseball.commons.Constant;

public class BaseballScore {
    private Integer strike;
    private Integer ball;

    public void setStrike(Integer strike){
        this.strike = strike;
    }
    public void setBall(Integer ball){
        this.ball = ball;
    }
    public Integer getStrike() {
        return strike;
    }
    public Integer getBall(){
        return ball;
    }

    /**
     * 낫싱 여부 판단(스트라이크 = 0 AND 볼 = 0)
     * @return 낫싱 여부 반환
     */
    public Boolean isNothing(){
        if(getStrike() == 0 && getBall() == 0){
            System.out.println(Constant.BALL_COUNT_NOTHING);
            return true;
        }
        return false;
    }
}
