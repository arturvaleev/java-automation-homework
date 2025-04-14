package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DivDoubleCalculatorTest extends BaseTest {

    @Test(groups = {"math"})
    public void divDoubleTest() {
        double result = calculator.div(10.0, 2.5);
        Assert.assertEquals(result, 4.0, "Проверка провалилась. Результат выполнения метода >div (double)< некорректен");
    }
}
