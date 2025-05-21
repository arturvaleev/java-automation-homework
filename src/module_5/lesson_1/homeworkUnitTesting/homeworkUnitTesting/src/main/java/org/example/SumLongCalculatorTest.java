package module_5.lesson_1.homeworkUnitTesting.homeworkUnitTesting.src.main.java.org.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SumLongCalculatorTest extends BaseTest {

    @Test(groups = {"math"})
    public void sumLongTest() {
        long result = calculator.sum(5L, 7L);
        Assert.assertEquals(result, 12L, "Проверка провалилась. Результат выполнения метода >sum (Long)< некорректен");
    }
}
