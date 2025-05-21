package homework.pages;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 29.04.2025
 */

public class ApiPage {
    private static final Logger logger = LoggerFactory.getLogger(ApiPage.class);

    private static final By NAVIGATION_BAR = By.cssSelector("nav[data-testid='navbar']");
    private static final By NAV_BAR_BUTTON = By.cssSelector("li[data-testid='navbar_item']");

    public ApiPage() {
        logger.info("Navigate to ApiPage");
    }

}
