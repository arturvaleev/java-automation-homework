package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;


public class SumDoubleCalculatorTest extends BaseTest {

    @Test(groups = {"math"})
    public void sumDoubleTest() {
        double result = calculator.sum(1.25, 1.25);
        Assert.assertEquals(result, 2.5, "Проверка провалилась. Результат выполнения метода >sum (double)< некорректен");
    }
}
