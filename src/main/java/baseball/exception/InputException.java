package baseball.exception;

public class InputException extends RuntimeException {
    public InputException(String msg){
        super(msg);
    }

    @Override
    public String getMessage(){
        return String.format("%s %s", "[ERROR]", super.getMessage());
    }
}
