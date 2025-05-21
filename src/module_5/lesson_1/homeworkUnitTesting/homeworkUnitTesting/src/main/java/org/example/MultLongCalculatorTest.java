package module_5.lesson_1.homeworkUnitTesting.homeworkUnitTesting.src.main.java.org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MultLongCalculatorTest extends BaseTest {

    @Test(groups = {"math"})
    public void multLongTest() {
        long result = calculator.mult(3L, 4L);
        Assert.assertEquals(result, 12L, "Проверка провалилась. Результат выполнения метода >mult (Long)< некорректен");
    }
}
