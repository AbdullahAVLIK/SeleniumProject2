package day10;

import org.junit.Test;
import utilities.TestBase_BeforeClassAfterClass;

public class C02_IlkTestBaseClass extends TestBase_BeforeClassAfterClass {

    @Test
    public void test1() {
        driver.get("https://www.amazon.com");
    }

}
