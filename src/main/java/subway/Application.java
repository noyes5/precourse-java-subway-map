package subway;

import subway.controller.SubwayController;
import subway.view.InputView;
import subway.view.OutputView;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        SubwayController subwayController = new SubwayController(inputView, outputView);
        subwayController.start();
    }
}
