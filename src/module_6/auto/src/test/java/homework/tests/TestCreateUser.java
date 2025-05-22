package homework.tests;

import homework.components.PagePopup;
import homework.elements.Table;
import homework.entities.UserEntity;
import homework.pages.cotactInfoPage.ContactInfoPage;
import homework.pages.mainPage.models.UserTableDto;
import homework.pages.userPage.DeleteUserPage;
import homework.pages.userPage.SingleUserPage;
import homework.pages.userPage.UserPage;
import homework.pages.userPage.UserTable;
import com.github.javafaker.Faker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import homework.BaseTestClass;
import homework.pages.mainPage.MainPage;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class TestCreateUser extends BaseTestClass {

    private static final Logger logger = LoggerFactory.getLogger(TestCreateUser.class);
    private static final Locale LOCALE = Locale.ENGLISH;

    private final Faker faker = Faker.instance();

    private UserEntity userForSave;

    private MainPage mainPage;

    @BeforeClass
    public void prepareCondition() {
        userForSave = new UserEntity();
        userForSave.withFullName(faker.name().fullName())
                .withUsername(faker.name().username())
                .withPassword("Password" + faker.number());
    }

    @Test
    public void testCreateUser() {
        mainPage = loginInSite();
        SingleUserPage firstUserPage = mainPage.goToAddUserPage();
        mainPage = firstUserPage.fillNewUserData(userForSave).saveNewUser();

        String successPopupMessage = mainPage.getPagePopup().getText();
        String successPopupColor = mainPage.getPagePopup().getBackgroundColor();
        Assert.assertEquals(successPopupMessage, PagePopup.SUCCESS_USER_CREATE);
        Assert.assertEquals(successPopupColor, PagePopup.SUCCESS_POPUP_COLOR);

        mainPage.goToUserPage();

        mainPage.findUser(userForSave.getUsername());
        UserTableDto firstUser = mainPage.getUserTable().getFirstTableUser();

        assertThat(firstUser.getName())
                .as("Check User FullName")
                .isEqualTo(userForSave.getFullName());
        assertThat(firstUser.getUsername())
                .as("Check Username")
                .isEqualTo(userForSave.getUsername());

        DeleteUserPage deleteUserPage = mainPage.getUserTable().navigateToFirstTableRowDeleteUserPage();
        mainPage = deleteUserPage.deleteUser();
        String deleteTextPopup = mainPage.getPagePopup().getText();
        assertThat(deleteTextPopup)
                .as("Check Delete Text Popup")
                .isEqualTo(PagePopup.SUCCESS_USER_DELETE);

        UserPage userPage = mainPage.goToUserPage();
        userPage.findUser(userForSave.getUsername());
        String emptyRowText = userPage.getUserTable().getEmptyRowText();
        assertThat(emptyRowText)
                .as("Check Empty Row In User Table")
                .isEqualTo(Table.EMPTY_ROW_TEXT);
    }

    @AfterClass()
    public void afterAction() {
        mainPage.logout();
    }
}
