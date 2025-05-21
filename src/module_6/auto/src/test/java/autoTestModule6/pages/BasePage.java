package ru.evoloodsen.pages;

import org.openqa.selenium.By;
import ru.evoloodsen.components.NavigationBar;
import ru.evoloodsen.components.PagePopup;
import ru.evoloodsen.elements.UiComponentFactory;
import ru.evoloodsen.pages.mainPage.MainPage;
import ru.evoloodsen.pages.userPage.UserPage;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 06.05.2025
 */

public class BasePage {

    protected static final By TITLE = By.cssSelector("h2");

    protected NavigationBar navigationBar = UiComponentFactory.createNavigationBar(NavigationBar.SELF);
    protected final PagePopup pagePopup = UiComponentFactory.createPagePopup(PagePopup.SELF);

    protected static By getInputByName(String name) {
        return By.cssSelector(String.format("input[name='%s']", name));
    }

    public PagePopup getPagePopup(){
        return pagePopup;
    }

    public LoginPage logout() {
        return navigationBar.clickLogoutButton();
    }

    public MainPage goToAddressBookPage() {
        return navigationBar.clickAddressBookButton();
    }

    public UserPage goToUserPage() {
        return navigationBar.clickUserButton();
    }

    public LogsPage goToLogsPage() {
        return navigationBar.clickLogsButton();
    }

    public ApiPage goToApiPage() {
        return navigationBar.clickApiButton();
    }
}
