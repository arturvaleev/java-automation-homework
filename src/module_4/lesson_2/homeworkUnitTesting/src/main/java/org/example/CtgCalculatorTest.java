package org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CtgCalculatorTest extends BaseTest {

    @Test(groups = {"trig"})
    public void ctgTest() {
        double result = calculator.ctg(1.0);
        Assert.assertEquals(result, Math.tanh(1.0), "Проверка провалилась. Результат выполнения метода >ctg< некорректен");
    }
}
