package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class EDevlet {
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
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.turkiye.gov.tr/");
        driver.findElement(By.xpath("//a[@aria-label='Giriş Yap']")).click();
        WebElement tc = driver.findElement(By.xpath("//input[@name='tridField']"));
        WebElement sifre = driver.findElement(By.xpath("//input[@name='egpField']"));
        WebElement giris = driver.findElement(By.xpath("//input[@name='submitButton']"));
        tc.sendKeys("32032779340");
        Thread.sleep(2000);
        sifre.sendKeys("asd2307.");
        Thread.sleep(2000);
        giris.click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='modal-btn next']")).click();
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='searchField']"));
        Thread.sleep(2000);
        searchBox.sendKeys("BTK AKADEMİ", Keys.ENTER);
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@class='service']")).click();
        driver.findElement(By.xpath("//a[text()='Uygulamaya Git']")).click();

    }
}
