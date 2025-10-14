package calculator.view;

public class OutputView {

    private static final String PRINT_RESULT = "결과 : ";

    public void printResult(Object result) {
        System.out.println(PRINT_RESULT + result);
    }
}
