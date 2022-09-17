package day08;

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

public class C04_Iframe {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test1() throws InterruptedException {
        //https://html.com/tags/iframe/ adresine gidiniz

        driver.get("https://html.com/tags/iframe/");
        Thread.sleep(2000);
        WebElement youtubeFrame = driver.findElement
        (By.xpath("//*[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(youtubeFrame);
        //<button class="ytp-large-play-button ytp-button ytp-large-play-button-red-bg" aria-label="Play">
        driver.findElement(By.xpath("//button[@aria-label='Play']")).click();
        Thread.sleep(2000);

    }
}
