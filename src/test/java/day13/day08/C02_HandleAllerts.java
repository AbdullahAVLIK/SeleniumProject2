package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleAllerts {
    //https://the-internet.herokuapp.com/javascript_alerts adresinegidin.
    //Bir metod olusturun:acceptAlert
    //○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    // “You successfully clicked an alert” oldugunu testedin.
    //Bir metod olusturun:dismissAlert
    //○2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve resultmesajının
    //“successfuly” icermedigini testedin.
    //●Bir metod olusturun:sendKeysAlert
    //○3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OKbutonuna
    //tıklayın ve result mesajında isminizin görüntülendiğinidoğrulayın.
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //●https://the-internet.herokuapp.com/javascript_alerts adresinegidin.
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void test1() throws InterruptedException {
        //Bir metod olusturun:acceptAlert
        //○1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        // “You successfully clicked an alert” oldugunu testedin.
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        //allert üzerindeki mesajı yazdırın
        System.out.println("driver.switchTo().alert().getText 1 = " + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        WebElement acıklama = driver.findElement(By.xpath("//p[@id='result']"));
        String expectedText ="You successfully clicked an alert";
        String actualText =acıklama.getText();

        Assert.assertEquals(expectedText,actualText);
    }
    @Test
    public void test2() throws InterruptedException {
        Thread.sleep(2000);
        //Bir metod olusturun:dismissAlert
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
        //“successfuly” icermedigini testedin.
        //<button onclick="jsConfirm()">Click for JS Confirm</button>
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        Thread.sleep(3000);
        //allert üzerindeki mesajı yazdırın
        System.out.println("driver.switchTo().alert().getText 2 = " + driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        String actualText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedText = "successfuly";
        Assert.assertFalse(actualText.contains(expectedText));
    }
    @Test
    //●Bir metod olusturun:sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
    //tıklayın ve result mesajında isminizin görüntülendiğinidoğrulayın.
    public void test3() throws InterruptedException {
        Thread.sleep(2000);
        driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
        //allert üzerindeki mesajı yazdırın
        System.out.println("driver.switchTo().alert().getText 3 = " + driver.switchTo().alert().getText());
        Thread.sleep(2000);
        driver.switchTo().alert().sendKeys("abdullah");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        String actualText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedText ="abdullah";
        Assert.assertTrue(actualText.contains(expectedText));
    }
    @AfterClass
    public static void tearDown() {
        driver.close();
    }
}
