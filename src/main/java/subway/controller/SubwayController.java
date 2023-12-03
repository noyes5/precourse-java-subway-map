package subway.controller;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;
import subway.domain.command.LineCommand;
import subway.domain.command.MainCommand;
import subway.domain.command.SectionCommand;
import subway.domain.command.StationCommand;
import subway.view.InputView;
import subway.view.OutputView;

public class SubwayController {
    private final InputView inputView;
    private final OutputView outputView;
    private final Map<StationCommand, Runnable> stationHandlers;
    private final Map<LineCommand, Runnable> lineHandlers;
    private final Map<SectionCommand, Runnable> sectionHandlers;

    public SubwayController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.stationHandlers = initStationHandlers();
        this.lineHandlers = initLineHandlers();
        this.sectionHandlers = initSectionHandlers();
        initData();
    }

    private void initData() {
        initStation();
        initLine();
    }

    public void start() {
        MainCommand command;
        do {
            outputView.printMainMenu();
            command = inputMainMenuCommand();
            executeCommand(command);
        } while (command.isPlayable());
    }

    private void executeCommand(MainCommand command) {
        if (command == MainCommand.STATION_MANAGEMENT) {
            executeStationManagement();
        }
        if (command == MainCommand.LINE_MANAGEMENT) {
            executeLineManagement();
        }
        if (command == MainCommand.SECTION_MANAGEMENT) {
            executeSectionManagement();
        }
        if (command == MainCommand.PRINT_SUBWAY_ROUTE) {
            executePrintSubwayRoute();
        }
    }

    private void executeStationManagement() {
        outputView.printStationMenu();
        readStationCommand();
    }

    private void executeLineManagement() {
        outputView.printLineMenu();
        readLineCommand();
    }

    private void executeSectionManagement() {
        outputView.printSectionMenu();
        readSectionCommand();
    }

    private void executePrintSubwayRoute() {
        outputView.printAllLine(LineRepository.lines());
    }

    private void readLineCommand() {
        try {
            LineCommand lineCommand = inputView.readLineCommand();
            lineHandlers.get(lineCommand).run();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

    private void readStationCommand() {
        try {
            StationCommand stationCommand = inputView.readStationCommand();
            stationHandlers.get(stationCommand).run();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

    private void readSectionCommand() {
        try {
            SectionCommand sectionCommand = inputView.readSectionCommand();
            sectionHandlers.get(sectionCommand).run();
        } catch (IllegalArgumentException exception) {
            outputView.printExceptionMessage(exception);
        }
    }

    private Map<StationCommand, Runnable> initStationHandlers() {
        Map<StationCommand, Runnable> stationHandlers = new EnumMap<>(StationCommand.class);
        stationHandlers.put(StationCommand.STATION_REGISTER, this::handleStationRegistration);
        stationHandlers.put(StationCommand.STATION_DELETE, this::handleStationDeletion);
        stationHandlers.put(StationCommand.STATION_SEARCH, this::handleStationSearch);
        stationHandlers.put(StationCommand.GO_BACK, this::handleGoMain);
        return stationHandlers;
    }

    private void handleStationRegistration() {
        String stationName = inputView.readAddStationName();
        StationRepository.addStation(new Station(stationName));
        outputView.printCompleteStation();
    }

    private void handleStationDeletion() {
        String stationName = inputView.readDeleteStationName();
        StationRepository.deleteStation(stationName);
        outputView.printDeleteStation();
    }

    private void handleStationSearch() {
        StationRepository.stations()
                .forEach(outputView::printStations);
        start();
    }

    private void handleGoMain() {
        start();
    }

    private Map<LineCommand, Runnable> initLineHandlers() {
        Map<LineCommand, Runnable> lineHandlers = new EnumMap<>(LineCommand.class);
        lineHandlers.put(LineCommand.LINE_REGISTER, this::handleLineRegistration);
        lineHandlers.put(LineCommand.LINE_DELETE, this::handleLineDeletion);
        lineHandlers.put(LineCommand.LINE_SEARCH, this::handleLineSearch);
        lineHandlers.put(LineCommand.GO_BACK, this::handleGoMain);
        return lineHandlers;
    }

    private void handleLineRegistration() {
        String lineName = inputView.readAddLineName();
        Line newLine = new Line(lineName);
        newLine.addSection(StationRepository.getStation(inputView.readFirstStation()));
        newLine.addSection(StationRepository.getStation(inputView.readLastStation()));
        LineRepository.addLine(newLine);

        outputView.printCompleteLine();
    }

    private void handleLineDeletion() {
        String lineName = inputView.readDeleteLineName();
        LineRepository.deleteLineByName(lineName);

        outputView.printDeleteLine();
    }

    private void handleLineSearch() {
        LineRepository.lines()
                .forEach(outputView::printLines);
    }

    private Map<SectionCommand, Runnable> initSectionHandlers() {
        Map<SectionCommand, Runnable> sectionHandlers = new EnumMap<>(SectionCommand.class);
        sectionHandlers.put(SectionCommand.SECTION_REGISTER, this::handleSectionRegistration);
        sectionHandlers.put(SectionCommand.SECTION_DELETE, this::handleSectionDeletion);
        sectionHandlers.put(SectionCommand.GO_BACK, this::handleGoMain);
        return sectionHandlers;
    }

    private void handleSectionRegistration() {
        String lineName = inputView.readLineNameForAddSection();
        Line line = LineRepository.getLine(lineName);
        Station station = StationRepository.getStation(inputView.readStationNameForAddSection());
        int index = inputView.readSectionIndex();
        line.addSection(station, index);

        outputView.printCompleteSection();
    }

    private void handleSectionDeletion() {
        String lineName = inputView.readLineNameForDeleteSection();
        Line line = LineRepository.getLine(lineName);
        Station station = StationRepository.getStation(inputView.readStationNameForAddSection());
        line.deleteSection(station);

        outputView.printDeleteSection();
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

    private static void initStation() {
        List<String> initStationData = Arrays.asList("교대역", "강남역", "역삼역", "남부터미널역", "양재역", "양재시민의숲역", "매봉역");
        for (String stationName : initStationData) {
            StationRepository.addStation(new Station(stationName));
        }
    }

    private void initLine() {
        List<String> lines = List.of("2호선", "3호선", "신분당선");
        List<List<String>> sections = Arrays.asList(List.of("교대역", "강남역","역삼역"),
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
