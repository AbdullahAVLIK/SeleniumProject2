package day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Allerts {
    // https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
    // Click for is Alert butonuna tıklayalım
    //tıkladıkdan sonra çıkan uyarı mesajına tamam diyelim.
    WebDriver driver;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        // https://the-internet.herokuapp.com/javascript_alerts adresine gidelim
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @Test
    public void test1() throws InterruptedException {
        // Click for is Alert butonuna tıklayalım
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();



    }
}
