package module_5.lesson_1.homeworkUnitTesting.homeworkUnitTesting.src.main.java.org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultDoubleCalculatorTest extends BaseTest {

    @Test(groups = {"math"})
    public void multDoubleTest() {
        double result = calculator.mult(2.5, 2);
        Assert.assertEquals(result, 5.0, "Проверка провалилась. Результат выполнения метода >mult (double)< некорректен");
    }
}
