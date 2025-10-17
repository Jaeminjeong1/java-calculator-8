package calculator.domain;

import java.util.List;

public class Calculator {

    private double result;

    public Object calculateNumber(List<String> numbers) {
        //빈 문자열 들어오면 0반환
        if (numbers.contains("")) {
            return 0L;
        }
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
