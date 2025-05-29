package homework.pages.apiPage;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import homework.pages.apiPage.models.ApiAction;
import homework.pages.mainPage.models.ApiTableDto;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import homework.elements.Table;

public class ApiTable extends Table {

    private static final By SELF = By.cssSelector("table[id='api']");
    private static final By EMPTY_ROW = By.cssSelector(".dataTables_empty");

    private static final String UPDATE_BUTTON_TEXT = "Update";
    private static final String DELETE_BUTTON_TEXT = "Delete";

    private static final Logger logger = LoggerFactory.getLogger(ApiTable.class);

    public ApiTable() {
        super(SELF);
    }

    public String getEmptyRowText() {
        return element.find(EMPTY_ROW).getText();
    }

    public ApiTableDto getApiByRow(int rowNumber) {
        collectBodyRows();
        ElementsCollection rowsData = collectBodyRowData(rows.get(rowNumber));
        return ApiTableDto.builder()
                .apiToken(rowsData.get(0).getText())
                .cosmeticName(rowsData.get(1).getText())
                .authorised_Ip(rowsData.get(2).getText())
                .build();
    }

    public ApiTableDto getFirstTableApi() {
        return getApiByRow(0);
    }

    public AddEditApiPage updateApiByRow(int rowNumber) {
        collectBodyRows();
        ElementsCollection rowsData = collectBodyRowData(rows.get(rowNumber));
        String apiToken = rowsData.get(0).getText();
        String name = rowsData.get(1).getText();
        SelenideElement updateApiButton = rows.get(rowNumber).findAll("a").filter(Condition.text(ApiAction.UPDATE.getValue())).first();
        String updateApiButtonText = updateApiButton.getText();
        updateApiButton.click();
        logger.info("User click [{}] for user [{}]", updateApiButtonText, name);
        return new AddEditApiPage(apiToken);
    }

    public AddEditApiPage navigateToFirstTableRowUpdateApiPage() {
        return updateApiByRow(0);
    }

    public DeleteApiPage deleteApiByRow(int rowNumber) {
        collectBodyRows();
        ElementsCollection rowsData = collectBodyRowData(rows.get(rowNumber));
        String apiToken = rowsData.get(0).getText();
        String name = rowsData.get(1).getText();
        SelenideElement deleteApiButton = rows.get(rowNumber).findAll("a").filter(Condition.text(ApiAction.DELETE.getValue())).first();
        String updateApiButtonText = deleteApiButton.getText();
        deleteApiButton.click();
        logger.info("User click [{}] for user [{}]", updateApiButtonText, name);
        return new DeleteApiPage(apiToken);
    }

    public DeleteApiPage navigateToFirstTableRowDeleteApiPage() {
        return deleteApiByRow(0);
    }
}
