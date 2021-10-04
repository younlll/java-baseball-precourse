package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp(){
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }
    
    // Test Case 구현
    @Test
    @DisplayName("size() 메소드를 활용해 Set의 크기를 확인")
    public void checkedSetSize(){
        int size = numbers.size();

        assertThat(size).isEqualTo(3);
    }

    @ParameterizedTest
    @DisplayName("\"1,2,3\"이 포함되어 있는지 확인")
    @ValueSource(ints = {1, 2, 3})
    public void checkedContains(int num){
        assertThat(numbers.contains(num)).isTrue();
    }

    @ParameterizedTest
    @DisplayName("\"1,2,3\"이 포함되어 있는지 확인")
    @CsvSource(value = {"1,true", "2,true", "3,true", "4,false", "5,false"})
    public void checkedContains2(int num, boolean containResult){
        assertThat(numbers.contains(num)).isEqualTo(containResult);
    }
}
