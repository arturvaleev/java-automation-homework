package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IsNegativeCalculatorTest extends BaseTest {

    @Test(groups = {"positiveOrNegative"})
    public void isNegativeTest() {
        Assert.assertEquals(calculator.isNegative(-5L), true, "Проверка провалилась. Результат выполнения метода >isNegative< некорректен");
        Assert.assertEquals(calculator.isNegative(5L), false, "Проверка провалилась. Результат выполнения метода >isNegative< некорректен");
    }
}