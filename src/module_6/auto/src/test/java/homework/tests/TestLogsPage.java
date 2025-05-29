package homework.tests;

import homework.components.PagePopup;
import homework.pages.mainPage.models.LogsTableDto;
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

public class TestLogsPage extends BaseTestClass {

    private static final Logger logger = LoggerFactory.getLogger(TestLogsPage.class);
    private static final Locale LOCALE = Locale.ENGLISH;

    private MainPage mainPage;

    private static final String CHECK_ACTION_VIEW_LOGS = "Page Viewed: (Logs)";
    private static final String CHECK_ACTION_VIEW_ADDRESS_BOOK = "Page Viewed: (Address Book)";
    private static final String CHECK_ACTION_LOGIN_SUCCESS = "Login Success";
    private static final String CHECK_USER = "Admin User [admin]";
    private static final String CHECK_IP = "172.18.0.1";


    @BeforeClass
    public void prepareCondition() throws InterruptedException {
        Thread.sleep(1000);
        mainPage = loginInSite();
        Thread.sleep(1000);
        String successPopupMessage = mainPage.getPagePopup().getText();
        String successPopupColor = mainPage.getPagePopup().getBackgroundColor();
        Assert.assertEquals(successPopupMessage, PagePopup.SUCCESS_POPUP_TEXT);
        Assert.assertEquals(successPopupColor, PagePopup.SUCCESS_POPUP_COLOR);

        mainPage.goToLogsPage();
        Thread.sleep(2000);

    }

    @Test(priority = 1)
    public void testLogs() {

        LogsTableDto firstLogs = mainPage.getLogsTable().getLogByRow(0);
        LogsTableDto secondLogs = mainPage.getLogsTable().getLogByRow(1);
        LogsTableDto thirdLogs = mainPage.getLogsTable().getLogByRow(2);

        logger.info("Проверка страницы Logs началась");

        assertThat(firstLogs.getAction())
                .as("Check Logs: Action")
                .isEqualTo(CHECK_ACTION_VIEW_LOGS);
        assertThat(firstLogs.getUser())
                .as("Check Logs: User")
                .isEqualTo(CHECK_USER);
        assertThat(firstLogs.getIp())
                .as("Check Logs: IP")
                .isEqualTo(CHECK_IP);

        logger.info("Проверка первой записи лога прошла успешно");

        assertThat(secondLogs.getAction())
                .as("Check Logs: Action")
                .isEqualTo(CHECK_ACTION_LOGIN_SUCCESS);
        assertThat(firstLogs.getUser())
                .as("Check Logs: User")
                .isEqualTo(CHECK_USER);
        assertThat(firstLogs.getIp())
                .as("Check Logs: IP")
                .isEqualTo(CHECK_IP);

        logger.info("Проверка второй записи лога прошла успешно");

        assertThat(thirdLogs.getAction())
                .as("Check Logs: Action")
                .isEqualTo(CHECK_ACTION_VIEW_ADDRESS_BOOK);
        assertThat(firstLogs.getUser())
                .as("Check Logs: User")
                .isEqualTo(CHECK_USER);
        assertThat(firstLogs.getIp())
                .as("Check Logs: IP")
                .isEqualTo(CHECK_IP);

        logger.info("Проверка третьей записи лога прошла успешно");
    }

    @AfterClass()
    public void afterAction() {
        mainPage.logout();
    }
}
