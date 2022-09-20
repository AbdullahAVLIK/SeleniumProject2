package practise;

import org.junit.*;
import org.openqa.selenium.WebDriver;

public class C02_JUnit {
    WebDriver driver;
    @BeforeClass
    public static void setup() {
        System.out.println("BeforeClass :");//her class da ilk çalışır bir kere çalışır
    }
    @Before
    public void setUp() {
        System.out.println("Before :");//her testen önce çalışır, her test için tekrar çalısır
    }
    @After
    public void tearDown() {
        System.out.println("After :");
    }
    @AfterClass
    public static void tearDown2() {
        System.out.println("AfterClass :");

    }

    @Test
    @Ignore("Test 01 ignore edildi")
    public void test1(){// testleri alfabetik natural sıralı çalıştırır.
        System.out.println("Test 01 :");

    }
    @Test
    public void test2(){
        System.out.println("Test 02 :");

    }
    @Test
    public void test3(){
        System.out.println("Test 03 :");

    }
    //https://api.socrative.com/rc/Aquv3u
}
