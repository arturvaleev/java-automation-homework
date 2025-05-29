package homework.pages.logsPage;

import com.codeborne.selenide.ElementsCollection;
import homework.pages.mainPage.models.LogsTableDto;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import homework.elements.Table;

public class LogsTable extends Table {

    private static final By SELF = By.cssSelector("table[id='logs']");

    private static final Logger logger = LoggerFactory.getLogger(LogsTable.class);

    public LogsTable() {
        super(SELF);
    }

    public LogsTableDto getLogByRow(int rowNumber) {
        collectBodyRows();
        ElementsCollection rowsData = collectBodyRowData(rows.get(rowNumber));
        return LogsTableDto.builder()
                .date(rowsData.get(0).getText())
                .action(rowsData.get(1).getText())
                .user(rowsData.get(2).getText())
                .ip(rowsData.get(3).getText())
                .build();
    }
}
