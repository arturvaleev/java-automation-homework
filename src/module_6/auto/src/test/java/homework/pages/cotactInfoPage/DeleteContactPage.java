package homework.pages.cotactInfoPage;

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

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 29.04.2025
 */

public class DeleteContactPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(DeleteContactPage.class);

    private static final By CONFIRM_CHECKBOX = By.name("confirm_delete");
    private static final By DELETE_BUTTON = By.name("submit");
    private static final String TITLE_VALUE = "%s - Delete Contact";

    private Button deleteButton = UiComponentFactory.createButton(DELETE_BUTTON);
    private Input confirmCheckBox = UiComponentFactory.createInput(CONFIRM_CHECKBOX);

    public DeleteContactPage(String contactName) {
        logger.info("Navigate to DeleteContactPage [{}]", contactName);
        $(TITLE).shouldHave(Condition.visible).shouldHave(Condition.text(String.format(TITLE_VALUE, contactName)));
    }

    public MainPage deleteContact() {
        confirmCheckBox.clickCheckBox();
        deleteButton.click();
        return new MainPage();
    }

}
