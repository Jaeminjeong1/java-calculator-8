package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;
import calculator.view.OutputView;

import java.util.List;

public class CalculatorController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final CalculatorService calculatorService = new CalculatorService();

    public void start() {
        String userInput = inputView.getStartInput();
        List<String> strings = calculatorService.findNumbers(userInput);
        Object result = calculatorService.calculateResult(strings);
        outputView.printResult(result);
    }
}
