package subway.controller;

import java.util.Scanner;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Scanner scanner;

    public SubwayController(InputView inputView, OutputView outputView, Scanner scanner) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.scanner = scanner;
    }

    public void start() {
        outputView.printMainMenu();
        int command = inputView.readMenuNumber(scanner);
    }
}
