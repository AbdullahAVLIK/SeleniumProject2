package practise;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_LoginTest {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {
        ////https://qa-environment.koalaresorthotels.com/ sayfasına gidiniz.
        driver.get("https://www.koalaresorthotels.com/");
        //Login butonuna tıklayınız:
        driver.findElement(By.xpath("//a[text()='Log in']")).click();
        //Login ekranına gelindiğini 4 farklı şekilde test ediniz
        // 1:
        String expectedURL = "https://www.koalaresorthotels.com/Account/Logon";
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals("Login Ekranına Giriş Yapılmadı", expectedURL, actualURL);
        // 2:
        WebElement userName = driver.findElement(By.xpath("//input[@id='UserName']"));
        Assert.assertTrue("Login Ekranına Giriş Yapılmadı",userName.isDisplayed());
        // 3:
        Assert.assertTrue("Login Ekranına Giriş Yapılmadı",driver.getTitle().contains("Log in"));
        //mesaj test fail olduğunda gözükecektir.
        // 4:
        WebElement passWord = driver.findElement(By.xpath("//input[@id='Password']"));
        Assert.assertTrue("Login Ekranına Giriş Yapılmadı",passWord.isEnabled());
        // 5:
        WebElement login = driver.findElement(By.xpath("//input[@id='btnSubmit']"));
        System.out.println("login.getText() = " + login.getText());
        Assert.assertTrue(login.isEnabled());

    }

}
