package calculator.service;

import calculator.domain.Delimiter;

import java.util.ArrayList;
import java.util.List;

public class CalculatorService {

    private Delimiter delimiter = new Delimiter();

    public List<String> findNumbers(String userInput) {
        String customDelimiter = delimiter.findCustomDelimiter(userInput);
        List<String> numbers = delimiter.splitString(userInput);
        return numbers;
    }
}
