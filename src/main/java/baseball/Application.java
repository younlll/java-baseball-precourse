package baseball;

public class Application {
    public static void main(String[] args) {
        // TODO 숫자 야구 게임 구현
        MainGame mainGame = new MainGame();

        while(true){
            mainGame.running();
            if(!GameController.isCheckedRestart()){
                return;
            }
        }
    }
}
