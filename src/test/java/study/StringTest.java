package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

    @Test
    @DisplayName("\"1,2\"을 , 로 split 했을 때 1과 2로 잘 분리되는지 확인")
    public void checkedSplitString(){
        String str = "1,2";
        String[] token = str.split(",");

        assertThat(token).contains("1", "2");
    }

    @Test
    @DisplayName("\"1\"을 , 로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    public void checkedSplitString2(){
        String str = "1";
        String[] token = str.split(",");

        assertThat(token).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 () 을 제거한 값 반환 확인")
    public void checkedSubstring(){
        String str = "(1,2)";
        str = str.substring(1, 4);

        assertThat(str).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자 가져오기")
    public void checkedCharAt(){
        String str = "abc";
        char ch = str.charAt(1);

        assertThat(ch).isEqualTo('b');
    }

    @Test
    @DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 예외발생")
    public void checkedCharAtOutOfIndex(){
        String str = "abc";

        assertThatThrownBy(() -> str
                .charAt(4)).isInstanceOf(StringIndexOutOfBoundsException.class);
    }
}
