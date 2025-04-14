package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PowCalculatorTest extends BaseTest {

    @Test(groups = {"math"})
    public void powTest() {
        double result = calculator.pow(2.0, 3.0);
        Assert.assertEquals(result, 8.0, "Проверка провалилась. Результат выполнения метода >pow< некорректен");
    }
}
