package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TgCalculatorTest extends BaseTest {

    @Test(groups = {"trig"})
    public void tgTest() {
        double result = calculator.tg(1.0);
        Assert.assertEquals(result, Math.tan(1.0), 0.0001, "Проверка провалилась. Результат выполнения метода >tg< некорректен");
    }
}
