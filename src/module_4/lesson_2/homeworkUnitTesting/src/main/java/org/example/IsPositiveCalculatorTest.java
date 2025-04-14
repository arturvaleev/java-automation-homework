package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class IsPositiveCalculatorTest extends BaseTest {

    @Test(groups = {"positiveOrNegative"})
    public void isPositiveTest() {
        Assert.assertEquals(calculator.isPositive(5L), true,  "Проверка провалилась. Результат выполнения метода >isPositive< некорректен");
        Assert.assertEquals(calculator.isPositive(-5L), false, "Проверка провалилась. Результат выполнения метода >isPositive< некорректен");
    }
}
