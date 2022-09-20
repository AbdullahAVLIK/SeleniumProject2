package day10;

import org.junit.Test;
import utilities.TestBase_BeforeAfter;

public class C01_IlkTestBaseClass extends TestBase_BeforeAfter {
    @Test
    public void test1(){
        driver.get("https://www.amazon.com");

    }

}
