package homework.pages.mainPage;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import homework.components.PagePopup;
import homework.elements.Button;
import homework.elements.Input;
import homework.elements.UiComponentFactory;
import homework.pages.cotactInfoPage.AddEditContactPage;
import homework.pages.BasePage;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 29.04.2025
 */

public class MainPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(MainPage.class);

    private static final By ADD_CONTACT_BUTTON = By.cssSelector("a[data-testid='add_contact']");
    private static final By FIND_INPUT = By.cssSelector("input[type='search']");

    private final ContactTable contactTable = new ContactTable();
    private final Button addContactButton = UiComponentFactory.createButton(ADD_CONTACT_BUTTON);
    private final Input findInput = UiComponentFactory.createInput(FIND_INPUT);

    public MainPage() {
        logger.info("Navigate to MainPage");
    }

    public MainPage findContact(String searchText) {
        findInput.fillData(searchText);
        return this;
    }

    public ContactTable getContactTable() {
        return contactTable;
    }

    public PagePopup getPagePopup() {
        return pagePopup;
    }

    public AddEditContactPage goToAddContactPage() {
        addContactButton.click();
        return new AddEditContactPage();
    }
}
