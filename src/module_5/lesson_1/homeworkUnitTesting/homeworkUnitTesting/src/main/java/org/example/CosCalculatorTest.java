package module_5.lesson_1.homeworkUnitTesting.homeworkUnitTesting.src.main.java.org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CosCalculatorTest extends BaseTest {

    @Test(groups = {"trig"})
    public void cosTest() {
        double result = calculator.cos(1.0);
        Assert.assertEquals(result, Math.cos(1.0), "Проверка провалилась. Результат выполнения метода >cos< некорректен");
    }
}
