package homework.pages.mainPage;

import homework.pages.apiPage.AddEditApiPage;
import homework.pages.apiPage.ApiTable;
import homework.pages.logsPage.LogsTable;
import homework.pages.userPage.SingleUserPage;
import homework.pages.userPage.UserTable;
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
    private static final By ADD_USER_BUTTON = By.cssSelector("a[href='add-user.php']");
    private static final By ADD_API_BUTTON = By.cssSelector("a[type='button']");
    private static final By FIND_INPUT = By.cssSelector("input[type='search']");

    private final ContactTable contactTable = new ContactTable();
    private final UserTable userTable = new UserTable();
    private final ApiTable apiTable = new ApiTable();
    private final LogsTable logsTable = new LogsTable();
    private final Button addContactButton = UiComponentFactory.createButton(ADD_CONTACT_BUTTON);
    private final Button addUserButton = UiComponentFactory.createButton(ADD_USER_BUTTON);
    private final Button addApiButton = UiComponentFactory.createButton(ADD_API_BUTTON);
    private final Input findInput = UiComponentFactory.createInput(FIND_INPUT);

    public MainPage() {
        logger.info("Navigate to MainPage");
    }

    public MainPage findContact(String searchText) {
        findInput.fillData(searchText);
        return this;
    }

    public MainPage findUser(String searchText) {
        findInput.fillData(searchText);
        return this;
    }

    public MainPage findApi(String searchText) {
        findInput.fillData(searchText);
        return this;
    }

    public ContactTable getContactTable() {
        return contactTable;
    }

    public UserTable getUserTable() {
        return userTable;
    }

    public ApiTable getApiTable() {
        return apiTable;
    }

    public LogsTable getLogsTable() {
        return logsTable;
    }

    public PagePopup getPagePopup() {
        return pagePopup;
    }

    public AddEditContactPage goToAddContactPage() {
        addContactButton.click();
        return new AddEditContactPage();
    }

    public SingleUserPage goToAddUserPage() {
        goToUserPage();
        addUserButton.click();
        return new SingleUserPage();
    }

    public AddEditApiPage goToAddApiTokenPage() {
        goToApiPage();
        addApiButton.click();
        return new AddEditApiPage();
    }
}
