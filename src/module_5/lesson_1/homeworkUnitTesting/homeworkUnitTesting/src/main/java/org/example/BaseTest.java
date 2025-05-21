package module_5.lesson_1.homeworkUnitTesting.homeworkUnitTesting.src.main.java.org.example;

import com.epam.tat.module4.Calculator;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected Calculator calculator;

    @BeforeClass(groups = {"math", "trig", "positiveOrNegative"})
    public void setUp() {
        calculator = new Calculator();
    }

    @AfterClass(groups = {"math", "trig", "positiveOrNegative"})
    public void tearDown() {
        calculator = null;
    }
}
