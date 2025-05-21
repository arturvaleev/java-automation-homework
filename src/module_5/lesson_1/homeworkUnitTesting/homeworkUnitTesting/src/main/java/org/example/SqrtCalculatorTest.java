package module_5.lesson_1.homeworkUnitTesting.homeworkUnitTesting.src.main.java.org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SqrtCalculatorTest extends BaseTest {

    @Test(groups = {"trig"})
    public void sqrtTest() {
        double result = calculator.sqrt(9.0);
        Assert.assertEquals(result, 3.0, "Проверка провалилась. Результат выполнения метода >sqrt< некорректен");
    }
}
