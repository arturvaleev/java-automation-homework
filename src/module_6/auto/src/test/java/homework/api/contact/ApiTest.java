package homework.api.contact;

import homework.api.contact.models.FindNumberResponseDto;
import homework.entities.ApiEntity;
import com.github.javafaker.Faker;
import homework.entities.ContactEntity;
import homework.pages.apiPage.AddEditApiPage;
import homework.pages.apiPage.DeleteApiPage;
import homework.pages.cotactInfoPage.AddEditContactPage;
import homework.pages.cotactInfoPage.ContactInfoPage;
import homework.pages.mainPage.models.ApiTableDto;
import org.assertj.core.api.SoftAssertions;
import org.testng.annotations.BeforeClass;
import homework.BaseTestClass;
import homework.pages.mainPage.MainPage;
import org.testng.annotations.Test;

import java.time.LocalDate;

public class ApiTest extends BaseTestClass {

    private static String token;
    private static String method = "findNumber";
    private static String number;
    private static String fullName;
    private static String successMessage = "API call successful.";
    private static Integer successCode = 1;
    private static String ipAddress = "172.18.0.1";

    private final Faker faker = Faker.instance();

    private ApiEntity apiForSave;
    private ContactEntity contactForSave;
    private final ContactSystemConnector contactSystemConnector = new ContactSystemConnector();
    private MainPage mainPage;


    @BeforeClass
    private void apiPrepareCondition() {

        contactForSave = new ContactEntity();
        contactForSave.withName(faker.elderScrolls().firstName())
                .withMiddleName(faker.elderScrolls().race())
                .withLastName(faker.elderScrolls().lastName())
                .withPhoneNumber(String.format("8%s", faker.number().digits(11)))
                .withMobileNumber(String.format("8%s", faker.number().digits(11)))
                .withEmail(String.format("email%s@test.com", faker.number().digits(10)))
                .withBirthDate(LocalDate.of(
                        faker.number().numberBetween(1900, 2025),
                        faker.number().numberBetween(1, 12),
                        faker.number().numberBetween(1, 28)))
                .withAddress1(faker.address().firstName())
                .withAddress2(faker.address().lastName())
                .withCity(faker.address().city())
                .withCountry(faker.address().country())
                .withPostCode(faker.number().digits(6));

        apiForSave = new ApiEntity();
        apiForSave.withCosmeticName(faker.name().username())
                .withIpAddress(ipAddress);
    }

    @Test
    public void apiFindNumberTest() {

        mainPage = loginInSite();
        AddEditContactPage addEditContactPage = mainPage.goToAddContactPage();
        mainPage = addEditContactPage.fillContactData(contactForSave).saveContact();
        AddEditApiPage addEditApiPage = mainPage.goToAddApiTokenPage();
        mainPage = addEditApiPage.fillNewApiData(apiForSave).saveNewApi();

        mainPage.findApi(apiForSave.getCosmeticName());
        ApiTableDto firstApi = mainPage.getApiTable().getFirstTableApi();

        token = firstApi.getApiToken();
        number = contactForSave.getMobileNumber();
        fullName = contactForSave.getFirsAndLastName();

        FindNumberResponseDto actualFindNumber = contactSystemConnector.findNumber(token, method, number);

        SoftAssertions.assertSoftly(
                softAssertions -> {
                    softAssertions.assertThat(actualFindNumber.getSuccess())
                            .as("Check Success code")
                            .isEqualTo(successCode);
                    softAssertions.assertThat(actualFindNumber.getMethod())
                            .as("Check Method")
                            .isEqualTo(method);
                    softAssertions.assertThat(actualFindNumber.getQuery())
                            .as("Check Number")
                            .isEqualTo(number);
                    softAssertions.assertThat(actualFindNumber.getResult())
                            .as("Check FullName")
                            .isEqualTo(fullName);
                    softAssertions.assertThat(actualFindNumber.getResultMessage())
                            .as("Check Messages")
                            .isEqualTo(successMessage);
                }
        );

        DeleteApiPage deleteApiPage = mainPage.getApiTable().navigateToFirstTableRowDeleteApiPage();
        mainPage = deleteApiPage.deleteApi();
        mainPage.goToAddressBookPage();
        mainPage.findContact(contactForSave.getEmail());
        ContactInfoPage contactInfoPage = mainPage.getContactTable().navigateToFirstTableRowContactPage();
        mainPage = contactInfoPage.navigateToDeleteContact().deleteContact();
    }
}
