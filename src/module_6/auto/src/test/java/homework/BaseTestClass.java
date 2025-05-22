package homework;

import com.codeborne.selenide.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import homework.pages.LoginPage;
import homework.pages.mainPage.MainPage;

import static com.codeborne.selenide.Selenide.open;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 22.04.2025
 */

public class BaseTestClass {

    private static final Logger logger = LoggerFactory.getLogger(BaseTestClass.class);

    private LoginPage loginPage;

    protected static final String ADMIN_LOGIN = "admin";
    protected static final String ADMIN_PASSWORD = "root";



    @BeforeClass(alwaysRun = true)
    public void precondition() {
        logger.info("=== PREPARE TESTS START ===");
        Configuration.browser = "chrome";
        Configuration.pageLoadStrategy = "normal";
        Configuration.baseUrl = "http://localhost:12301/";
        Configuration.headless = false;
        logger.info("=== PREPARE TESTS FINISH ===");
        open(Configuration.baseUrl);
        logger.info("Open page {}", Configuration.baseUrl);
    }

    protected MainPage loginInSite() {
        return new LoginPage().enterLoginData(ADMIN_LOGIN)
                .enterPasswordData(ADMIN_PASSWORD)
                .pressLogin();
    }

    protected MainPage loginInSiteWithCredentials(String login, String password) {
        return new LoginPage().enterLoginData(login)
                .enterPasswordData(password)
                .pressLogin();
    }

}
