package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Delimiter {

    private static List<String> delimiters = List.of(",", ":");

    private static final String START_CUSTOM_DELIMITER = "//";
    private static final String END_CUSTOM_DELIMITER = "\\n";

    public String findCustomDelimiter(String userInput) {

        if (userInput.startsWith(START_CUSTOM_DELIMITER) && userInput.contains(END_CUSTOM_DELIMITER)) {
            int idx1 = userInput.indexOf(START_CUSTOM_DELIMITER) + 2;
            int idx2 = userInput.lastIndexOf(END_CUSTOM_DELIMITER);

            String customDelimiter = userInput.substring(idx1, idx2);
            delimiters.add(customDelimiter);

            return customDelimiter;
        }

        return null;
    }

    private String splitFormat(List<String> delimiters) {
        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for (String delimiter : delimiters) {
            if (idx == delimiters.size() - 1) {
                sb.append(delimiter);
            }
            sb.append(delimiter).append("|");
            idx++;
        }
        return sb.toString();
    }
}
