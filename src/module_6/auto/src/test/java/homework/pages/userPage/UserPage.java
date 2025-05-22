package homework.pages.userPage;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import homework.elements.Button;
import homework.elements.Input;
import homework.elements.UiComponentFactory;
import homework.pages.BasePage;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 29.04.2025
 */

public class UserPage extends BasePage {

    private static final Logger logger = LoggerFactory.getLogger(UserPage.class);

    private static final By ADD_USER_BUTTON = By.cssSelector("a[type='button']");
    private static final By FIND_INPUT = By.cssSelector("input[type='search']");
    private static final By DELETE_BUTTON =  By.cssSelector("//*[@id='users']/tbody/tr[1]/td[3]/a[2]");

    private final Button addUserButton = UiComponentFactory.createButton(ADD_USER_BUTTON);
    private final Input findInput = UiComponentFactory.createInput(FIND_INPUT);
    private final Button deleteUser = UiComponentFactory.createButton(DELETE_BUTTON);

    private final String name;
    private final String userName;

    private final UserTable userTable = new UserTable();

    public UserPage(String name, String userName) {
        this.name = name;
        this.userName = userName;
        logger.info("Navigate to UserPage");
    }

    public UserPage() {
        this.name = "";
        this.userName = "";
        logger.info("Navigate to UserPage");
    }

    public UserPage findUser(String searchText) {
        findInput.fillData(searchText);
        return this;
    }

    public SingleUserPage goToAddUserPage() {
        addUserButton.click();
        return new SingleUserPage();
    }

    public UserTable getUserTable() {
        return userTable;
    }

    public DeleteUserPage navigateToDeleteUser() {
        deleteUser.click();
        return new DeleteUserPage(name, userName);
    }

}
