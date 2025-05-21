package module_5.lesson_1.homeworkUnitTesting.homeworkUnitTesting.src.main.java.org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SinCalculatorTest extends BaseTest {

    @Test(groups = {"trig"})
    public void sinTest() {
        double result = calculator.sin(1.0);
        Assert.assertEquals(result, Math.sin(1.0), "Проверка провалилась. Результат выполнения метода >sin< некорректен");
    }
}
