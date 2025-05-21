package module_5.lesson_1.homeworkUnitTesting.homeworkUnitTesting.src.main.java.org.example;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class SumDoubleCalculatorTestWithParam extends BaseTest{

    @Test
    @Parameters({"a", "b", "expected"})
    public void sumXmlParamTest(double a, double b, double expected) {
        double result = calculator.sum(a, b);
        Assert.assertEquals(result, expected, "Проверка провалилась. Результат выполнения метода >sum (double)< некорректен");
    }
}
