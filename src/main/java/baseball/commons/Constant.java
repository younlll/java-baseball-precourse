package baseball.commons;

public class Constant {
    public static Integer NUMBER_MAX_LENGTH = 3;
    public static Integer NUMBER_RANGE_MIN = 1;
    public static Integer NUMBER_RANGE_MAX = 9;

    public static String GAME_PROMPT = "숫자를 입력해주세요: ";
    public static String RANGE_ERR_MSG = "입력값은 1~9사이의 자연수만 가능합니다.";
    public static String LENGTH_ERR_MSG = "입력값은 총 3자리가 입력되어야 합니다.";
    public static String DUPLICATION_ERR_MSG = "중복된 숫자를 입력할 수 없습니다.";
    public static String GAME_FINISH_MSG = "3개의 숫자를 모두 맞히셨습니다! 게임 끝";
    public static String BALL_COUNT_NOTHING = "낫싱";
    public static String NUMBER_RANGE_CHECKED = "(^[1-9]*$)";
}