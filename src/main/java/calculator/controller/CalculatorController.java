package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;

import java.util.List;

public class CalculatorController {

    private InputView inputView = new InputView();
    private CalculatorService calculatorService = new CalculatorService();

    public void start() {
        String userInput = inputView.getStartInput();
        List<String> numbers = calculatorService.findNumbers(userInput);
    }
}
