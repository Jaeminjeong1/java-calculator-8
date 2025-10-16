package calculator.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {

    Delimiter   delimiter = new Delimiter();
    Calculator calculator = new Calculator();

    //정수끼리 계산
    @Test
    @DisplayName("정수끼리의 계산결과는 정수")
    void calculator_integer(){
        String input = "1,2,3";

        List<String> list = delimiter.splitString(input);
        Object result = calculator.calculateNumber(list);

        assertThat(result).isEqualTo(6L);
    }

    //소수포함 계산
    @Test
    @DisplayName("소수포함 계산결과는 소수")
    void calculator_double(){
        String input = "1.1,2,3";

        List<String> list = delimiter.splitString(input);
        Object result = calculator.calculateNumber(list);

        assertThat(result).isEqualTo(6.1);
    }


    //0이 포함된 계산
    @Test
    @DisplayName("0이 포함된 계산의 경우, IllegalException 발생하고 프로그램 종료")
    void calculator_integer_illegal() {
        assertThrows(IllegalArgumentException.class, () -> {
            String input = "0,1,2";

            List<String> list = delimiter.splitString(input);
            calculator.calculateNumber(list);
        });
    }

    @Test
    @DisplayName("음수가 포함된 계산의 경우, IllegalException 발생하고 프로그램 종료")
    void calculator_negative_illegal(){
        assertThrows(IllegalArgumentException.class, () -> {
            String input = "-1,2,3";

            List<String> list = delimiter.splitString(input);
            calculator.calculateNumber(list);
        });
    }


}
