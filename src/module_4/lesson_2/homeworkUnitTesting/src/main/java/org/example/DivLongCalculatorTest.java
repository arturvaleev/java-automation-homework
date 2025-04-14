package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DivLongCalculatorTest extends BaseTest {

    @Test(groups = {"math"})
    public void divLongTest() {
        long result = calculator.div(10L, 2L);
        Assert.assertEquals(result, 5L, "Проверка провалилась. Результат выполнения метода >div (Long)< некорректен");
    }
}
