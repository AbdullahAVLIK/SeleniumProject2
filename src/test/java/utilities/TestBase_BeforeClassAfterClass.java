package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TestBase_BeforeClassAfterClass {
    public static WebDriver driver;
    LocalDateTime date = LocalDateTime.now();
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("YYMMddHHmmss");
    public String tarih =date.format(dtf);

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }
    @AfterClass
    public static void tearDown() {
        //driver.quit();
    }
}
