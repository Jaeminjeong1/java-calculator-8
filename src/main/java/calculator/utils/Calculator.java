package calculator.utils;

import java.util.List;

public class Calculator {

    private double result;

    public double calculateNumber(List<String> numbers) {
        for (String number : numbers) {
            validateNum(number);
            result += Double.parseDouble(number);
        }
        return result;
    }

    //숫자 검증
    private void validateNum(String number) {
        try {
            double tempNum = Double.parseDouble(number);
            if (tempNum <= 0) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
