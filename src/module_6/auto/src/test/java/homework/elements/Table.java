package homework.elements;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Aleksandr Gladkov [Anticisco]
 * Date: 29.04.2025
 */

public class Table extends UiComponent {

    private static final Logger logger = LoggerFactory.getLogger(Table.class);

    public static final String EMPTY_ROW_TEXT = "No matching records found";

    protected ElementsCollection rows;

    public Table(By selfSelector) {
        super(selfSelector);
    }

    protected ElementsCollection getHeadRow() {
        return element.find("thead").shouldHave(Condition.visible).findAll("tr");
    }

    protected ElementsCollection getBodyRows() {
        return getBodyRows("tbody", "tr");
    }

    public ElementsCollection getBodyRows(String bodySelector, String rowSelector) {
        return element.find(bodySelector).shouldHave(Condition.visible).findAll(rowSelector);
    }

    public ElementsCollection getBodyRows(By bodySelector, By rowSelector) {
        return element.find(bodySelector).shouldHave(Condition.visible).findAll(rowSelector);
    }

    protected void collectBodyRows() {
        rows = getBodyRows();
    }

    protected ElementsCollection collectBodyRowData(SelenideElement row) {
        return row.findAll("td");
    }

}
