package day09;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_HandleWindows {
    /*
    //Eğer bize verilen task'te sayfalar arası geçiş varsa her driver.get() methodundan sonra
    //driver'ın window handle değerini string bir değişkene atarız
    //Sonrasında farklı bir sayfaya ya da sekmeye gittikten sonra tekrar ilk sayfaya dönmemiz istenirse
    //String değişkene atadığımız window handle değerleriyle sayfalar arası geçiş yapabiliriz
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() {
       driver.quit();

    }
    @Test
    public void test1() throws InterruptedException {
        ////1- Amazon Sayfasina girelim
        driver.get("https://www.amazon.com");
        String amazonWindowHandle= driver.getWindowHandle();
        ////2- Url'nin amazon içerdiğini test edelim
        String expectedUrl = "amazon";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        ////3- Yeni bir pencere açıp bestbuy anasayfasına gidelim.(https://www.bestbuy.com)
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.bestbuy.com");
        String bestBuyWindowHandle =driver.getWindowHandle();
        ////4- title'in BestBuy içerdiğini test edelim
        String expectedTitle = "Best Buy";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        ////5- İlk sayfaya dönüp sayfada java aratalım
        driver.switchTo().window(amazonWindowHandle);
        WebElement searchBoox =driver.findElement(By.id("twotabsearchtextbox"));
        searchBoox.sendKeys("java", Keys.ENTER);
        ////6- Arama sonuclarının java içerdiğini test edelim
        WebElement aramaSonucu = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedText = "java";
        String actualText = aramaSonucu.getText();
        Assert.assertTrue(actualText.contains(expectedText));
        ////7- Yeniden bestbuy sayfasına gidelim
        driver.switchTo().window(bestBuyWindowHandle);
        ////8- Logonun görünürlüğünü test edelim
        WebElement logo=driver.findElement(By.xpath("(//img[@alt='Best Buy Logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());

        ////9- Sayfaları Kapatalım


    }
}
