package homework.tests;

import homework.components.PagePopup;
import homework.elements.Table;
import homework.entities.ApiEntity;
import com.github.javafaker.Faker;
import homework.pages.apiPage.AddEditApiPage;
import homework.pages.apiPage.ApiPage;
import homework.pages.apiPage.DeleteApiPage;
import homework.pages.mainPage.models.ApiTableDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import homework.BaseTestClass;
import homework.pages.mainPage.MainPage;
import org.testng.annotations.Test;

import java.util.Locale;

import static org.assertj.core.api.Assertions.assertThat;

public class TestApiPage extends BaseTestClass {

    private static final Logger logger = LoggerFactory.getLogger(TestApiPage.class);
    private static final Locale LOCALE = Locale.ENGLISH;

    private final Faker faker = Faker.instance();

    private ApiEntity apiForSave;
    private ApiEntity apiForUpdate;

    private MainPage mainPage;

    @BeforeClass
    public void prepareCondition() {
        apiForSave = new ApiEntity();
        apiForSave.withCosmeticName(faker.name().username())
                .withIpAddress("172.18.0.1");

        apiForUpdate = new ApiEntity();
        apiForUpdate.withCosmeticName(faker.name().username())
                .withIpAddress("172.18.0.1");

    }

    @Test(priority = 1)
    public void testAddApiToken() {

        mainPage = loginInSite();
        AddEditApiPage addEditApiPage = mainPage.goToAddApiTokenPage();
        mainPage = addEditApiPage.fillNewApiData(apiForSave).saveNewApi();

        String successPopupMessage = mainPage.getPagePopup().getText();
        String successPopupColor = mainPage.getPagePopup().getBackgroundColor();
        Assert.assertEquals(successPopupMessage, PagePopup.SUCCESS_API_ADDED);
        Assert.assertEquals(successPopupColor, PagePopup.SUCCESS_POPUP_COLOR);


        mainPage.findApi(apiForSave.getCosmeticName());
        ApiTableDto firstApi = mainPage.getApiTable().getFirstTableApi();

        assertThat(firstApi.getCosmeticName())
                .as("Check Api name")
                .isEqualTo(apiForSave.getCosmeticName());
        assertThat(firstApi.getAuthorised_Ip())
                .as("Check Ip Address")
                .isEqualTo(apiForSave.getIpAddress());
    }

    @Test(priority = 2)
    public void testUpdateApiToken() {

        AddEditApiPage editApiPage = mainPage.getApiTable().navigateToFirstTableRowUpdateApiPage();
        editApiPage.editApiName(apiForUpdate).confirmChangeApiName();

        String successPopupMessage = mainPage.getPagePopup().getText();
        String successPopupColor = mainPage.getPagePopup().getBackgroundColor();
        Assert.assertEquals(successPopupMessage, PagePopup.SUCCESS_API_UPDATED);
        Assert.assertEquals(successPopupColor, PagePopup.SUCCESS_POPUP_COLOR);

        mainPage.findApi(apiForUpdate.getCosmeticName());
        ApiTableDto firstApi = mainPage.getApiTable().getFirstTableApi();

        assertThat(firstApi.getCosmeticName())
                .as("Check Api name")
                .isEqualTo(apiForUpdate.getCosmeticName());
        assertThat(firstApi.getAuthorised_Ip())
                .as("Check Ip Address")
                .isEqualTo(apiForUpdate.getIpAddress());
    }

    @Test(priority = 3)
    public void testDeleteApiToken() {

        DeleteApiPage deleteApiPage = mainPage.getApiTable().navigateToFirstTableRowDeleteApiPage();
        mainPage = deleteApiPage.deleteApi();

        String deleteTextPopup = mainPage.getPagePopup().getText();
        assertThat(deleteTextPopup)
                .as("Check Delete Text Popup")
                .isEqualTo(PagePopup.SUCCESS_API_DELETED);

        ApiPage apiPage = mainPage.goToApiPage();
        apiPage.findApi(apiForUpdate.getCosmeticName());

        String emptyRowText = apiPage.getApiTable().getEmptyRowText();
        assertThat(emptyRowText)
                .as("Check Empty Row In API Table")
                .isEqualTo(Table.EMPTY_ROW_TEXT);
    }

    @AfterClass()
    public void afterAction() {
        mainPage.logout();
    }
}
