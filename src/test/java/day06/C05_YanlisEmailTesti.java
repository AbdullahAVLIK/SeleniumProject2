package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_YanlisEmailTesti {
    WebDriver driver;
    //Bir Class olusturalim YanlisEmailTesti
    //http://automationpractice.com/index.php sayfasina gidelim
    //Sign in butonuna basalim
    //Email kutusuna @isareti olmayan bir mail yazip enter’a
    //bastigimizda “Invalid email address” uyarisi ciktigini test edelim

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //http://automationpractice.com/index.php sayfasina gidelim
        driver.get("http://automationpractice.com/index.php");
    }

    @Test
    public void test1() throws InterruptedException {
        //<a class="login" href="http://automationpractice.com/index.php?controller=my-account" rel="nofollow"
        // title="Log in to your customer account">Sign in</a>

        //Sign in butonuna basalim
        WebElement signIn = driver.findElement(By.xpath("//a[@class='login']"));
        signIn.click();
        //Email kutusuna @isareti olmayan bir mail yazip enter’a
        //bastigimizda “Invalid email address” uyarisi ciktigini test edelim

        //<input type="text" class="is_required validate account_input form-control"
        //data-validate="isEmail" id="email_create" name="email_create" value="">

        Thread.sleep(2000);
        WebElement email = driver.findElement(By.xpath("//input[@id='email_create'] "));
        email.sendKeys("abdullah.gmail.com"+ Keys.ENTER);

        //<li>Invalid email address.</li>
        WebElement invalid = driver.findElement(By.xpath("//li[text()='Invalid email address.']"));
        Thread.sleep(2000);
        invalid.click();
        System.out.println("invalid.getText() = " + invalid.getText());
        String expectedText = "Invalid email address.";
        String actualText = invalid.getText();
        //Assert.assertEquals(actualText,expectedText);
        Assert.assertTrue("Account Error Message",actualText.contains(expectedText));

    }
    @After
    public void tearDown(){
        driver.close();
    }

}
