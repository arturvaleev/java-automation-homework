package ru.evoloodsen.pages;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 29.04.2025
 */

public class LogsPage extends BasePage {
    private static final Logger logger = LoggerFactory.getLogger(LogsPage.class);

    public LogsPage() {
        logger.info("Navigate to LogsPage");
    }

}
