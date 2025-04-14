package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubDoubleCalculatorTest extends BaseTest {

    @Test(groups = {"math"})
    public void subDoubleTest() {
        double result = calculator.sub(5.5, 2.0);
        Assert.assertEquals(result, 3.5, "Проверка провалилась. Результат выполнения метода >sub (double)< некорректен");
    }
}
