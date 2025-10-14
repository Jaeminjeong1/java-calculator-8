package calculator.controller;

import calculator.service.CalculatorService;
import calculator.view.InputView;

public class CalculatorController {

    private InputView inputView = new InputView();
    private CalculatorService calculatorService = new CalculatorService();

    public void start() {
        String userInput = inputView.getStartInput();

    }
}
