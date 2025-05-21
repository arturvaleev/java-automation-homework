package module_5.lesson_1.homeworkUnitTesting.homeworkUnitTesting.src.main.java.org.example;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubLongCalculatorTest extends BaseTest {

    @Test(groups = {"math"})
    public void subLongTest() {
        long result = calculator.sub(10L, 4L);
        Assert.assertEquals(result, 6L, "Проверка провалилась. Результат выполнения метода >sub (Long)< некорректен");
    }
}
