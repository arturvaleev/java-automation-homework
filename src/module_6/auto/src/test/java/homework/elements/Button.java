package homework.elements;

import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 29.04.2025
 */

public class Button extends UiComponent {

    private static final Logger logger = LoggerFactory.getLogger(Button.class);

    public Button(By selfSelector) {
        super(selfSelector);
    }

    public void click() {
        String buttonText = element.getText();
        element.click();
        logger.info("User click [Button:{}]", buttonText);
    }
}
