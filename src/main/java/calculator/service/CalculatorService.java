package calculator.service;

import calculator.utils.Calculator;
import calculator.utils.Delimiter;

import java.util.List;

public class CalculatorService {

    private final Delimiter delimiter = new Delimiter();
    private final Calculator calculator = new Calculator();

    public List<String> findNumbers(String userInput) {
        String customDelimiter = delimiter.findCustomDelimiter(userInput);
        List<String> numbers = delimiter.splitString(userInput);
        return numbers;
    }

    public Object calculateResult(List<String> strings) {
        double tempResult = calculator.calculateNumber(strings);
        Object result = calculator.determineType(tempResult);
        return result;
    }
}
