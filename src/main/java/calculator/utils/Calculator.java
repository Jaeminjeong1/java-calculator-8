package calculator.utils;

import java.util.List;

public class Calculator {

    private double result;

    public Object calculateNumber(List<String> numbers) {
        for (String number : numbers) {
            validateNum(number);
            result += Double.parseDouble(number);
        }

        return determineType(result);
    }

    private Object determineType(double number) {
        if (number % 1 == 0) {
            return (long) number;
        }
        return number;
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
