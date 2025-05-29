package homework.pages.apiPage;

import com.codeborne.selenide.Condition;
import homework.entities.ApiEntity;
import org.openqa.selenium.By;
import org.openqa.selenium.InvalidElementStateException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import homework.elements.Button;
import homework.elements.Input;
import homework.elements.UiComponentFactory;
import homework.pages.BasePage;
import homework.pages.mainPage.MainPage;
import static com.codeborne.selenide.Selenide.$;

public class AddEditApiPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(AddEditApiPage.class);

    public static final String ADD_TITLE_VALUE = "Add API Token";
    public static final String UPDATE_TITLE_VALUE = "%s - Update API Token";

    private static final By SUBMIT_BUTTON = By.cssSelector("button[type='submit']");

    private final Input cosmeticName = UiComponentFactory.createInput(getInputByName("cosmetic_name"));
    private final Input ipAddress = UiComponentFactory.createInput(getInputByName("ip_address"));
    private final Button saveApi = UiComponentFactory.createButton(SUBMIT_BUTTON);


    private final boolean isUpdateApiState;

    public AddEditApiPage() {
        logger.info("Navigate to Add ApiPage");
        $(TITLE).shouldHave(Condition.visible).shouldHave(Condition.text(ADD_TITLE_VALUE));
        isUpdateApiState = false;
    }

    public AddEditApiPage(String apiToken) {
        String title = String.format(UPDATE_TITLE_VALUE, apiToken);
        logger.info("Navigate to Update ApiPage");
        $(TITLE).shouldHave(Condition.visible).shouldHave(Condition.text(title));
        isUpdateApiState = true;
    }

    public AddEditApiPage fillNewApiData(ApiEntity apiEntity) {
        cosmeticName.fillData(apiEntity.getCosmeticName());
        ipAddress.fillData(apiEntity.getIpAddress());
        return this;
    }

    public AddEditApiPage editApiName(ApiEntity apiEntity) {
        if (!isUpdateApiState) {
            throw new InvalidElementStateException("Wrong Page State: Add New Api");
        }
        cosmeticName.clearInput().fillData(apiEntity.getCosmeticName());
        return this;
    }


    public ApiPage confirmChangeApiName() {
        saveApi.click();
        return new ApiPage();
    }

    public MainPage saveNewApi() {
        saveApi.click();
        return new MainPage();
    }
}
