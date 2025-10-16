package calculator;

import calculator.utils.Delimiter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DelimiterTest {

    private Delimiter delimiter = new Delimiter();

    //
    @Test
    @DisplayName("1,2:3이 들어올 경우, 3개로 나눠져야한다.")
    void split_delimiter() {
        String input = "1,2:3";

        List<String> split = delimiter.splitString(input);

        List<String> testNumber = List.of("1", "2", "3");
        assertThat(split).containsAll(testNumber);
    }

    @Test
    @DisplayName("커스텀구분자가 있는 경우, 커스텀 구분자를 인식한다.")
    void custom_delimiter() {
        String input = "//;\\n1;2,3";

        String customDelimiter = delimiter.findCustomDelimiter(input);
        assertThat(customDelimiter).isEqualTo(";");
    }

    @Test
    @DisplayName("커스텀구분자와 기본구분자(, :)가 동시에 사용가능하다.")
    void split_with_custom_delimiter() {
        String input = "//;\\n1;2,3";

        delimiter.findCustomDelimiter(input);
        List<String> split = delimiter.splitString(input);

        List<String> testNumber = List.of("1", "2", "3");
        assertThat(split).containsAll(testNumber);
    }

    @Test
    @DisplayName("커스텀구분자가 한자리가 아닌경우 테스트")
    void split_with_long_custom_delimiter() {
        String input = "//;;;\\n1;;;2,3";

        delimiter.findCustomDelimiter(input);
        List<String> split = delimiter.splitString(input);

        List<String> testNumber = List.of("1", "2", "3");
        assertThat(split).containsAll(testNumber);
    }


    // 커스텀 구분자 입력 구조 다를 경우
    @Test
    @DisplayName("//;n1;2;3 같이 커스텀 구분자 입력구조 다를 경우, IllegalException 이 발생하여 프로그램 종료")
    void split_with_illegal_delimiter() {
        assertThrows(IllegalArgumentException.class, () -> {
            String input = "//;n1;2;3";
            delimiter.findCustomDelimiter(input);
        });
    }

    // 커스텀 구분자로 "."이 입력 됐을 경우
    @Test
    @DisplayName("커스텀 구분자로 .이 입력 됐을 경우, IllegalException 이 발생하여 프로그램 종료")
    void split_with_illegal_custom_delimiter() {
        assertThrows(IllegalArgumentException.class, () -> {
            String input = "//.\\n1.2.3";
            delimiter.findCustomDelimiter(input);
        });
    }

    // 커스텀 구분자로 숫자들어올 경우.
    @Test
    @DisplayName("커스텀 구분자로 숫자들어올 경우, IllegalExceptions 이 발생하여 프로그램 종료")
    void split_with_illegal_custom_delimiter2() {
        assertThrows(IllegalArgumentException.class, () -> {
            String input = "//9\\n19293";
            delimiter.findCustomDelimiter(input);
        });
    }
}
