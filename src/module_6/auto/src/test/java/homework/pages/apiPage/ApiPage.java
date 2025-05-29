package homework.pages.apiPage;

import homework.elements.Button;
import homework.elements.Input;
import homework.elements.UiComponentFactory;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ApiPage {

    private static final Logger logger = LoggerFactory.getLogger(ApiPage.class);

    private static final By ADD_API_BUTTON = By.cssSelector("a[type='button']");
    private static final By FIND_INPUT = By.cssSelector("input[type='search']");
    private static final By DELETE_BUTTON =  By.cssSelector("/html/body/div/div/table/tbody/tr[1]/td[4]/a[2]");

    private final Button addApiButton = UiComponentFactory.createButton(ADD_API_BUTTON);
    private final Button deleteApiButton = UiComponentFactory.createButton(DELETE_BUTTON);
    private final Input findInput = UiComponentFactory.createInput(FIND_INPUT);

    private final String apiToken;
    private final String name;
    private final String authorised_Ip;

    private final ApiTable apiTable = new ApiTable();

    public ApiPage(String apiToken, String name, String authorised_Ip) {
        this.apiToken = apiToken;
        this.name = name;
        this.authorised_Ip = authorised_Ip;
        logger.info("Navigate to ApiPage");
    }

    public ApiPage() {
        this.apiToken = "";
        this.name = "";
        this.authorised_Ip = "";
        logger.info("Navigate to ApiPage");
    }

    public ApiPage findApi(String searchText) {
        findInput.fillData(searchText);
        return this;
    }

    public AddEditApiPage goToAddEditApiPage() {
        addApiButton.click();
        return new AddEditApiPage();
    }

    public ApiTable getApiTable() {
        return apiTable;
    }

    public DeleteApiPage navigateToDeleteUser() {
        deleteApiButton.click();
        return new DeleteApiPage(apiToken);
    }
}
