package calculator.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String START_INPUT = "덧셈할 문자열을 입력해 주세요.";

    public String getStartInput () {
        System.out.println(START_INPUT);
        return Console.readLine();
    }
}
