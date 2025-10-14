package calculator.utils;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {

    private static List<String> delimiters = new ArrayList<>(List.of(",", ":"));

    private static final String START_CUSTOM_DELIMITER = "//";
    private static final String END_CUSTOM_DELIMITER = "\\n";
    private static final String NUMBER_FORMAT = "\\d+";

    public String findCustomDelimiter(String userInput) {

        //커스텀 구분자 입력구조가 틀린경우 예외
        validateInputFormat(userInput);

        if (userInput.startsWith(START_CUSTOM_DELIMITER) && userInput.contains(END_CUSTOM_DELIMITER)) {
            int idx1 = userInput.indexOf(START_CUSTOM_DELIMITER) + 2;
            int idx2 = userInput.lastIndexOf(END_CUSTOM_DELIMITER);

            String customDelimiter = userInput.substring(idx1, idx2);

            //커스텀 구분자 "."이랑 숫자로 들어오면 안됨
            validateCustomDelimiter(customDelimiter);

            delimiters.add(customDelimiter);

            return customDelimiter;
        }

        return null;
    }

    //커스텀 구분자 "."이랑 숫자로 들어오면 안됨
    private static void validateCustomDelimiter(String customDelimiter) {
        if (customDelimiter.equals(".") || customDelimiter.matches(NUMBER_FORMAT)) {
            throw new IllegalArgumentException();
        }
    }

    //커스텀 구분자 입력구조가 틀린경우 예외
    private static void validateInputFormat(String userInput) {
        if ((userInput.startsWith(START_CUSTOM_DELIMITER) && !userInput.contains(END_CUSTOM_DELIMITER))
        || (!userInput.startsWith(START_CUSTOM_DELIMITER) && userInput.contains(END_CUSTOM_DELIMITER))) {
            throw new IllegalArgumentException();
        }
    }


    public List<String> splitString(String userInput) {
        List<String> strings;
        String splitFormatString = splitFormat(delimiters);

        //커스텀 구분자 있을떄
        if (userInput.startsWith(START_CUSTOM_DELIMITER)) {
            String afterUserInput = userInput.substring(userInput.lastIndexOf(END_CUSTOM_DELIMITER) + 2);
            strings = List.of(afterUserInput.split(splitFormatString));
            return strings;
        }
        //기본 구분자만 있을때
        strings = List.of(userInput.split(splitFormatString));
        return strings;
    }

    //split 형식에 맞게 바꿈(".|:|customDelimiter")
    private String splitFormat(List<String> delimiters) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for (String delimiter : delimiters) {
            if (idx < delimiters.size() - 1) {
                sb.append(delimiter);
                return sb.toString();
            }
            sb.append(delimiter).append("|");
            idx++;
        }
        return null;
    }
}
