package subway.controller;

import java.util.Arrays;
import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.command.MainCommand;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.command.StationCommand;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    private final InputView inputView;
    private final OutputView outputView;

    public SubwayController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        initData();
    }

    public void start() {
        outputView.printMainMenu();
        MainCommand command = inputMainMenuCommand();
        if (command.isPlayable()) {
            outputView.printStationMenu();
            StationCommand stationCommand = readStationCommand();

        }
    }

    private StationCommand readStationCommand() {
        while (true) {
            try {
                return inputView.readStationCommand();
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception);
            }
        }
    }

    private MainCommand inputMainMenuCommand() {
        while (true) {
            try {
                return inputView.readMainCommand();
            } catch (IllegalArgumentException exception) {
                outputView.printExceptionMessage(exception);
            }
        }
    }

    private void initData() {
        initStation();
        initLine();
    }

    private static void initStation() {
        List<String> initStationData = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        for (String stationName : initStationData) {
            StationRepository.addStation(new Station(stationName));
        }
    }

    private void initLine() {
        List<String> lines = List.of("2호선", "3호선", "신분당선");
        List<List<String>> sections = Arrays.asList(List.of("교대역", "강남역", "역삼역"),
                List.of("교대역", "남부터미널역", "양재역", "매봉역"), List.of("강남역", "양재역", "양재시민의숲역"));
        for (int i = 0; i < lines.size(); i++) {
            Line line = new Line(lines.get(i));
            addSection(sections.get(i), line);
            LineRepository.addLine(line);
        }
    }

    private void addSection(List<String> sections, Line line) {
        for (String station : sections) {
            line.addSection(StationRepository.getStation(station));
        }
    }
}
