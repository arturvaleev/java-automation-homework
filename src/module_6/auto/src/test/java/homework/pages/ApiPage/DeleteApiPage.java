package homework.pages.ApiPage;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import homework.elements.Button;
import homework.elements.Input;
import homework.elements.UiComponentFactory;
import homework.pages.BasePage;
import homework.pages.mainPage.MainPage;

import static com.codeborne.selenide.Selenide.$;

public class DeleteApiPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(DeleteApiPage.class);

    private static final By CONFIRM_CHECKBOX = By.name("confirm_delete");
    private static final By DELETE_BUTTON = By.name("submit");
    private static final String TITLE_VALUE = "%s - Delete API Token";

    private Button deleteButton = UiComponentFactory.createButton(DELETE_BUTTON);
    private Input confirmCheckBox = UiComponentFactory.createInput(CONFIRM_CHECKBOX);

    public DeleteApiPage(String name) {
        logger.info("Navigate to DeleteUserPage [{}]", name);
        $(TITLE).shouldHave(Condition.visible).shouldHave(Condition.text(String.format(TITLE_VALUE, name)));
    }

    public MainPage deleteApi() {
        confirmCheckBox.clickCheckBox();
        deleteButton.click();
        return new MainPage();
    }
}
